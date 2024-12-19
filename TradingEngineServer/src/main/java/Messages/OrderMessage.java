package Messages;

import MessageProcessors.MessageVisitor;

public class OrderMessage implements IOrderMessage{

    @Override
    public String getType() {
        return null;
    }

    @Override
    public void accept(MessageVisitor visitor) {
        visitor.visit(this);
    }
}
