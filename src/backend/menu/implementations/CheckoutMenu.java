package backend.menu.implementations;

import backend.config.ApplicationContext;
import backend.menu.Menu;
import backend.services.OrderManagementService;
import backend.services.implementations.DefaultOrderManagementService;

public class CheckoutMenu implements Menu {

    private ApplicationContext context;
    private OrderManagementService orderManagementService;

    {
        context = ApplicationContext.getInstance();
        orderManagementService = DefaultOrderManagementService.getInstance();
    }

    @Override
    public void start() {
        // <write your code here>
    }

    @Override
    public void printMenuHeader() {
        // <write your code here>
    }

}
