package se.kth.ict.nextgenpos.view;

import se.kth.ict.nextgenpos.model.SuperMarketObserver;


/**
 * Shows all registered items.
 */

public class RegisteredItemsDisplay implements SuperMarketObserver {
    

  
    @Override
    public void newItem(String item) {
        
        printCurrentState(item);
    }


    /**
     * Shows the registered items.
     *
     * @param item the specs for the item.
     */
     private void printCurrentState(String item) { 
         System.out.println("### We have now registered ###");
         System.out.print(item);
         System.out.println(""); 
          
          
     }

}
