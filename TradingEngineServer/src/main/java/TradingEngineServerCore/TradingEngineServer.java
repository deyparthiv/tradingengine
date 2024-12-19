package TradingEngineServerCore;

import MessageProcessors.MessageProcessor;
import Messages.IMessage;
import TradingEngineServerConfiguration.ITradingServerConfiguration;
import Logger.ILogger;
public class TradingEngineServer implements ITradingEngineServer {
    private final ILogger logger;
    private final ITradingServerConfiguration config;

    private final MessageProcessor messageProcessor;
    private TradingEngineServer(TradingEngineServerBuilder builder){
        this.logger = builder.logger;
        this.config = builder.config;
        messageProcessor = new MessageProcessor(this);
    }
    @Override
    public void run() {

    }

    public void processMessage(IMessage message){
        message.accept(messageProcessor);
    }

    public static class TradingEngineServerBuilder{
        private ILogger logger;
        ITradingServerConfiguration config;
        public TradingEngineServerBuilder(ILogger logger, ITradingServerConfiguration config){
            this.config = config;
            this.logger = logger;
        }

        public TradingEngineServer buildTradingEngineServer(){
            return new TradingEngineServer(this);
        }
    }
}

