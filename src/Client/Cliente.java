package Client;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;


public class Cliente{
	
	public void run()  throws UnknownHostException, IOException { 
		int PORT = 8080;
		String ADDR = "localhost";
		Socket client = new Socket(ADDR, PORT);
		showWelcome();		
		InOutput inOutput = new InOutput(client);
		OutputThread outputThread = new OutputThread(client);
		outputThread.start();
		inOutput.sendMessages();
		System.out.println("...........START...........");		
	}
	public static void main(String[] args) throws UnknownHostException, IOException {
		(new Cliente()).run();			
	}

	private static void showWelcome() {
		System.out.println("WELCOME TO THE SERVER...\n                    _                       \n"
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
	};
}