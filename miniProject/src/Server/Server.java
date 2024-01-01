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
	
	Server(){ //server�쓽 �깮�꽦�옄 �꽌踰� �냼耳볦쓣 �깮�꽦�븯怨�, client�쓽 �슂泥��쓣 �닔�씫�븳�떎. 
		try {
			//adminUI au = new adminUI();
			//au.mngFrame.setVisible(true);
			ss = new ServerSocket(4000);
			while(true) {
				System.out.println(">> Server loading...");
				s=ss.accept();
				System.out.println(">> "+s+"is Connected");
				Handler handler = new Handler(s); //Thread占쏙옙체占쏙옙 handler占쏙옙 占쏙옙占쏙옙占� 클占쏙옙占싱억옙트占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙
				
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
