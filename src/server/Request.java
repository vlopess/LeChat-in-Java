package server;

import java.io.IOException;
import java.net.Socket;

import utils.InOutputSocket;

public class Request implements Runnable {
	Servidor server;
	Socket cliente;
	String username;
	InOutputSocket inOutputSocket;
	SenderMessage senderMessage;	
	
	public Request(Socket cliente, Servidor server) throws IOException {
		this.cliente = cliente;		
		this.inOutputSocket = new InOutputSocket(cliente);
		this.server = server;
		setUsername();
	}
	
	private void setUsername() throws IOException {
		String name = this.inOutputSocket.getNextLine();
		this.username = name;
    System.out.println("Username: " + name + " in!");
		sendMessageNewClient();
	}
	

	private void sendMessageNewClient() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("...........................\n");
		stringBuffer.append("\t" + username + " in!!\n");
		stringBuffer.append("...........................\n");
		this.server.sendMessegeFrom(cliente, stringBuffer.toString());
	}

	public void processRequest() throws IOException{
      try {
        while(true) {
          String message = this.inOutputSocket.getNextLine();			
          this.server.sendMessegeFrom(cliente, username + " said: " + message);
        }
      }	catch (IOException e) {
        this.server.removeClient(cliente);
      }
	}
  
	@Override
	public void run() {
		try {
			processRequest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}