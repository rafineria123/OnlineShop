package backend.menu.implementations;

import backend.config.ApplicationContext;
import backend.menu.Menu;
import backend.services.ProductManagementService;
import backend.services.implementations.DefaultProductManagementService;

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
        // <write your code here>
    }

    @Override
    public void printMenuHeader() {
        // <write your code here>
    }

}