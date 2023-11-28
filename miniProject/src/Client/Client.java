package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client  {
	public static Socket s;
	public static DataInputStream dis;
	public static DataOutputStream dos;
	
	Client() throws IOException {
		try {
			s = new Socket("localhost",4000); //IP address, Port number
			dis = new DataInputStream(s.getInputStream());
			dos = new DataOutputStream(s.getOutputStream());
		} catch (IOException e) {
			s.close(); 
		}
	}
	
	public static void main(String[] args) {
		seatUI su = new seatUI();
		su.jframe.setVisible(true);
	}
	
	
}
