package TradingEngineServerCore;

import Messages.MessageFactory;

import java.io.*;
import java.net.Socket;

public class ConnectionHandler implements Runnable {
    TradingEngineServer server;
    Socket client;
    public ConnectionHandler(Socket client){
        this.client = client;
    }
    @Override
    public void run(){
        try {
            InputStream inputStream = client.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String message = reader.readLine();
            server.processMessage(MessageFactory.interpretMessage(message));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
