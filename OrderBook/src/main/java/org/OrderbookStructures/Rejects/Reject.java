package org.OrderbookStructures.Rejects;
import org.OrderbookStructures.Orders.IOrderCore;
import org.OrderbookStructures.Orders.Order;

public class Reject implements IOrderCore {
    public enum RejectionReason{
        UNKNOWN,
        ORDER_NOT_FOUND,
        INSTRUMENT_NOT_FOUND,
        ATTEMPTING_TO_MODIFY_WRONG_SIDE
    }
    private final RejectionReason rejectionReason;
    private final IOrderCore orderCore;
    public Reject(IOrderCore rejectedOrder, RejectionReason reason){
        this.orderCore = rejectedOrder;
        this.rejectionReason = reason;
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
    public RejectionReason getRejectionReason(){
        return this.rejectionReason;
    }
}
