package java.pd;

public record OrderRecord(long orderId, int quantity, long price, boolean isBuySide, String username, int securityId, int TheoreticalQueuePosition) {}
