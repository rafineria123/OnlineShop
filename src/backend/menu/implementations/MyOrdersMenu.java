package backend.menu.implementations;

import backend.config.ApplicationContext;
import backend.entities.Order;
import backend.menu.Menu;
import backend.services.OrderManagementService;
import backend.services.implementations.DefaultOrderManagementService;

import java.util.Arrays;

public class MyOrdersMenu implements Menu {

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
            System.out.println("Please, log in or create new account to see list of your orders");
        }else{
            Order[] clientOrders = orderManagementService.getOrdersByUserId(context.getLoggedInUser().getId());
            if(clientOrders==null){
            System.out.println("Unfortunately, you don’t have any orders yet.");
            }else {
                System.out.println(Arrays.toString(clientOrders));
            }
        }
        context.getMainMenu().start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("*** MY ORDERS ***");
    }


}