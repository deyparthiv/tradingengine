package org.OrderbookStructures;
import org.OrderbookStructures.Orders.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * one instance of limit represents a price level
 */
public class Limit {
    public enum Side{
        BID,
        ASK,
        UNKNOWN
    }
    private final long price;
    public OrderBookEntry head;
    public OrderBookEntry tail;
    public Limit(long price){
        this.price = price;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public Side getSide(){
        if(this.isEmpty()) return Side.UNKNOWN;
        else return head.getCurrentOrder().isBuySide() ? Side.BID : Side.ASK;
    }

    /**
     *
     * @return returns the number of orders at this price level.
     */
    public int getLevelOrderCount(){
        int counter = 0;
        OrderBookEntry current = head;
        while(current!=null){
            if(current.getCurrentOrder().getCurrentQuantity()!=0)
                counter++;
            current=current.getNext();
        }
        return counter;
    }

    /**
     *
     * @return returns the total quantity of orders at this price leve
     */
    public int getLevelOrderQuantity(){
        int quantity = 0;
        OrderBookEntry current = head;
        while(current!=null){
            quantity+=current.getCurrentOrder().getCurrentQuantity();
            current=current.getNext();
        }
        return quantity;
    }

    public List<OrderRecord> getLevelOrderRecords(){
        List<OrderRecord> orderRecords = new ArrayList<>();
        OrderBookEntry current = head;
        int theoreticalQueuePosition = 0;
        while(current!=null){
            Order currentOrder = current.getCurrentOrder();
            if(currentOrder.getCurrentQuantity()!=0){
                orderRecords.add(new OrderRecord(
                        currentOrder.getOrderId(),
                        currentOrder.getCurrentQuantity(),
                        price, currentOrder.isBuySide(),
                        currentOrder.getUsername(),
                        currentOrder.getSecurityId(),
                        theoreticalQueuePosition));
            }
            theoreticalQueuePosition++;
            current = current.getNext();
        }
        return orderRecords;
    }
    public long getPrice() {
        return price;
    }

}
