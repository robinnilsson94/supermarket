package se.kth.ict.nextgenpos.view;

import java.io.IOException;
import se.kth.ict.nextgenpos.controller.Controller;
import se.kth.ict.nextgenpos.model.ItemNotFoundException;
import se.kth.ict.nextgenpos.util.LogHandler;
/**
 * A placeholder for the view.
 */
public class View {
    private Controller cont;
    private ErrorMessageHandler errorMsgHandler = new ErrorMessageHandler();
    private LogHandler logger;

    /**
     * Creates a new <code>View</code>.
     * @param cont           The controller of the application.
     */
    public View(Controller cont)throws IOException  {
	this.cont = cont;
        cont.addSuperMarketObserver(new RegisteredItemsDisplay()); 
        this.logger = new LogHandler();
    }

    /**
     * Simulates a view. Makes some calls to the controller.
     */
    public void test() {
	 try {
             cont.makeNewSale();
             enterItem(1);
             System.out.println(">>>>> NOTE!!\n" +
			   "A null pointer exception will follow since there is no handling" + 
			   " of non-existing item ids. When you have implemented exception" +
			   " handling, there should be some informative printout instead of the" +
			   " exception stack trace.");
             enterItem(10);
             
             try{
                cont.enterItem(3,2);}
             catch (ItemNotFoundException infexc) {
            handleException("Item wasn't found in the catalog.", infexc);
            System.out.println("");
         }
        
        }
         catch (Exception exc) {
            handleException("Failed to find the item, please try again.", exc);}
	
    }

    private void enterItem(int itemId) {
	int quantity = 1;
	System.out.println("");
	try{
            System.out.println("Result for item " + itemId + ": " + cont.enterItem(itemId, quantity));
        }
	catch (ItemNotFoundException infexc) {
            handleException("Item wasn't found in the catalog.", infexc);
            System.out.println("");
        }
    }
    private void handleException(String uiMsg, Exception exc) {
        errorMsgHandler.showErrorMsg(uiMsg);
        logger.logException(exc);
    }
}
