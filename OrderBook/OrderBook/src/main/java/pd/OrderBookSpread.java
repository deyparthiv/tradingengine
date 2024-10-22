package java.pd;

public class OrderBookSpread {
    Long bid=null;
    Long ask=null;
    OrderBookSpread(Long bid, Long ask){
        this.bid = bid;
        this.ask = ask;
    }
    public Long getSpread(){
        if(bid!=null && ask!=null) return (ask-bid);
        else return null;
    }

}
