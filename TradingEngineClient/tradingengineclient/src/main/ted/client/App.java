package ted.client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 1234;
        while (true) {
            try (Socket socket = new Socket(hostname, port)) {
                System.out.println("Connected to server on port " + port);
                System.out.println("Enter your message to send to the server:");
                Scanner s = new Scanner(System.in);
                String message = s.nextLine();
                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);
                writer.println(message);
                System.out.println("Sent message to server.");
            } catch(UnknownHostException e){
            System.out.println("Server not found" + e.getMessage());
        } catch(IOException e){
            System.out.println("I/O error" + e.getMessage());
        }
    }
    }
}
