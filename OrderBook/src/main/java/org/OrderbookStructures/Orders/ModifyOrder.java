package org.OrderbookStructures.Orders;
public class ModifyOrder implements IOrderCore {
    private IOrderCore orderCore;
    private long modifyPrice;
    private int modifyQuantity;
    private boolean isBuySide;
    public ModifyOrder(IOrderCore orderCore, long modifyPrice, int modifyQuantity, boolean isBuySide){
        this.orderCore = orderCore;
        this.modifyPrice = modifyPrice;
        this.modifyQuantity = modifyQuantity;
        this.isBuySide = isBuySide;
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
    public CancelOrder toCancelOrder(){
        return new CancelOrder(this);
    }
    public Order toNewOrder(){
        return new Order(this);
    }

    public long getModifyPrice(){return this.modifyPrice;}
    public int getModifyQuantity(){return this.modifyQuantity;}
    public boolean isBuySide(){return this.isBuySide;}
}
