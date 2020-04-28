package com.github.mehrabrahman.calc.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.github.mehrabrahman.calc.math.Operation;
import com.github.mehrabrahman.calc.math.OperationFactory;

public class HttpServer {
	public void listen() {
		try (ServerSocket serverSocket = new ServerSocket(8181);) {
			while (true) {
				Socket socket = serverSocket.accept();
				new Thread(new HttpProcessor(socket)).start();
			}
		} catch (IOException ex) {
			System.err.println(ex.getMessage());
			System.exit(1);
		}
	}
}

class HttpProcessor implements Runnable {
	private Socket socket;
	private String request;
	private String method;
	private String uri;

	public HttpProcessor(Socket socket) {
		this.socket = socket;
	}

	public void request(InputStream input) throws IOException {
		byte[] buffer = new byte[2048];
		int size = input.read(buffer);
		StringBuffer request = new StringBuffer(2048);
		for (int i = 0; i < size; i++) {
			request.append((char) buffer[i]);
		}
		this.request = request.toString();

		parse(request.toString());
	}

	public void parse(String request) {
		String[] tokens = request.split(" ");
		this.method = tokens[0];
		this.uri = tokens[1];
	}

	@Override
	public void run() {
		try {
			InputStream input = socket.getInputStream();
			OutputStream output = socket.getOutputStream();
			// Read the request
			request(input);
			// Write the response
			response(output);
		} catch (IOException ex) {
			System.err.println(ex.getMessage());
		}

	}

	private void response(OutputStream output) throws IOException {
		switch (this.method) {
		case "GET":
			if (uri.equals("/hello")) {
				StringBuffer response = new StringBuffer();
				String message = "<h1>Hello world</h1>";
				response.append("HTTP/1.1 200 OK\r\n" + "Content-Type: text/html\r\n" + "Content-Length: ");
				response.append(message.length());
				response.append("\r\n\r\n");
				response.append(message);
				byte[] bytes = response.toString().getBytes();
				output.write(bytes);
				output.flush();
			} else {

			}
			break;
		case "POST":
			if (uri.equals("/add")) {
				String[] lines = request.split(" ");
				for (int i = 0; i < lines.length; i++) {
					if (lines[i].contains("operands")) {
						String[] tokens = lines[i].split("=");
						String sOperands = tokens[1];
						System.out.println(tokens[1]);
						OperationFactory factory = OperationFactory.getInstance();
						Operation operation = factory.getOperation("add", sOperands);
						double result = operation.calculate();
						String sResult = new Double(result).toString();
						StringBuffer response = new StringBuffer();
						response.append("HTTP/1.1 200 OK\r\nContent-Type: text/html\r\n");
						response.append("Content-Length: ");
						response.append(sResult.length());
						response.append("\r\n\r\n");
						response.append(sResult);
						output.write(response.toString().getBytes());
						output.flush();
					}
				}
				String response = "HTTP/1.1 200 OK\r\n" + "Content-Type: text/html\r\n" + "Content-Length: 3\r\n"
						+ "\r\n" + "add";
				output.write(response.getBytes());
				output.flush();
			}
			break;
		default:
			String error = "HTTP/1.1 400 Bad Request\r\n" + "Content-Type: text/html\r\n" + "Content-Length: 20\r\n"
					+ "\r\n\r\n" + "<h1>Bad Request</h1>";
			output.write(error.getBytes());
			output.flush();
			break;
		}
	}
}
