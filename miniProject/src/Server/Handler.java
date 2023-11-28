package Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import Database.DBmanager;

public class Handler extends Thread{
	Server server;
	Socket s; 
	DataInputStream dis;
	DataOutputStream dos;
	DBmanager DBmng;
	
	String msg; //massage to client
	String token; //divide token
	int respon; //DB占쏙옙占� 占쏙옙占쏙옙 占쏙옙占쏙옙占싹깍옙 占쏙옙占쏙옙 占쎈도
	boolean result;
	
	
	
	Handler(Socket s){ //占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占� 占쏙옙占쏙옙占쏙옙 Handler占쏙옙占쏙옙 占쌕뤄옙占� 占쏙옙占쏙옙
		DBmng = new DBmanager(); //DAO + DBmanager占쏙옙占쏙옙
		this.s = s;//�겢�씪�씠�뼵�듃�쓽 �냼耳�
	}
	
	@Override
	public void run(){
		try {
			dis = new DataInputStream(s.getInputStream());
			dos = new DataOutputStream(s.getOutputStream());
			
			String id, password, name, birth, phone, time, seat = null;
			
			
			while(true) {
				msg = dis.readUTF(); //client媛� 蹂대궦 臾몄옄�뿴�쓣 �넚�떊
				System.out.println("client:"+msg); //臾몄옄�뿴�쓣 �솗�씤�븯湲� �쐞�븳 �슜�룄
				
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
					
					respon = DBmng.login(id, password); //DBmanager login function �샇異�
					if(respon == 1) {//�젙蹂닿� �씪移섑븷 寃쎌슦
						//client濡� response 蹂대궡湲�
						dos.writeUTF(String.valueOf(respon)); 
						//user媛� �꽑�깮�븳 醫뚯꽍 鍮꾪솢�꽦�솕
						adminUI.mngbtnMap.get(seat).setEnabled(false);
						
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
					adminUI.mngbtnMap.get(seat).setEnabled(true);
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
