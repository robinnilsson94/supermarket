package se.kth.ict.nextgenpos.startup;

import se.kth.ict.nextgenpos.controller.Controller;
import se.kth.ict.nextgenpos.view.View;
import java.io.IOException;

/**
 * Starts the application.
 */
public class Main {
    public static void main(String[] args) {
	try {
            Controller cont = new Controller();
            View view = new View(cont);
            view.test();
        }
	catch (IOException ex) {
            System.out.println("Unable to start the application");
            ex.printStackTrace();
        }
    }
}
