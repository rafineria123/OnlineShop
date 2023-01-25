package backend.menu.implementations;

import backend.config.ApplicationContext;
import backend.menu.Menu;
import backend.services.UserManagementService;
import backend.services.implementations.DefaultUserManagementService;

public class SignInMenu implements Menu {

    private ApplicationContext context;
    private UserManagementService userManagementService;

    {
        context = ApplicationContext.getInstance();
        userManagementService = DefaultUserManagementService.getInstance();
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
