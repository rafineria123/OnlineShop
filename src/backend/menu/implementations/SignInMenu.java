package backend.menu.implementations;

import backend.config.ApplicationContext;
import backend.entities.User;
import backend.menu.Menu;
import backend.services.UserManagementService;
import backend.services.implementations.DefaultUserManagementService;

import java.util.Scanner;

public class SignInMenu implements Menu {

    private ApplicationContext context;
    private UserManagementService userManagementService;

    {
        context = ApplicationContext.getInstance();
        userManagementService = DefaultUserManagementService.getInstance();
    }

    @Override
    public void start() {
        clearConsole();
        printMenuHeader();
        loginUser();

    }

    @Override
    public void printMenuHeader() {
        System.out.println("*** SIGN IN ***" + System.lineSeparator());
    }

    private void loginUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your email: ");
        String email = scanner.nextLine();
        System.out.println(System.lineSeparator() + "Enter your password: ");
        String password = scanner.nextLine();
        User user = userManagementService.getUserByCredentials(email, password);
        if(user==null){
            clearConsole();
            System.out.println("Unfortunately, such login and password doesn’t exist");
        }else {
            context.setLoggedInUser(user);
            clearConsole();
            System.out.println("Glad to see you back " + user.getFirstName() +" " + user.getLastName());
        }
        context.getMainMenu().start();
    }

}
