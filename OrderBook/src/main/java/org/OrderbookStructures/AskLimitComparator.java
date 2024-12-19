package org.OrderbookStructures;

import java.util.Comparator;

public class AskLimitComparator implements Comparator<Limit> {
    public static Comparator<Limit> getComparator(){return new AskLimitComparator();}
    @Override
    public int compare(Limit o1, Limit o2) {
        if(o1.getPrice()<o2.getPrice()) return -1;
        else if (o1.getPrice()>o2.getPrice()) return 1;
        else return 0;
    }
}
