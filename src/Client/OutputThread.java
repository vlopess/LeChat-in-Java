package Client;

import java.io.IOException;
import java.net.Socket;

import utils.InOutputSocket;

public class OutputThread extends Thread{
	InOutputSocket inOutputSocket;
	
	public OutputThread(Socket client) throws IOException {
		this.inOutputSocket = new InOutputSocket(client);
	}

	public void run() {
		String message;
		while(true) {
			try {
				message = inOutputSocket.getNextLine();
				System.out.println(message);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}

}
