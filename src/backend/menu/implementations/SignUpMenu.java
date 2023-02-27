package backend.menu.implementations;

import backend.config.ApplicationContext;
import backend.entities.User;
import backend.entities.implementations.DefaultUser;
import backend.menu.Menu;
import backend.services.UserManagementService;
import backend.services.implementations.DefaultUserManagementService;

import java.util.Scanner;

public class SignUpMenu implements Menu {

    private UserManagementService userManagementService;
    private ApplicationContext context;

    {
        userManagementService = DefaultUserManagementService.getInstance();
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        clearConsole();
        printMenuHeader();
        registerUser();

    }

    @Override
    public void printMenuHeader() {
        System.out.println("Sign up Menu" + System.lineSeparator());
    }

    private void registerUser(){
        DefaultUser user = new DefaultUser();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your first name: ");
        user.setFirstName(getUserInput(scanner));
        System.out.println(System.lineSeparator() + "Enter your last name: ");
        user.setLastName(System.lineSeparator() + getUserInput(scanner));
        System.out.println(System.lineSeparator() + "Enter your password: ");
        user.setPassword(getUserInput(scanner));
        System.out.println(System.lineSeparator() + "Enter your email: ");
        user.setEmail(getUserInput(scanner));
        String errorMessage = userManagementService.registerUser(user);
        if(!errorMessage.isEmpty()){
            System.out.println(errorMessage);
        }else {
            System.out.println("New user created!");
            context.setLoggedInUser(user);
        }
        context.getMainMenu().start();
    }

    private String getUserInput(Scanner scanner){
        return scanner.nextLine();
    }

}
