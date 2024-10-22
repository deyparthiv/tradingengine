package java.pd;

public interface IOrderEntryOrderbook extends  IReadOnlyOrderbook {
    void addOrder(Order order);
    void changeOrder(ModifyOrder modifyOrder);
    void removeOrder(CancelOrder cancelOrder);

}
