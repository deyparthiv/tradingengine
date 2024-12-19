package TradingEngineServerCore;


import TradingEngineServerConfiguration.TradingEngineServerConfiguration;
import Logger.Logger;
public class TradingEngineServer implements ITradingEngineServer {
    private final Logger logger;
    private final TradingEngineServerConfiguration config;

    private TradingEngineServer(TradingEngineServerBuilder builder){
        this.logger = builder.logger;
        this.config = builder.config;
    }

    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {

    }

    public static class TradingEngineServerBuilder{
        private Logger logger;
        TradingEngineServerConfiguration config;
        public TradingEngineServerBuilder(Logger logger, TradingEngineServerConfiguration config){
            this.config = config;
            this.logger = logger;
        }

        public TradingEngineServer buildTradingEngineServer(){
            return new TradingEngineServer(this);
        }
    }
}

