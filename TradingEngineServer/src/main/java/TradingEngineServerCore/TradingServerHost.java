package TradingEngineServerCore;

import Logger.ILogger;
import TradingEngineServerConfiguration.ITradingServerConfiguration;

/**
 * This class is where clients trying to connect to the server will be handled
 */
public class TradingServerHost {
    ILogger logger;
    ITradingServerConfiguration configuration;
    public void startServer(){
        TradingEngineServer server = new TradingEngineServer.TradingEngineServerBuilder(logger,configuration).buildTradingEngineServer();
    }
    public static void main(String[] args){

    }
}
