package Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import utils.InOutputSocket;

public class Cliente {
	public static void main(String[] args) throws UnknownHostException, IOException {
		int PORT = 8080;
		String ADDR = "192.168.10.17";
		Socket client = new Socket(ADDR, PORT);
		System.out.println("welcome to the server...\n                    _                       \n"
				+ "                    \\`*-.                   \n"
				+ "                      )  _`-.                \n"
				+ "                    .  : `. .               \n"
				+ "                    : _   '  \\              \n"
				+ "                    ; ` _.   `-._         \n"
				+ "                    `-.-'          `-.      \n"
				+ "                      ;       `       `.    \n"
				+ "                      :.       .        \\   \n"
				+ "                      . \\  .   :   .-'   .  \n"
				+ "                      '  `+.;  ;  '      :  \n"
				+ "                      :  '  |    ;       ;-.\n"
				+ "[le chat]             ; '   : :-:     _.* ;\n"
				+ "                    .' /  .' ; .`- +'  `'\n"
				+ "                    `-   `-  `-'       ");
		InOutputSocket inOutputSocket = new InOutputSocket(client);
		try (Scanner readerKeyword = new Scanner(System.in)) {
			System.out.println("Enter username:");
			String ler = readerKeyword.nextLine(); 
			inOutputSocket.send(ler);
			System.out.println("...........................");
			while(true) {
				while(true) {
					String answer = inOutputSocket.getNextLine();
					if(!answer.trim().isEmpty())
						System.out.println(answer);
					else
						break;
				}
				ler = readerKeyword.nextLine(); 
				if(!ler.trim().isEmpty())
					inOutputSocket.send(ler);
				//receber message
			}
		}	
			
	};
}