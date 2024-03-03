package Client;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import utils.InOutputSocket;

public class InOutput {
	InOutputSocket inOutputSocket;
	Scanner readerKeyword;
	
	public InOutput(Socket client) throws IOException {
		this.inOutputSocket = new InOutputSocket(client);
		this.readerKeyword = new Scanner(System.in);
	}

	public void sendMessages() throws IOException {
		introduce();
		while(true) { 
		  String ler = readerKeyword.nextLine(); 
		  if(!ler.trim().isEmpty())
			  inOutputSocket.send(ler); 
			
		}
		
	}	

	private void introduce() throws IOException {		
		System.out.println("Enter username:");
		String username = readerKeyword.nextLine(); 
		inOutputSocket.send(username);		
	}

}
