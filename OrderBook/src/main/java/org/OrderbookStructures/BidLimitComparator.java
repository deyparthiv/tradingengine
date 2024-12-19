package org.OrderbookStructures;

import java.util.Comparator;

public class BidLimitComparator implements Comparator<Limit> {
    public static Comparator<Limit> getComparator(){return new BidLimitComparator();}
    @Override
    public int compare(Limit o1, Limit o2) {
        if(o1.getPrice()>o2.getPrice()) return -1;
        else if (o1.getPrice()<o2.getPrice()) return 1;
        else return 0;
    }
}
