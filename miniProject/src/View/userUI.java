package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Menu;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import Client.Client;
import Domain.menu;

public class userUI implements ActionListener {

	// field
	private  String seat, id;
	private int time_save, time;
	private Timer timer;
	private LocalTime timeNow = LocalTime.now();
	private static JButton seatId;
	// Frame
	private static JFrame userMainframe;
	// Panel
	private static JPanel contentPane, panel1, panel2, panel3;
	// Button
	private static JButton Button_food, Button_order, Button_timeAdd, Button_end;
	// JLabel
	private JLabel seat_num, user_id, time_out, time_start;
	
	Client client;
	

	static LocalTime of(int hour, int min, int sec) {
		return null;
	}

	// Timer method
	public void timer_m(Integer time_save, JLabel label) {
		time = time_save;
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LocalTime sunnyTime = LocalTime.ofSecondOfDay(time);
				label.setText("남은 시간:" + sunnyTime);
				time--;
				
				if (time == 600) { //time is second
					JOptionPane.showInternalMessageDialog(null, "시간이 10분 남았습니다.");
				}
				if (time == -1) {
					timer.stop();
					try {
						userMainframe.dispose();
						seatId = seatUI.userbtnMap.get(seat);
						//seatId.setEnabled(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		timer.start();
	}

	public userUI(String seat, String id, int time_save, Client client) {
		this.seat = seat; //user select seat
		this.id = id; //user id
		this.time_save = time_save; //user remain time
		this.client = client; //userUI에서 클라이언트 소켓을 다루기 위함
		
		// Frame
		userMainframe = new JFrame();
		userMainframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		userMainframe.setResizable(false);

		userMainframe.setBounds(100, 100, 419, 202);
		userMainframe.setVisible(true);

		// Panel
		panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBackground(SystemColor.inactiveCaption);
		panel1.setBounds(0, 0, 419, 174);
		panel1.setVisible(true);

		panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBackground(Color.WHITE);
		panel2.setBounds(12, 13, 392, 103);
		panel2.setVisible(true);

		panel3 = new JPanel();
		panel3.setLayout(null);
		panel3.setBackground(Color.WHITE);
		panel3.setBounds(247, 0, 145, 103);
		panel3.setForeground(Color.WHITE);
		panel3.setVisible(false);

		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		// JLabel
		seat_num = new JLabel("no." + seat);
		seat_num.setBounds(8, 8, 44, 16);
		seat_num.setFont(new Font("KoPubWorld?��??�? Bold", Font.BOLD, 15));
		seat_num.setForeground(Color.BLACK);
		seat_num.setBackground(Color.WHITE);

		user_id = new JLabel("ID:" + id);
		user_id.setBounds(8, 34, 145, 16);
		user_id.setFont(new Font("KoPubWorld?��??�? Medium", Font.PLAIN, 13));
		user_id.setForeground(Color.BLACK);
		seat_num.setBackground(Color.WHITE);

		time_start = new JLabel();
		time_start.setBounds(8, 77, 145, 16);
		time_start.setFont(new Font("KoPubWorld?��??�? Medium", Font.PLAIN, 13));
		time_start.setForeground(Color.BLACK);
				time_start.setBackground(Color.WHITE);

		// Button
		Button_food = new JButton("주문");
		Button_food.setFont(new Font("KoPubWorld?��??�? Medium", Font.BOLD, 9));
		Button_food.setBounds(12, 140, 84, 23);
		Button_food.setFocusable(false);
		Button_food.addActionListener(this);
		Button_food.setBackground(Color.WHITE);

				
		Button_order = new JButton("문의");
		Button_order.setFont(new Font("KoPubWorld?��??�? Medium", Font.BOLD, 9));
		Button_order.setBounds(108, 140, 84, 23);
		Button_order.setFocusable(false);
		Button_order.addActionListener(this);
		Button_order.setBackground(Color.WHITE);

				
		Button_timeAdd = new JButton("시간 추가");
		Button_timeAdd.setFont(new Font("KoPubWorld?��??�? Medium", Font.BOLD, 9));
		Button_timeAdd.setBounds(204, 140, 84, 23);
		Button_timeAdd.setFocusable(false);
		Button_timeAdd.addActionListener(this);
		Button_timeAdd.setBackground(Color.WHITE);

				
		Button_end = new JButton("종료");
		Button_end.setFont(new Font("KoPubWorld?��??�? Medium", Font.BOLD, 9));
		Button_end.setBounds(300, 139, 84, 23);
		Button_end.setFocusable(false);
		Button_end.addActionListener(this);
		Button_end.setBackground(Color.WHITE);

				// Add
		panel1.add(Button_food);
		panel1.add(Button_order);
		panel1.add(Button_timeAdd);
		panel1.add(Button_end);

		panel2.add(seat_num);
		panel2.add(user_id);
		panel2.add(time_start);

		panel2.add(panel3);
		panel1.add(panel2);
		contentPane.add(panel1);
		userMainframe.setContentPane(contentPane);
			

		timer_m(this.time_save, time_start);
	}


	@Override
	public void actionPerformed(ActionEvent e) { 
		//주문 버튼
		if (e.getSource() == Button_food) {
			try {
				Object menuList;
				client.dos.writeUTF("menu//");
				while(true) {
					menuList = client.ois.readObject();
					System.out.println(menuList);
					
					break;
				}
				//여기서도 객체로 받아야함
				menuUI mf = new menuUI(client, id, (List<menu>) menuList);		
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		//문의 버튼
		if (e.getSource() == Button_order) { 
			ChatUI cu = new ChatUI(); 
		}
		//종료 버튼
		if (e.getSource() == Button_end) { 
			int response = JOptionPane.showConfirmDialog(null,"종료하시겠습니까?", "종료", JOptionPane.YES_NO_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null);
			
			if(response == 0) { //Yes
			timer.stop();
			try {
				userMainframe.dispose();
				seatUI.userbtnMap.get(seat).setEnabled(true);
				client.dos.writeUTF("exit//"+id+"//"+time);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			}
		}
		/*
		 //시간 추가
		if (e.getSource() == Button_timeAdd) {
			try {
				int addTime = Client.timeAdd();
				time = time+ addTime;
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}

		}
		*/
	
	}
}