package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Client.Client;

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
	
	Client client;
	
	boolean check = false; //ì¤ë³µ??¸ ?¬ë¶?

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
		// ??ê°?? Text
		registerLabel = new JLabel("??ê°??");
		registerLabel.setHorizontalAlignment(JLabel.CENTER);
		registerLabel.setBounds(0, 50, 400, 35);
		registerLabel.setFont(new Font("KoPubWorldï¿½ë£ï¿½ï¿½ï§£ï¿½ Bold", Font.PLAIN, 25));

		// ID TextField
		IDField = new JTextField();
		idHint = new TextHint(IDField, "ID");
		IDField.setBounds(90, 100, 220, 35);

		PasswordField = new JTextField();
		pwHint = new TextHint(PasswordField, "ë¹ë?ë²í¸");
		PasswordField.setBounds(90, 144, 220, 35);

		PWConfirmField = new JTextField();
		pwcheckHint = new TextHint(PWConfirmField, "ë¹ë?ë²í¸ ??¸");
		PWConfirmField.setBounds(90, 193, 220, 35);

		FullNameField = new JTextField();
		nameHint = new TextHint(FullNameField, "?±ëª?");
		FullNameField.setBounds(90, 242, 220, 35);

		phoneField = new JTextField();
		phoneHint = new TextHint(phoneField, "? ?ë²í¸");
		phoneField.setBounds(90, 291, 220, 35);


		dateofbirthField = new JTextField();
		dateofbirthHint = new TextHint(dateofbirthField, "????¼");
		dateofbirthField.setBounds(90, 332, 220, 35);

		// Button
		checkBtn = new JButton("ì¤ë³µ??¸");
		checkBtn.setFont(new Font("KoPubWorldï¿½ë£ï¿½ï¿½ï§£ï¿½ Medium", Font.PLAIN, 9));
		checkBtn.setBounds(310, 100, 67, 25);
		checkBtn.addActionListener(this);



		registerBtn = new JButton("??ê°??");
		registerBtn.setFont(new Font("KoPubWorldï¿½ë£ï¿½ï¿½ï§£ï¿½ Medium", Font.PLAIN, 9));
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
		
		
		boolean bool = false; //?? ¥?¬?­? ?¤ ?? ¥??ì§? ??¸?©
		
		if (e.getSource() == registerBtn) {
 //			ë¹ë?ë²í¸ ??¸ 
			if (!password.equals("ë¹ë?ë²í¸") && !passwordcheck.equals("ë¹ë?ë²í¸ ??¸") && !passwordcheck.equals(password)) {
				JOptionPane.showMessageDialog(null, "ë¹ë?ë²í¸ê°? ?¼ì¹íì§? ??µ??¤.");
				PWConfirmField.setText("");
				System.out.println("pw");
				bool = true;
			}

			// ê³µë°± ?¬ë¶? ??¸
			if (id.equals("??´?")) {
				IDField.getText();
				JOptionPane.showMessageDialog(null, "IDë¥? ?? ¥?´ì£¼ì¸?.");
				bool = true;

			}
			if (password.equals("ë¹ë?ë²í¸")) {
				JOptionPane.showMessageDialog(null, "ë¹ë?ë²í¸ë¥? ?? ¥?´ì£¼ì¸?.");
				bool = true;

			}
			if (passwordcheck.equals("ë¹ë?ë²í¸ ??¸")) {
				JOptionPane.showMessageDialog(null, "ë¹ë?ë²í¸ ??¸? ?? ¥?´ì£¼ì¸?");
				bool = true;

			}

			if (name.equals("?±ëª?")) {
				JOptionPane.showMessageDialog(null, "?´ë¦ì ?? ¥?´ì£¼ì¸?");
				bool = true;

			}
			if (phone.equals("?´??? ?ë²í¸('-'? ?¸)")) {
				JOptionPane.showMessageDialog(null, "ï¿½ì¾ï¿½ìè¸°ë??ï¿? ï¿½ì¯ï¿½ì °ï¿½ë¹äºì±ê½?ï¿½ì!");
				bool = true;

			}

			if (birth.equals("????¼(8?ë¦? ?? ¥)")) {
				JOptionPane.showMessageDialog(null, "ï¿½ê¹®ï¿½ë?ï¿½?¡ï¿½ìªï¿½ì£ ï¿½ì¯ï¿½ì °ï¿½ë¹äºì±ê½?ï¿½ì!");
				bool = true;

			}
			
		

			if (!bool&&check) {
				try {
					client.dos.writeUTF("register//"+id+"//"+password+"//"+name+"//"+birth+"//"+phone);
					
					boolean rec = Boolean.valueOf(client.dis.readUTF());
					if (rec) {
						JOptionPane.showMessageDialog(null, "??ê°??? ?ë£í???µ??¤.");

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
				JOptionPane.showMessageDialog(null, "ì¤ë³µ??¸? ?´ì£¼ì¸?");
			}
		}
		
		if(e.getSource() == checkBtn) {
			try {
				client.dos.writeUTF("check//"+id);
				
				boolean result = Boolean.valueOf(client.dis.readUTF());
				if(result == true) JOptionPane.showMessageDialog(null, "ì¤ë³µ? ??´?ê°? ì¡´ì¬?©??¤.");	
				else {
				JOptionPane.showMessageDialog(null, "?¬?©ê°??¥? ID???¤.");
				check = true;
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}

}
