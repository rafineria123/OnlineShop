package backend.menu.implementations;

import backend.config.ApplicationContext;
import backend.menu.Menu;

import java.util.Scanner;

public class ChangeEmailMenu implements Menu {

    private ApplicationContext context;

    {
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        context.getLoggedInUser().setEmail(input);
        System.out.println("Your email has been successfully changed");
        context.getMainMenu().start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("please enter your new email: ");
    }

}