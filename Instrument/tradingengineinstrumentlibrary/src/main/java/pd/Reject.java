package java.pd;

public class Reject implements IOrderCore{
    private final IOrderCore orderCore;
    final RejectionReason rejectionReason;
    Reject(IOrderCore rejectedOrder, RejectionReason rejectionReason ){
        this.orderCore = rejectedOrder;
        this.rejectionReason = rejectionReason;
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
