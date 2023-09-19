package InternetProgram.Test.Test4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public synchronized static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10000);
        while(true){
            Socket socket = serverSocket.accept();
            ServerThread serverThread = new ServerThread(socket);
            serverThread.start();
        }
    }
}
