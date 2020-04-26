package com.github.mehrabrahman.calc;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CalcClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080);
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader reader = new BufferedReader(new InputStreamReader((socket.getInputStream())));) {
            writer.println(args[0]);
            System.out.println(reader.readLine());
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
}