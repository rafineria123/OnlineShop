package backend.menu.implementations;

import backend.config.ApplicationContext;
import backend.menu.Menu;

public class SignOutMenu implements Menu {

    private ApplicationContext context;

    {
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        clearConsole();
        printMenuHeader();
        context.setLoggedInUser(null);
        context.getMainMenu().start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("‘Have a nice day! Look forward to welcoming back!");
    }

}
