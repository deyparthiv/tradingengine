package org.OrderbookStructures.Rejects;

import org.OrderbookStructures.Orders.IOrderCore;

public final class RejectFactory {
    public static Reject generateOrderCoreRejection(IOrderCore rejectedOrder, Reject.RejectionReason reason){
        return new Reject(rejectedOrder,reason);
    }
}
