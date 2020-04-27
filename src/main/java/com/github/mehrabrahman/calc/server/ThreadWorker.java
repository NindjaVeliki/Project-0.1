package com.github.mehrabrahman.calc.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import com.github.mehrabrahman.calc.math.Operation;
import com.github.mehrabrahman.calc.math.OperationFactory;

public class ThreadWorker implements Runnable {
    private Socket socket;

    public ThreadWorker(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            OperationFactory factory = OperationFactory.getInstance();
            Scanner scanner = new Scanner(socket.getInputStream());
            String[] tokens = scanner.nextLine().split(",");
            Operation operation = factory.getOperation(tokens[0], tokens[1]);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println(operation.calculate());
            scanner.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

}