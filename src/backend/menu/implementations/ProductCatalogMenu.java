package backend.menu.implementations;

import backend.config.ApplicationContext;
import backend.entities.Product;
import backend.menu.Menu;
import backend.services.ProductManagementService;
import backend.services.implementations.DefaultProductManagementService;

import java.util.Arrays;
import java.util.Scanner;

public class ProductCatalogMenu implements Menu {

    private static final String CHECKOUT_COMMAND = "checkout";
    private ApplicationContext context;
    private ProductManagementService productManagementService;

    {
        context = ApplicationContext.getInstance();
        productManagementService = DefaultProductManagementService.getInstance();
    }

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        Menu menuToNavigate = null;
        loop: while(true) {
            printMenuHeader();
            System.out.println("Enter product id to add it to the cart, ‘menu’ if you want to navigate back to the main menu or `checkout` if you want to proceed with checkout");
            String input = scanner.nextLine();
            switch (input) {


                case MainMenu.MENU_COMMAND:
                    menuToNavigate = context.getMainMenu();
                    break loop;


                case ProductCatalogMenu.CHECKOUT_COMMAND:
//                    if (context.getLoggedInUser() == null) {
//                        System.out.println("You are not logged in. Please, sign in or create new account");
//                        menuToNavigate = context.getMainMenu();
//                        break loop;
//                    }
//                    if(context.getSessionCart().isEmpty()){
//                        System.out.println("Your cart is empty. Please, add product to cart first and then proceed with checkout");
//                        continue loop;
//                    }
                    menuToNavigate = new CheckoutMenu();
                    break loop;


                default:
                    if (context.getLoggedInUser() == null) {
                        System.out.println("You are not logged in. Please, sign in or create new account");
                        menuToNavigate = context.getMainMenu();
                        break loop;
                    }

                    int parseResult;
                    try {
                        parseResult = Integer.parseInt(input);
                        Product fetchedProduct = productManagementService.getProductById(parseResult);
                        if(fetchedProduct == null){
                            System.out.println("Please, enter product ID if you want to add product to cart. Or enter 'checkout' if you want to proceed with checkout. Or enter 'menu' if you want to navigate back to the main menu.");
                        }else {
                            context.getSessionCart().addProduct(fetchedProduct);
                            System.out.println("Product " + fetchedProduct.getProductName()+" has been added to your cart.");

                        }
                        continue loop;


                    } catch (NumberFormatException e) {
                        System.out.println("Please, enter product ID if you want to add product to cart. Or enter 'checkout' if you want to proceed with checkout. Or enter 'menu' if you want to navigate back to the main menu.");
                        continue loop;
                    }

            }
        }
        menuToNavigate.start();


    }

    @Override
    public void printMenuHeader() {
        clearConsole();
        System.out.println("*** PRODUCT CATALOG ***");
        Arrays.stream(productManagementService.getProducts()).forEach(System.out::println);
    }


}