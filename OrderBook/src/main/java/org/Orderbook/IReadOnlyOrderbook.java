package org.Orderbook;

public interface IReadOnlyOrderbook {
    boolean containsOrder(long orderId);
    OrderBookSpread getSpread();
    int count();
}
