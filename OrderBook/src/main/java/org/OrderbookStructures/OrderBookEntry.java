package org.OrderbookStructures;

import org.OrderbookStructures.Orders.Order;

import java.time.Instant;
import java.util.Date;

public class OrderBookEntry {
    private final Order currentOrder;
    public Limit parentLimit;
    private final Date creationTime;
    OrderBookEntry next;
    OrderBookEntry previous;
    public OrderBookEntry(Order currentOrder, Limit parentLimit){
        creationTime = Date.from(Instant.now()); //set time first
        this.currentOrder = currentOrder;
        this.parentLimit = parentLimit;
    }
    public OrderBookEntry getNext(){
        return this.next;
    }
    public void setNext(OrderBookEntry entry){
        this.next = entry;
    }
    public OrderBookEntry getPrevious(){
        return this.previous;
    }
    public void setPrevious(OrderBookEntry entry){
        this.previous = entry;
    }
    public Order getCurrentOrder() {
        return currentOrder;
    }

}
