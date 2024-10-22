package java.pd;

public class CancelOrder implements IOrderCore{
    private final IOrderCore orderCore;
    CancelOrder(IOrderCore orderCore){
        this.orderCore = orderCore;
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
