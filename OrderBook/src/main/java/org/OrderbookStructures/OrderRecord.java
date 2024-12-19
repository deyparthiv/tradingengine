package org.OrderbookStructures;

/**
 * read-only rep of OrderBookEntry
 */
public record OrderRecord(long orderId, int quantity, long price, boolean isBuySide, String username, int securityId, int theoreticalQueuePosition){}
