package org.Orderbook;
import org.OrderbookStructures.Orders.CancelOrder;
import org.OrderbookStructures.Orders.Order;
import org.OrderbookStructures.Orders.ModifyOrder;


public interface IOrderEntryOrderbook extends IReadOnlyOrderbook {
    void addOrder(Order order);
    void changeOrder(ModifyOrder modifyOrder);
    void removeOrder(CancelOrder cancelOrder);

}
