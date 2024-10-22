package java.pd;

public interface IReadOnlyOrderbook {
    boolean containsOrder(long orderId);
    OrderBookSpread getSpread();
    int count();
}
