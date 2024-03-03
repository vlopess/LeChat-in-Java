package utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class InOutputSocket {
	Scanner reader;
	PrintWriter writer;

	public InOutputSocket(Socket client) throws IOException {
		this.reader = new Scanner(client.getInputStream());
		this.writer = new PrintWriter(client.getOutputStream(), true);
	}
	
	public String getNextLine() {
		return this.reader.nextLine();
	}
	
	public void send(String message) {
		this.writer.println(message);
	}
	
}
