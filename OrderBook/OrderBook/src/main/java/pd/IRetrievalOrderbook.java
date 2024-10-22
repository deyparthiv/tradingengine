package java.pd;

import java.util.List;

public interface IRetrievalOrderbook extends IOrderEntryOrderbook{
    List<OrderBookEntry> getAskOrders();
    List<OrderBookEntry> getBidOrders();
}
