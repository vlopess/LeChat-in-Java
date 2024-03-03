package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class InOutputSocket {
	BufferedReader reader;
	BufferedWriter writer;

	public InOutputSocket(Socket client) throws IOException {
		this.reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
		this.writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
	}
	
	public String getNextLine() throws IOException {
		return this.reader.readLine();
	}
	
	public void send(String message) throws IOException {
		this.writer.write(message);
		this.writer.newLine();
		this.writer.flush();
	}
	
}
