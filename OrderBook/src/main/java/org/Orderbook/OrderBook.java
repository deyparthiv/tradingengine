package org.Orderbook;

import org.OrderbookStructures.AskLimitComparator;
import org.OrderbookStructures.BidLimitComparator;
import org.OrderbookStructures.Limit;
import org.OrderbookStructures.OrderBookEntry;
import org.OrderbookStructures.Orders.Order;
import org.OrderbookStructures.Orders.ModifyOrder;
import org.OrderbookStructures.Orders.CancelOrder;

import java.security.Security;
import java.util.*;

public class OrderBook implements IRetrievalOrderbook{
    private final Security instrument;
    private final Map<Long, OrderBookEntry> orders = new HashMap<>();
    private SortedSet<Limit> askLimits = new TreeSet<>(AskLimitComparator.getComparator());
    private SortedSet<Limit> bidLimits = new TreeSet<>(BidLimitComparator.getComparator());
    public OrderBook(Security instrument){
        this.instrument = instrument;
    }

    private static void addOrder(Order order, Limit baseLimit, SortedSet<Limit> limitLevels, Map<Long, OrderBookEntry> internalOrderBook){
        if(limitLevels.contains(baseLimit)){
            OrderBookEntry orderBookEntry = new OrderBookEntry(order, baseLimit);
            if(baseLimit.head == null){
                baseLimit.head = orderBookEntry;
                baseLimit.tail = orderBookEntry;
            }
            else{
                OrderBookEntry tailPointer = baseLimit.tail;
                tailPointer.setNext(orderBookEntry);
                orderBookEntry.setPrevious(tailPointer);
            }
            internalOrderBook.put(order.getOrderId(), orderBookEntry);
        }
        else{
            OrderBookEntry orderBookEntry = new OrderBookEntry(order,baseLimit);
            limitLevels.add(baseLimit);
            baseLimit.head = orderBookEntry;
            baseLimit.tail = orderBookEntry;
            internalOrderBook.put(order.getOrderId(),orderBookEntry);
        }


    }

    @Override
    public void addOrder(Order order) {
        Limit baseLimit = new Limit(order.getPrice());
        addOrder(order, baseLimit, order.isBuySide() ? bidLimits : askLimits, orders);
    }

    @Override
    public void changeOrder(ModifyOrder modifyOrder) {
        if(orders.containsKey(modifyOrder.getOrderId())){
            OrderBookEntry orderBookEntry = orders.get(modifyOrder.getOrderId());
            removeOrder(modifyOrder.toCancelOrder());
            addOrder(modifyOrder.toNewOrder(),orderBookEntry.parentLimit,
                    modifyOrder.isBuySide() ? bidLimits:askLimits,orders);
        }
    }

    @Override
    public void removeOrder(CancelOrder cancelOrder) {
        if(orders.containsKey(cancelOrder.getOrderId())) removeOrder(cancelOrder.getOrderId(),
                orders.get(cancelOrder.getOrderId()), orders);
        else{

        }
    }
    private static void removeOrder(long orderId, OrderBookEntry obe, Map<Long, OrderBookEntry> internalBook){
        if(obe.getPrevious() !=null && obe.getNext() !=null){
            obe.getNext().setPrevious(obe.getPrevious());
            obe.getPrevious().setNext(obe.getNext());
        }
        else if(obe.getPrevious() !=null){
            obe.getPrevious().setNext(null);
        }
        else if(obe.getNext() !=null){
            obe.getNext().setPrevious(null);
        }

        if(obe.parentLimit.head == obe && obe.parentLimit.tail == obe){
            obe.parentLimit.head = null;
            obe.parentLimit.tail = null;
        }
        else if(obe.parentLimit.head == obe){
            obe.parentLimit.head = obe.getNext();
        }
        else if(obe.parentLimit.tail == obe){
            obe.parentLimit.tail = obe.getPrevious();
        }
        internalBook.remove(orderId);
    }

    @Override
    public boolean containsOrder(long orderId) {
        return orders.containsKey(orderId);
    }

    @Override
    public OrderBookSpread getSpread() {
        Long bestAsk = null, bestBid = null;
        if(!askLimits.isEmpty() && !askLimits.first().isEmpty()){
            bestAsk = askLimits.first().getPrice();
        }
        if(!bidLimits.isEmpty() && !bidLimits.last().isEmpty()){
            bestBid = bidLimits.last().getPrice();
        }
        return new OrderBookSpread(bestBid,bestAsk);
    }

    @Override
    public int count() {
        return orders.size();
    }
    @Override
    public List<OrderBookEntry> getAskOrders() {
        List<OrderBookEntry>  askOrders= new ArrayList<>();
        for(Limit askLimit : askLimits){
            if(askLimit.isEmpty()) continue;
            else{
                OrderBookEntry askLimitPointer = askLimit.head;
                while(askLimitPointer!=null){
                    askOrders.add(askLimitPointer);
                    askLimitPointer= askLimitPointer.getNext();
                }
            }
        }
        return askOrders;
    }

    @Override
    public List<OrderBookEntry> getBidOrders() {
        List<OrderBookEntry>  bidOrders= new ArrayList<>();
        for(Limit bidLimit : bidLimits){
            if(bidLimit.isEmpty()) continue;
            else{
                OrderBookEntry askLimitPointer = bidLimit.head;
                while(askLimitPointer!=null){
                    bidOrders.add(askLimitPointer);
                    askLimitPointer= askLimitPointer.getNext();
                }
            }
        }
        return bidOrders;
    }
}
