package java.pd;

import java.util.logging.Logger;

public class TradingEngineServerHostBuilder {
    public static ITradingEngineServer BuildTradingEngineServer(Logger logger, IOptions config ){
        return new TradingEngineServer(logger, config);
    }
}
