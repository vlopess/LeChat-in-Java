package server;
import java.io.IOException;
import java.net.Socket;

public class Server {
	
	public static void main(String[] args) throws IOException {
		int PORT = 8080;		
		Servidor server = new Servidor(PORT);
		while(true) {
			Socket client = server.accept();
			server.addClient(client);
			//System.out.println(client.getInetAddress());			
			Request request = new Request(client, server);			
			Thread t = new Thread(request); 
			t.start();
		}
	}

}