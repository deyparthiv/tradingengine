import Logger.Logger;
import TradingEngineServerConfiguration.TradingEngineServerConfiguration;
import TradingEngineServerCore.TradingEngineServer;

public class Main {
    public static void main(String[] args){
        Logger logger = new Logger();
        TradingEngineServerConfiguration config = new TradingEngineServerConfiguration(12000);
        TradingEngineServer engine = new TradingEngineServer
                                        .TradingEngineServerBuilder(logger,config)
                                        .buildTradingEngineServer();
        engine.run();
    }
}
