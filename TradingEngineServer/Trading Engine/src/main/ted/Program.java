package ted;

public class Program {
    public static void main(String[] args){
        HostBuilder hostBuilder = new HostBuilder();
        //add params later
        var engine =  hostBuilder.build();
        TradeEngineServerCore.TradingEngineServiceProvider.ServiceProvider = engine.getServices();
    }
}
