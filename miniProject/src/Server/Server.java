package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	ServerSocket ss = null;
	ArrayList<Handler> clients = new ArrayList<>();
	
	Socket s;
	
	Server(){ 
		try {
			ss = new ServerSocket(4000);
			while(true) {
				System.out.println(">> Server loading...");
				s=ss.accept();
				System.out.println(">> "+s+"is Connected");
				Handler handler = new Handler(s);
				
				clients.add(handler);
				handler.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Server server = new Server();
	}

}
