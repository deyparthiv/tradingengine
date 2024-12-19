package TradingEngineServerConfiguration;

public class TradingEngineServerConfiguration implements ITradingServerConfiguration {
    private final Integer port;
    public TradingEngineServerConfiguration(int port){
        this.port = port;
    }
    public int getPort(){return this.port;}
}
