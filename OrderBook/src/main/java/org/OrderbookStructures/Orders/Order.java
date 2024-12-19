package org.OrderbookStructures.Orders;

public class Order implements IOrderCore {
    /**
     *
     */
    private final IOrderCore orderCore;
    private final long price;
    private final int initialQuantity;
    private int currentQuantity;
    private final boolean isBuySide;
    public Order(IOrderCore orderCore, long price, int quantity, boolean isBuySide){
        this.orderCore = orderCore;
        this.price = price;
        this.initialQuantity = quantity;
        this.currentQuantity = quantity;
        this.isBuySide = isBuySide;
    }

    public Order(ModifyOrder modifyOrder){
        this(modifyOrder,modifyOrder.getModifyPrice(),modifyOrder.getModifyQuantity(),modifyOrder.isBuySide());
    }
    @Override
    public long getOrderId() {return orderCore.getOrderId();}
    @Override
    public String getUsername() {return orderCore.getUsername();}
    @Override
    public int getSecurityId() {return orderCore.getSecurityId();}
    public boolean isBuySide() {return isBuySide;}
    public long getPrice() {return price;}
    public int initialQuantity() {return initialQuantity;}
    public int getCurrentQuantity() {return currentQuantity;}
    public void increaseQuantity(int quantityDelta){
        if(quantityDelta<0) throw new IllegalArgumentException();
        else currentQuantity+=quantityDelta;
    }
    public void decreaseQuantity(int quantityDelta){
        if(quantityDelta<0 || quantityDelta > currentQuantity) throw new IllegalArgumentException();
        else quantityDelta-=quantityDelta;
    }
}
