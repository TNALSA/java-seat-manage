package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import javax.swing.DropMode;
import javax.swing.SwingConstants;
import java.awt.Color;

public class ChatUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField msgInput;

	public ChatUI() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		msgInput = new JTextField();
		panel.add(msgInput);
		msgInput.setColumns(30);
		
		JButton SendBtn = new JButton("\uC804\uC1A1");
		panel.add(SendBtn);
		
		JTextArea msgTrace = new JTextArea();
		contentPane.add(msgTrace, BorderLayout.CENTER);
		
		JTextArea participatorList = new JTextArea();
		participatorList.setForeground(new Color(0, 0, 0));
		participatorList.setColumns(20);
		contentPane.add(participatorList, BorderLayout.EAST);
	}
	
	void sendMsg() { //메세지 전송
		
	}
}
