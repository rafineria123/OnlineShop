package backend.menu.implementations;

import backend.config.ApplicationContext;
import backend.menu.Menu;
import backend.services.UserManagementService;
import backend.services.implementations.DefaultUserManagementService;

import java.util.Arrays;
import java.util.Objects;

public class CustomerListMenu implements Menu {

    private ApplicationContext context;
    private UserManagementService userManagementService;

    {
        userManagementService = DefaultUserManagementService.getInstance();
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        context.getMainMenu().start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("*** CUSTOMER LIST ***");
        Arrays.stream(userManagementService.getUsers()).filter(Objects::nonNull).forEach(System.out::println);
    }

}