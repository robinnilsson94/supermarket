package se.kth.ict.nextgenpos.model;

import java.util.List;
import java.util.ArrayList;

/**
 * Represents a single sale to one customer.
 */
public class Sale {
    private List<SalesLineItem> lineItems;
    private List<SuperMarketObserver> supermarketObservers = new ArrayList<>(); 
    private int currentTotal;
    private int payedAmount;
    private int iterator;
    private String item;
   

    /**
     * Instantiates a new <code>Sale</code>.
     */
    public Sale() {
	lineItems = new ArrayList<SalesLineItem>();
    }

    /**
     * Adds new items to the current <code>Sale</code>. 
     *
     * @param spec            The specification of the items that is added.
     * @param quantity        The number of items.
     */
    public void addItem(ProductSpecification spec, int quantity) {
	SalesLineItem lineItem = new SalesLineItem(spec, quantity);
	lineItems.add(lineItem);
	addToTotal(lineItem);
        item = spec.toString();
        notifyObservers(); 
    }

    private void addToTotal(SalesLineItem lineItem) {
	currentTotal = 
	    currentTotal + lineItem.getCost();
    }

    /**
     * Returns the total cost of all products registered so for.
     *
     * @return The total cost of all products registered so for.
     */
    public int getCurrentTotal() {
	return currentTotal;
    }

    /**
     * Calculates change and returns all information needed for the receipt.
     *
     * @return All information needed for the receipt.
     */
    public Receipt createReceipt(int payedAmount) {
	this.payedAmount = payedAmount;
	return new Receipt(this);
    }

    void resetLineItemIterator() {
	iterator = 0;
    }

    SalesLineItem nextLineItem() {
	return lineItems.get(iterator);
    }

    boolean hasMoreLineItems() {
	return iterator < lineItems.size();
    }

    int getPayedAmount() {
	return payedAmount;
    }
    
     private void notifyObservers() {
         for (SuperMarketObserver obs : supermarketObservers) { 
             obs.newItem(item); 
         } 
     } 
     public void addSuperMarketObserver(SuperMarketObserver obs) { 
         supermarketObservers.add(obs); 
     } 
     /**
     * All the specified observers will be notified when an item is registered.
     * 
     * @param observers The observers to notify. 
     */
    public void addSuperMarketObservers(List<SuperMarketObserver> observers) {
        supermarketObservers.addAll(observers);
    }
}


