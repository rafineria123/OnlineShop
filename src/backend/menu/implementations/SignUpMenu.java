package backend.menu.implementations;

import backend.config.ApplicationContext;
import backend.menu.Menu;
import backend.services.UserManagementService;
import backend.services.implementations.DefaultUserManagementService;

public class SignUpMenu implements Menu {

    private UserManagementService userManagementService;
    private ApplicationContext context;

    {
        userManagementService = DefaultUserManagementService.getInstance();
        context = ApplicationContext.getInstance();
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
