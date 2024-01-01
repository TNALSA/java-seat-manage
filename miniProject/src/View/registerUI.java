package Client;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.sql.SQLException;

import java.sql.*;

public class registerUI implements ActionListener {

//	RegisterCheck rgtCheck = new RegisterCheck();
	// JFrame
	JFrame frame = new JFrame();

	// Panel
	JPanel contentPane = new JPanel();

	// Label
	JLabel registerLabel;

	// TextField
	JTextField IDField, PasswordField, PWConfirmField, FullNameField, phoneField, verificationField, dateofbirthField;

	// Hint
	TextHint idHint, pwHint, pwcheckHint, nameHint, phoneHint, verificationHint, dateofbirthHint;

	// Button
	JButton checkBtn, verificationBtn, registerBtn;


	// ButtonGroup
	ButtonGroup radio;

	String seat;
	
	boolean check = false; //중복확인 여부

	public registerUI(String seat) {

		this.seat = seat;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// LoginPage loginPage = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		// 회원가입 Text
		registerLabel = new JLabel("회원가입");
		registerLabel.setHorizontalAlignment(JLabel.CENTER);
		registerLabel.setBounds(0, 50, 400, 35);
		registerLabel.setFont(new Font("KoPubWorld�룍��泥� Bold", Font.PLAIN, 25));

		// ID TextField
		IDField = new JTextField();
		idHint = new TextHint(IDField, "ID");
		IDField.setBounds(90, 100, 220, 35);

		PasswordField = new JTextField();
		pwHint = new TextHint(PasswordField, "비밀번호");
		PasswordField.setBounds(90, 144, 220, 35);

		PWConfirmField = new JTextField();
		pwcheckHint = new TextHint(PWConfirmField, "비밀번호 확인");
		PWConfirmField.setBounds(90, 193, 220, 35);

		FullNameField = new JTextField();
		nameHint = new TextHint(FullNameField, "성명");
		FullNameField.setBounds(90, 242, 220, 35);

		phoneField = new JTextField();
		phoneHint = new TextHint(phoneField, "전화번호");
		phoneField.setBounds(90, 291, 220, 35);


		dateofbirthField = new JTextField();
		dateofbirthHint = new TextHint(dateofbirthField, "생년월일");
		dateofbirthField.setBounds(90, 332, 220, 35);

		// Button
		checkBtn = new JButton("중복확인");
		checkBtn.setFont(new Font("KoPubWorld�룍��泥� Medium", Font.PLAIN, 9));
		checkBtn.setBounds(310, 100, 67, 25);
		checkBtn.addActionListener(this);



		registerBtn = new JButton("회원가입");
		registerBtn.setFont(new Font("KoPubWorld�룍��泥� Medium", Font.PLAIN, 9));
		registerBtn.setBounds(156, 397, 80, 35);
		registerBtn.addActionListener(this);


		contentPane.setLayout(null);

		contentPane.add(dateofbirthField);
		contentPane.add(FullNameField);
		contentPane.add(IDField);
		contentPane.add(PWConfirmField);
		contentPane.add(PasswordField);
		contentPane.add(phoneField);
		contentPane.add(checkBtn);

		contentPane.add(registerLabel);
		contentPane.add(registerBtn);


		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(100, 100, 450, 450);

		frame.setSize(400, 550);
		frame.setResizable(false);
		frame.setContentPane(contentPane);
		frame.setLocationRelativeTo(null);
		frame.setBackground(Color.WHITE);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String id, password, passwordcheck, name, birth, phone;

		id = IDField.getText();
		password = PasswordField.getText();
		passwordcheck = PWConfirmField.getText();
		name = FullNameField.getText();
		birth = dateofbirthField.getText();
		phone = phoneField.getText();
		
		
		boolean bool = false; //입력사항을 다 입력했는지 확인용
		
		if (e.getSource() == registerBtn) {
 //			비밀번호 확인 
			if (!password.equals("비밀번호") && !passwordcheck.equals("비밀번호 확인") && !passwordcheck.equals(password)) {
				JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.");
				PWConfirmField.setText("");
				System.out.println("pw");
				bool = true;
			}

			// 공백 여부 확인
			if (id.equals("아이디")) {
				IDField.getText();
				JOptionPane.showMessageDialog(null, "ID를 입력해주세요.");
				bool = true;

			}
			if (password.equals("비밀번호")) {
				JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요.");
				bool = true;

			}
			if (passwordcheck.equals("비밀번호 확인")) {
				JOptionPane.showMessageDialog(null, "비밀번호 확인을 입력해주세요");
				bool = true;

			}

			if (name.equals("성명")) {
				JOptionPane.showMessageDialog(null, "이름을 입력해주세요");
				bool = true;

			}
			if (phone.equals("휴대전화번호('-'제외)")) {
				JOptionPane.showMessageDialog(null, "�쟾�솕踰덊샇瑜� �엯�젰�빐二쇱꽭�슂!");
				bool = true;

			}

			if (birth.equals("생년월일(8자리 입력)")) {
				JOptionPane.showMessageDialog(null, "�깮�뀈�썡�씪�쓣 �엯�젰�빐二쇱꽭�슂!");
				bool = true;

			}
			
		

			if (!bool&&check) {
				try {
					Client.dos.writeUTF("register//"+id+"//"+password+"//"+name+"//"+birth+"//"+phone);
					
					boolean rec = Boolean.valueOf(Client.dis.readUTF());
					if (rec) {
						JOptionPane.showMessageDialog(null, "회원가입을 완료하였습니다.");

						IDField.setText("");
						PasswordField.setText("");
						PWConfirmField.setText("");
						FullNameField.setText("");
						dateofbirthField.setText("");
						phoneField.setText("");

						IDField.requestFocus();
						frame.dispose();
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									loginUI loginPage = new loginUI(seat);
									loginPage.framelogin.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
			if(check == false) {
				JOptionPane.showMessageDialog(null, "중복확인을 해주세요");
			}
		}
		
		if(e.getSource() == checkBtn) {
			try {
				Client.dos.writeUTF("check//"+id);
				
				boolean result = Boolean.valueOf(Client.dis.readUTF());
				if(result == true) JOptionPane.showMessageDialog(null, "중복된 아이디가 존재합니다.");	
				else {
				JOptionPane.showMessageDialog(null, "사용가능한 ID입니다.");
				check = true;
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}

}
