package java.pd;

import java.util.Comparator;

public class AskLimitComparator implements Comparator<Limit> {
    @Override
    public int compare(Limit o1, Limit o2) {
        if(o1.price == o2.price) return 0;
        else if(o1.price < o2.price) return -1;
        else return 1;
    }
}
