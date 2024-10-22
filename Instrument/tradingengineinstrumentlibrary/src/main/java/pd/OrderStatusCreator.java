package java.pd;

public final class OrderStatusCreator {
    public static CancelOrderStatus generateCancelOrderStatus(CancelOrder cancelOrder){
        return new CancelOrderStatus();
    }
    public static NewOrderStatus generateNewOrderStatus(Order order){
        return new NewOrderStatus();
    }
    public static ModifyOrderStatus generateModifyOrderStatus(ModifyOrder modifyOrder){
        return new ModifyOrderStatus();
    }
}
