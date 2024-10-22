package java.pd;

public class OrderCore implements IOrderCore{
    final long orderId;
    final String username;
    final int securityId;
    OrderCore(long orderId, String username, int securityId){
        this.orderId = orderId;
        this.username = username;
        this.securityId = securityId;
    }
    @Override
    public long getOrderId() {return orderId;}

    @Override
    public String getUsername() {return username;}

    @Override
    public int getSecurityId() {return securityId;}
}
