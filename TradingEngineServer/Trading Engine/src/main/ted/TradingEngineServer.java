package ted;

import java.io.*;
import java.net.ServerSocket;
import ted.TradingEngineServerConfig.TradingServerConfig;

import java.util.ArrayList;
import java.util.logging.Logger;
import java.net.*;

public class TradingEngineServer implements ITradingEngineServer {
  //  final private Logger logger;
    private volatile boolean running = true;
    int port = 1234;
    TradingEngineServer(Logger logger, IOptions<TradingServerConfig> config){
       // if(logger==null) throw new IllegalArgumentException("Null logger supplied");
       // this.logger = logger;
       // if(config==null) throw new IllegalArgumentException("Null config supplied");
       // this.config = config.value();
    }
    TradingEngineServer(){};
    public static void main(String[] args){
        TradingEngineServer server = new TradingEngineServer();
        server.run();
    }

    public void ExecuteAsync(ServerSocket serverSocket) throws IOException {
        Socket clientSocket = serverSocket.accept();
        if(clientSocket.isConnected())
            new Thread(()->{
                System.out.println("Client connected");
                try {
                    InputStream input = clientSocket.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    String clientMessage = reader.readLine();
                    System.out.println(clientMessage);
                    clientSocket.close();
                } catch(IOException e){
                    e.printStackTrace();
                }
        }).run();
    }
    public void run(){
        System.out.println("Started Server");
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while(running){
                ExecuteAsync(serverSocket);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public void stopServer(){
        running = false;
    }

    @Override
    public void run(String cancellationToken) {

    }
}
