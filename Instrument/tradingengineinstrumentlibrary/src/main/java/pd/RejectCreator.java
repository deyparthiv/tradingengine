package java.pd;

public class RejectCreator {
    public static Reject generateOrderCoreRejection(IOrderCore orderCore,RejectionReason reason){
        return new Reject(orderCore,reason);
    }
}
