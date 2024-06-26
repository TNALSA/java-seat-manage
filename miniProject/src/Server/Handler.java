package Server;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;
import javax.xml.crypto.Data;

import Database.DBmanager;
import Domain.menu;
import View.adminUI;


public class Handler extends Thread{
	Server server;
	Socket s; 
	DataInputStream dis;
	DataOutputStream dos;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	
	DBmanager DBmng;
	
	String msg; //massage to client
	String token; //divide token
	int respon; 
	boolean result;
	
	Handler(Socket s){ 
		DBmng = new DBmanager(); 
		this.s = s;
	}
	
	@Override
	public void run(){
		try {
			dis = new DataInputStream(s.getInputStream());
			dos = new DataOutputStream(s.getOutputStream());
			oos = new ObjectOutputStream(s.getOutputStream());
			ois = new ObjectInputStream(s.getInputStream());
			
			String id, password, name, birth, phone, time, seat = null;
			
			
			while(true) {
				msg = dis.readUTF();
				System.out.println("client:"+msg);
				
				StringTokenizer st = new StringTokenizer(msg,"//");
				
				token = st.nextToken();
				
				switch(token) {
				
				case "login":
					id = st.nextToken();
					System.out.println(id);
					password = st.nextToken();
					System.out.println(password);
					seat = st.nextToken();
					System.out.println(seat);
					
					respon = DBmng.login(id, password);
					if(respon == 1) {
						System.out.println("1111");
						dos.writeUTF(String.valueOf(respon)); 
					}
					break;
					
				case "check":
					id = st.nextToken();
					result = DBmng.check(id);
					dos.writeUTF(String.valueOf(result));
					break;
				
				case "register":
					id=st.nextToken();
					password = st.nextToken();
					name = st.nextToken();
					birth = st.nextToken();
					phone = st.nextToken();
					
					result = DBmng.register(id,password,name,birth,phone);
					dos.writeUTF(String.valueOf(result));
					break;
					
				case "load":
					id = st.nextToken();
					int remainTime = DBmng.load(id); //remainTime�� ���옣�릺�뼱�엳�뒗 �떆媛�
					dos.writeUTF(String.valueOf(remainTime));
					break;
					
				case "exit":
					id = st.nextToken();
					time = st.nextToken(); 
					DBmng.exit(id,Integer.parseInt(time));
					s.close();
					break;
					
				case "request": 
					id = st.nextToken();
					seat = st.nextToken();
					String time_pick = st.nextToken();
					int respon = JOptionPane.showConfirmDialog(null, seat+"빈자리[ID:"+id+"]가 "+time_pick+"결제하였습니다.", "寃곗젣", JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null);
					System.out.println(respon);
					dos.writeUTF(String.valueOf(respon));
					break;
					
				case "menu":
					List<menu> menuList = DBmng.menu();
					oos.writeObject(menuList);
					break;
				}
			}
		}catch(Exception e) { 
			try {
				s.close(); 
			} catch (IOException e1) {
				server.clients.remove(this);
				e1.printStackTrace();
			}
			e.getMessage();
		}
	}

}
