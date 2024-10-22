package java.pd;

public class ModifyOrder implements IOrderCore{
    final long price;
    final IOrderCore orderCore;
    final int quantity;
    final boolean isBuySide;
    ModifyOrder(IOrderCore orderCore, long modifyPrice, int modifyQuantity, boolean isBuySide){
        this.price = modifyPrice;
        this.quantity = modifyQuantity;
        this.isBuySide = isBuySide;
        this.orderCore = orderCore;
    }
    public CancelOrder toCancelOrder(){
        return new CancelOrder(this);
    }
    public Order toNewOrder(){
        return new Order(this);
    }
    @Override
    public long getOrderId() {
        return orderCore.getOrderId();
    }

    @Override
    public String getUsername() {
        return orderCore.getUsername();
    }

    @Override
    public int getSecurityId() {
        return orderCore.getSecurityId();
    }
}
