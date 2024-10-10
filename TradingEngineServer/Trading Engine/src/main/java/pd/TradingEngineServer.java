package java.pd;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.pd.ITradingEngineServer;
import java.net.http.*;
import java.pd.TradingEngineServerConfig.TradingServerConfig;
import java.util.logging.Logger;
import java.net.*;

public class TradingEngineServer implements ITradingEngineServer {

    final private Logger logger;
    final private TradingServerConfig config;
    private volatile boolean running = true;
    int port = 1234;
    TradingEngineServer(Logger logger, IOptions<TradingServerConfig> config){
        if(logger==null) throw new IllegalArgumentException("Null logger supplied");
        this.logger = logger;
        if(config==null) throw new IllegalArgumentException("Null config supplied");
        this.config = config.value();
    }
    public static void main(String[] args){

    }

    public void ExecuteAsync(ServerSocket serverSocket) throws IOException {
        Socket socket = serverSocket.accept();
        System.out.println("Client connected");
        //output to client
        OutputStream output = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(output, true);

        writer.println("Hello from the server!");

        socket.close();
    }
    public void run(){
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

}
