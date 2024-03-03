package server;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import utils.InOutputSocket;

public class SenderMessage {
			
	public void sendMessegeFrom(Socket client, String message) {
		try {
			InOutputSocket inOutputSocket = new InOutputSocket(client);
			inOutputSocket.send(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
