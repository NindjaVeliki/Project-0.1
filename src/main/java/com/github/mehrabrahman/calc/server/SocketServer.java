package com.github.mehrabrahman.calc.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    public void listen() {
        // Create ServerSocket
        try (ServerSocket serverSocket = new ServerSocket(8080);) {

            // While waiting...
            while (true) {
                // Open new socket for incoming request
                try (Socket socket = serverSocket.accept();) {
                    // Send socket to new thread and start
                    new Thread(new ThreadWorker(socket)).start();
                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            System.exit(1);
        }
    }
}
