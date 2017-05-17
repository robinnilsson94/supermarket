package se.kth.ict.nextgenpos.model;

/**
 * Thrown when trying to register an item that isn't in the catalog. 
 */
public class ItemNotFoundException extends Exception {
   
 /**
     * Creates a new instance representing the condition described in the specified message.
     *
     * @param msg A message that describes what went wrong.
     */
    public ItemNotFoundException(String msg) {
        super(msg);
    }

}

