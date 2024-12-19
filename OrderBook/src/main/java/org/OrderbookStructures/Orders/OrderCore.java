package org.OrderbookStructures.Orders;
public class OrderCore implements IOrderCore {
    private final long orderId;
    private final String username;
    private final int securityId;
    public OrderCore(long orderId, String username, int securityId){
        this.orderId = orderId;
        this.username = username;
        this.securityId = securityId;
    }
    @Override
    public long getOrderId() {
        return this.orderId;
    }
    @Override
    public String getUsername() {
        return this.username;
    }
    @Override
    public int getSecurityId() {
        return this.securityId;
    }
}
