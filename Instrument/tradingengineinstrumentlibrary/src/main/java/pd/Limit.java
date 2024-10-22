package java.pd;

import java.util.ArrayList;
import java.util.List;

public class Limit {
    Limit(long price){
        this.price = price;
    }
    long price;
    OrderBookEntry head;
    OrderBookEntry tail;
    public boolean isEmpty(){
        return head==null && tail==null;
    }
    public enum Side{
        Unknown,
        Bid,
        Ask
    }
    public Side side(){
        if(this.isEmpty()) return Side.Unknown;
        return head.currentOrder.isBuySide() ? Side.Bid : Side.Ask;
    }
    public int getOrderCount(){
        int orderCount = 0;
        OrderBookEntry current = head;
        while(current!=null){
            if(current.currentOrder.currentQuantity!=0) orderCount++;
            current = current.next;
        }
        return orderCount;
    }
    public int getLevelOrderQuantity(){
        int orderQuantity = 0;
        OrderBookEntry current = head;
        while(current!=null){
            orderQuantity+=current.currentOrder.currentQuantity;
            current=current.next;
        }
        return orderQuantity;
    }

    public List<OrderRecord> getLevelOrderRecords(){
        List<OrderRecord> orderRecords = new ArrayList<>();
        OrderBookEntry current = head;
        int theoreticalQueuePosition = 0;
        while(current!=null){
            Order currentOrder = current.currentOrder;
            if(currentOrder.currentQuantity!=0){
                orderRecords.add(new OrderRecord(
                        currentOrder.getOrderId(), currentOrder.currentQuantity,
                        price, currentOrder.isBuySide, currentOrder.getUsername(),
                        currentOrder.getSecurityId(), theoreticalQueuePosition
                ));
                theoreticalQueuePosition++;
            }
            current=current.next;
        }
        return orderRecords;
    }
}
