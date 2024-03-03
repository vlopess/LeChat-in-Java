package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {
	ServerSocket server;
	private ArrayList<Socket> listClientes;
	SenderMessage senderMessage;	
	
	public Servidor(int port) throws IOException {
		this.server = new ServerSocket(port);	
		this.senderMessage = new SenderMessage();
		this.listClientes = new ArrayList<Socket>();
	}
	
	public void addClient(Socket client) {
		this.listClientes.add(client);
	}
	public void removeClient(Socket client) {
		this.listClientes.remove(client);
	}

	public Socket accept() throws IOException {
		return server.accept();
	}
	
	public void sendMessegeFrom(Socket client, String message) {
		this.listClientes
		.stream().
		filter(cliente -> !cliente.equals(client))
		.forEach(cliente -> senderMessage.sendMessegeFrom(cliente, message));
		//this.listClientes.remove(client);
	}
}
