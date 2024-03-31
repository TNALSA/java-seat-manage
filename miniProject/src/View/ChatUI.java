package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Client.Client;

public class ChatUI extends JFrame implements ActionListener{

   private static final long serialVersionUID = 1L;
   private JPanel contentPane;
   private JTextField msgInput;
   private Client client;

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
      SendBtn.addActionListener(this);
      
      JTextArea msgTrace = new JTextArea();
      contentPane.add(msgTrace, BorderLayout.CENTER);
      
      JTextArea participatorList = new JTextArea();
      participatorList.setForeground(new Color(0, 0, 0));
      participatorList.setColumns(20);
      contentPane.add(participatorList, BorderLayout.EAST);
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
      System.out.println(msgInput.getText());
      sendMsg(msgInput.getText());
   }
   
   void sendMsg(String text) { 
      try {
         new Client().dos.writeUTF(text); //按眉 积己捞 包扒;;
         while(true) {
            String msg = client.dis.readUTF();
            System.out.println("Chat: "+msg);
         }
      }catch(Exception e) {
         e.printStackTrace();
      }
   }
      

}
