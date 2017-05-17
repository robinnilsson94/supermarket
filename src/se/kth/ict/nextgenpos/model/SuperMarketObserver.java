package se.kth.ict.nextgenpos.model;

/** 
 * A listener interface for receiving notifications about 
 * registered items. The class that is interested in such 
 * notifications implements this interface.
 */ 
public interface SuperMarketObserver {
    
    /** 
     * Invoked when a new item is registered. 
     * 
     * @param registeredItem The registered item. 
     */ 
    void newItem(String registeredItem);
}
