package Messages;

public class MessageFactory {
    public static IMessage interpretMessage(String message){ //interprets message based on set format
        String[] blocks = message.split(" ");
        String task = blocks[0];
        switch(task){
            case "order":

            case "modifyOrder":
                break;
            case "cancelOrder":
                break;
        }
        return null;
    }
}
