package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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
					
				case "check": //DB�뿉 �쉶�썝�젙蹂닿� 議댁옱�븯�뒗吏� �솗�씤
					id = st.nextToken();
					result = DBmng.check(id);
					dos.writeUTF(String.valueOf(result));
					break;
				
				case "register": //�쉶�썝媛��엯
					id=st.nextToken();
					password = st.nextToken();
					name = st.nextToken();
					birth = st.nextToken();
					phone = st.nextToken();
					
					result = DBmng.register(id,password,name,birth,phone);
					dos.writeUTF(String.valueOf(result));
					break;
					
				case "load": //DB�뿉 client �젙蹂대�� 遺덈윭�샂
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
