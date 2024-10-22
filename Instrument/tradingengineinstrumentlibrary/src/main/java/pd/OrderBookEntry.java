package java.pd;

import java.time.LocalDateTime;

public class OrderBookEntry {
    Order currentOrder;
    Limit parentLimit;
    LocalDateTime creationTime;
    OrderBookEntry next;
    OrderBookEntry previous;
    OrderBookEntry(Order currentOrder, Limit parentLimit){
        this.currentOrder = currentOrder;
        this.parentLimit = parentLimit;
        creationTime = LocalDateTime.now();
    }
}
