package backend.menu.implementations;

import backend.config.ApplicationContext;
import backend.menu.Menu;

import java.util.Scanner;

public class SettingsMenu implements Menu {

    private static final String SETTINGS = "1. Change Password" + System.lineSeparator()
            + "2. Change Email";

    private ApplicationContext context;

    {
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {

        if (context.getLoggedInUser() == null) {
            System.out.println("Please, log in or create new account to change your account settings");
            context.getMainMenu().start();
        } else {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                printMenuHeader();
                String input = scanner.nextLine();
                if (input.equals("menu")) {
                    context.getMainMenu().start();
                    break;
                } else {
                    try {
                        int result = Integer.parseInt(input);
                        if (result < 1 || result > 2) {
                            showInputErrorMessage();
                            continue;
                        } else {
                            if (result == 1) {
                                new ChangePasswordMenu().start();
                                break;
                            } else {
                                new ChangeEmailMenu().start();
                                break;
                            }
                        }
                    } catch (NumberFormatException e) {
                        showInputErrorMessage();
                        continue;
                    }
                }
            }


        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("*** SETTINGS ***" + System.lineSeparator());
        System.out.println(SETTINGS);
        System.out.println("Please, enter a number or 'menu' to navigate back to menu." + System.lineSeparator());
    }

    private void showInputErrorMessage() {
        String invalidNumberError = "Only 1, 2 or 'menu' is allowed. Try one more time" + System.lineSeparator();
        System.out.println(invalidNumberError);
    }

}

