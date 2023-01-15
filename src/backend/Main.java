package backend;

import backend.menu.Menu;
import backend.menu.implementations.MainMenu;

public class Main {

    public static final String EXIT_COMMAND = "exit";

    public static void main(String[] args) {
        Menu mainMenu = new MainMenu();
        mainMenu.start();
    }

}
