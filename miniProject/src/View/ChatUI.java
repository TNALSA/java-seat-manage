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

public class ChatUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField ChatTrace;
	private JTextField ParticipantsList;

	public ChatUI() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		ChatTrace = new JTextField();
		contentPane.add(ChatTrace, BorderLayout.CENTER);
		ChatTrace.setColumns(10);
		
		ParticipantsList = new JTextField();
		contentPane.add(ParticipantsList, BorderLayout.EAST);
		ParticipantsList.setColumns(10);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JTextArea MessageArea = new JTextArea();
		MessageArea.setRows(5);
		MessageArea.setColumns(60);
		panel.add(MessageArea);
		
		JButton SendBtn = new JButton("\uC804\uC1A1");
		panel.add(SendBtn);
	}

}
