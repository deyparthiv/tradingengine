package Messages;

import MessageProcessors.MessageVisitor;

public interface IMessage {
    public void accept(MessageVisitor visitor);
}
