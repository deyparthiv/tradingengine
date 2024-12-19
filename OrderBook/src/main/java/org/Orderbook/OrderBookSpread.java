package org.Orderbook;

public class OrderBookSpread {
    Long bid; //default value is null
    Long ask;
    OrderBookSpread(Long bid, Long ask){
        this.bid = bid;
        this.ask = ask;
    }
    public Long getSpread(){
        if(bid!=null && ask!=null) return (ask-bid);
        else return null;
    }

    public Long getBid() {
        return bid;
    }

    public Long getAsk() {
        return ask;
    }
}
