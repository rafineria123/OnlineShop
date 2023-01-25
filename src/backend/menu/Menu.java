package backend.menu;

import java.util.Scanner;

public interface Menu {


    void start();

    void printMenuHeader();

    default void clearConsole(){
        System.out.flush();
    }

    default int getUserIntInput(Scanner scanner, int maximumOptionNumber) {
        String invalidNumberError = "Please input valid menu number.";
        while (true) {
            try {
                String input = scanner.nextLine();
                int result = Integer.parseInt(input);
                if (result < 1 || result > maximumOptionNumber) {
                    System.out.println(invalidNumberError);
                } else {
                    return result;
                }
            } catch (NumberFormatException e) {
                System.out.println(invalidNumberError);
            }

        }
    }

}