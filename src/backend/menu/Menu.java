package backend.menu;

import java.util.Scanner;

public interface Menu {


    void start();

    void printMenuHeader();

    default void clearConsole(){
        System.out.flush();
    }

}