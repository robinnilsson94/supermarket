package se.kth.ict.nextgenpos.model;

/**
 * Thrown when trying to register an item that isn't in the catalog. 
 */
public class ItemNotFoundException extends Exception {
   
 /**
     * Creates a new instance representing the condition described in the specified message.
     *
     * @param itemId The id nr of the item.
     */
    public ItemNotFoundException(int itemId) {
        super("Item with itemid " + itemId + " couldn't be found.");
    }

}

