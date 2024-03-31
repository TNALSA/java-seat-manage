package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import View.seatUI;

public class Client  {
	public Socket s;
	public DataInputStream dis;
	public DataOutputStream dos;
	
	
	public Client() throws IOException {
		try {
			s = new Socket("localhost",4000); //IP address, Port number
			dis = new DataInputStream(s.getInputStream());
			dos = new DataOutputStream(s.getOutputStream());
		} catch (IOException e) {
			s.close(); 
		}
	}
	
	public static void main(String[] args) throws IOException {
		seatUI su = new seatUI();
	}
}
