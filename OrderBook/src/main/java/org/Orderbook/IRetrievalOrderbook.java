package org.Orderbook;
import org.OrderbookStructures.OrderBookEntry;
import java.util.List;

public interface IRetrievalOrderbook extends IOrderEntryOrderbook{
    List<OrderBookEntry> getAskOrders();
    List<OrderBookEntry> getBidOrders();
}
