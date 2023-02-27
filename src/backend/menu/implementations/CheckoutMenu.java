package backend.menu.implementations;

import backend.config.ApplicationContext;
import backend.entities.Order;
import backend.entities.Product;
import backend.entities.implementations.DefaultOrder;
import backend.menu.Menu;
import backend.services.OrderManagementService;
import backend.services.implementations.DefaultOrderManagementService;

import java.util.Scanner;

public class CheckoutMenu implements Menu {

    private ApplicationContext context;
    private OrderManagementService orderManagementService;

    {
        context = ApplicationContext.getInstance();
        orderManagementService = DefaultOrderManagementService.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        if (context.getLoggedInUser() == null) {
            System.out.println("You are not logged in. Please, sign in or create new account");
            context.getMainMenu().start();
        }else if(context.getSessionCart().isEmpty()){
            System.out.println("Your cart is empty. Please, add product to cart first and then proceed with checkout");
            new ProductCatalogMenu().start();
        }else {
            while(true) {
                System.out.println("Enter your credit card number without spaces and press enter if you confirm purchase");
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                Order order = new DefaultOrder();
                if (!order.isCreditCardNumberValid(input)) {
                    System.out.println("You entered invalid credit card number. Valid credit card should contain 16 digits. Please, try one more time.");
                    continue;
                }
                order.setCreditCardNumber(input);
                order.setProducts(context.getSessionCart().getProducts().toArray(Product[]::new));
                order.setCustomerId(context.getLoggedInUser().getId());
                orderManagementService.addOrder(order);
                System.out.println("Thanks a lot for your purchase. Details about order delivery are sent to your email.");
                context.getSessionCart().clear();
                break;
            }
            context.getMainMenu().start();

        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("*** CHECKOUT ***");
    }


}
