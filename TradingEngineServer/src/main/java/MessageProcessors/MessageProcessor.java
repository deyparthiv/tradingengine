package MessageProcessors;

import Messages.OrderMessage;
import TradingEngineServerCore.TradingEngineServer;

public class MessageProcessor implements MessageVisitor {
    TradingEngineServer server;
    public MessageProcessor(TradingEngineServer server){
        this.server = server;
    }
    public void visit(OrderMessage orderMessage){
        server.placeOrder()
    }
}
