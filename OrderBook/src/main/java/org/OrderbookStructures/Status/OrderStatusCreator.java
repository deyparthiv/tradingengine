package org.OrderbookStructures.Status;

import org.OrderbookStructures.Orders.Order;
import org.OrderbookStructures.Orders.ModifyOrder;
import org.OrderbookStructures.Orders.CancelOrder;
public final class OrderStatusCreator {
    public static CancelOrderStatus generateCancelOrderStatus(CancelOrder co){
        return new CancelOrderStatus();
    }
    public static OrderStatus generateNewOrderStatus(Order oer){
        return new OrderStatus();
    }
    public static ModifyOrderStatus generateModifyOrderStatus(ModifyOrder mo){
        return new ModifyOrderStatus();
    }
}
