package MessageProcessors;

import Messages.OrderMessage;

public interface MessageVisitor{
    public void visit(OrderMessage orderMessage);
}
