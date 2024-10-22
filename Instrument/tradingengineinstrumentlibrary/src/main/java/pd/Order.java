package java.pd;

public class Order implements IOrderCore {
    final long price;
    final int initialQuantity;

    int currentQuantity;
    final boolean isBuySide;
    final IOrderCore orderCore;
    Order(ModifyOrder modifyOrder){
        this.orderCore = modifyOrder.orderCore;
        this.price = modifyOrder.price;
        this.initialQuantity = modifyOrder.quantity;
        this.isBuySide = modifyOrder.isBuySide;
    }
    Order(IOrderCore orderCore, long price, int quantity, boolean isBuySide) {
        this.price = price;
        this.initialQuantity = quantity;
        this.currentQuantity = quantity;
        this.isBuySide = isBuySide;
        this.orderCore = orderCore;
    }

    public long getPrice() {
        return price;
    }

    public int getInitialQuantity() {
        return initialQuantity;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public boolean isBuySide() {
        return isBuySide;
    }

    public IOrderCore getOrderCore() {
        return orderCore;
    }

    public void increaseQuantity(int quantityDelta) {
        currentQuantity += quantityDelta;
    }

    public void decreaseQuantity(int quantityDelta) {
        if (quantityDelta > currentQuantity) throw new IllegalArgumentException("Quantity Delta > Current Quantity");
        currentQuantity -= quantityDelta;
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
