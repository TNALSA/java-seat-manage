package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Client.Client;


public class loginUI implements ActionListener {

	JFrame framelogin = new JFrame();
	JButton registerBtn = new JButton("회원가입");
	JButton loginBtn = new JButton("로그인");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIDLabel = new JLabel("ID: ");
	JLabel userPasswordLabel = new JLabel("Password: ");
	JLabel messageLabel = new JLabel();
	JPanel contentPane = new JPanel();
	JLabel loginLabel = new JLabel("Login");
	
	String id, password;
	String seat;
	JButton seatBtn;	
	Client client;
	
	
	private static String[] time = { "1시간", "2시간 30분", "4시간", "5시간 30분", "6시간" };
	private static String time_pick;
	private static int time_save;

	
	public loginUI(String seatNum) {
		this.seat = seatNum;
		try {
			client = new Client();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		framelogin.setVisible(true);
		
		userIDLabel.setBounds(100, 100, 75, 25);
		userPasswordLabel.setBounds(50, 150, 75, 25);

		messageLabel.setBounds(35, 250, 250, 35);
		messageLabel.setFont(new Font(null, Font.ITALIC, 25));

		loginLabel.setBounds(0, 36, 320, 35);
		loginLabel.setFont(new Font("KoPubWorld�룍��泥� Bold", Font.BOLD, 30));
		loginLabel.setForeground(Color.DARK_GRAY);
		loginLabel.setHorizontalAlignment(JLabel.CENTER);

		userIDField.setBounds(27, 95, 265, 38);
		userIDField.setBackground(Color.WHITE);

		userPasswordField.setBackground(Color.WHITE);
		userPasswordField.setBounds(27, 157, 265, 38);

		loginBtn.setFont(new Font("KoPubWorld�룍��泥� Medium", Font.PLAIN, 12));
		loginBtn.setBounds(48, 215, 100, 25);
		loginBtn.addActionListener(this);
		loginBtn.setFocusable(false);

		registerBtn.setFont(new Font("KoPubWorld�룍��泥� Medium", Font.PLAIN, 12));
		registerBtn.setBounds(174, 215, 100, 25);
		registerBtn.addActionListener(this);
		registerBtn.setFocusable(false);

		// ?��?��?��筌뤿굟遊?��?���쟿?��?���?
		framelogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		framelogin.setBounds(100, 100, 450, 450);

		framelogin.setSize(320, 320);
		
		framelogin.setResizable(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);

		
		contentPane.setLayout(null);
		
		contentPane.add(userIDField);
		contentPane.add(userPasswordField);
		contentPane.add(messageLabel);
		
		contentPane.add(loginBtn);
		contentPane.add(registerBtn);
		contentPane.add(loginLabel);

		framelogin.setContentPane(contentPane);
		framelogin.setLocationRelativeTo(null);
		
	}

 
	@Override
	public void actionPerformed(ActionEvent e) {
		id = userIDField.getText();
		password = String.valueOf(userPasswordField.getPassword());

//		if (e.getSource() == loginBtn) { //login btn onClick
//			try {
//				client.dos.writeUTF("login//"+id+"//"+password+"//"+seat);
//				String respon =  client.dis.readUTF(); //callback response to server
//				if(seat.equals("Admin")) { //Admin Seat Onclick
//					if(respon.equals("1")) {
//						JOptionPane.showMessageDialog(null, "관리자 로그인");
//						framelogin.dispose();
//						adminUI au = new adminUI();
//					}
//				}else {
//					//login Success
//					if(respon.equals("1")) {
//						client.dos.writeUTF("load//"+id); //load user information
//						String time = client.dis.readUTF(); //user?�� remainTime ?��?��?���?
//						JOptionPane.showMessageDialog(null, "로그인을 성공하였습니다.");
//						framelogin.dispose();
//						
//						seatUI.userbtnMap.get(seat).setEnabled(false); //?��?�� 좌석 비활?��?��
//					 	if(time.equals("0")) {
//							time_add(); //Add Time
//						}
//						else 
//						{
//							JOptionPane.showMessageDialog(null, "남은 시간: "+TimeTrans(Integer.valueOf(time)));
//							userUI uu = new userUI(seat,id,Integer.parseInt(time));
//						}
//					}
//				}
//				if(respon.equals("0")) {
//					JOptionPane.showMessageDialog(null, "비밀번호가 올바르지 않습니다.");
//				}
//				if(respon.equals("2")) {
//					JOptionPane.showMessageDialog(null, "회원정보가 존재하지 않습니다.");
//				}
//			} catch (IOException e1) {
//				System.out.println("[Client]login Error..");
//				e1.printStackTrace();
//			}
//		}
		if (e.getSource() == loginBtn) { //login btn onClick
			try {
				client.dos.writeUTF("login//"+id+"//"+password+"//"+seat);
				String respon =  client.dis.readUTF(); //callback response to server
					//login Success
					if(respon.equals("1")) {
						client.dos.writeUTF("load//"+id); //load user information
						String time = client.dis.readUTF(); //user?�� remainTime ?��?��?���?
						JOptionPane.showMessageDialog(null, "로그인을 성공하였습니다.");
						framelogin.dispose();
						
						seatUI.userbtnMap.get(seat).setEnabled(false); 
					 	if(time.equals("0")) {
							time_add(); //Add Time
						}
						else 
						{
							JOptionPane.showMessageDialog(null, "남은 시간: "+TimeTrans(Integer.valueOf(time)));
							userUI uu = new userUI(seat,id,Integer.parseInt(time),client);
						}
					}
				
				if(respon.equals("0")) {
					JOptionPane.showMessageDialog(null, "비밀번호가 올바르지 않습니다.");
				}
				if(respon.equals("2")) {
					JOptionPane.showMessageDialog(null, "회원정보가 존재하지 않습니다.");
				}
			} catch (IOException e1) {
				System.out.println("[Client]login Error..");
				e1.printStackTrace();
			}
		}

		if (e.getSource() == registerBtn) {
			framelogin.dispose();
			registerUI registerUI = new registerUI(seat);
		}
	}
	
	public int time_add() throws IOException {
		time_pick = (String) JOptionPane.showInputDialog(null, "시간을 선택하세요", "I4 PC", JOptionPane.WARNING_MESSAGE, null,
				time, time[0]); //?��간선?�� dialog
		client.dos.writeUTF("request//"+id+"//"+"//"+seat+"//"+time_pick);
		//?��?�� 메서?�� ?���?
		execute();
		return time_save;
	}
	
	public static void time_save(String time_pick) {
		switch (time_pick) {
		case "1시간":
			time_save = 605;
			break;
		case "2시간 30분":
			time_save = 9000;
			break;
		case "4시간":
			time_save = 14400;
			break;
		case "5시간 30분":
			time_save = 19800;
			break;
		case "6시간":
			time_save = 21600;
			break;
		}

	}
	
	public void execute() {
		try {
			String respon = client.dis.readUTF();
			if(respon.equals("0")){ 
				time_save(time_pick);
				//Client client = new Client();
				userUI uu = new userUI(seat, id, time_save, client);
			}
			else {
				JOptionPane.showMessageDialog(null, "시간 결제가 되지 않았습니다.", "Message",JOptionPane.ERROR_MESSAGE );
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String TimeTrans(int secTime) {
	      DecimalFormat df = new DecimalFormat("00"); // 00?�� 00?�� 00�? 00�?
	      StringBuilder sb = new StringBuilder();
	      
	      int remain = secTime; //integer?��?�� int?�� 뽑아?���?
	      
	      String day = "일";
	      String hour = "시간";
	      String min = "분";
	      String sec = "초";
	      

	      int Day = remain / 86400; //24?���? = 86400sec
	      remain = remain % 86400;
	      if (Day > 0) {
	         sb.append(df.format(Day));
	         sb.append(day);
	      }
	      
	     
	      int Hour = remain / 3600; //1hour = 3600sec
	      remain = remain % 3600;
	      if (Hour > 0) {
	         sb.append(df.format(Hour));
	         sb.append(hour);
	      }
	      
	      // ?���?
	      int minute = remain / 60; //1minuate = 60sec
	      remain = remain % 60;
	      if (minute > 0) {
	         sb.append(df.format(minute));
	         sb.append(min);
	      }
	      
	      // ?���?
	      int Sec = remain; // 1sec = 1sec
	      if (Sec > 0) {
	         sb.append(df.format(Sec));
	         sb.append(sec);
	      }
	      
	     return sb.toString();
	   }

}
