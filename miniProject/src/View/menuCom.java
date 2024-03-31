package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Domain.menu;

public class menuCom extends JPanel implements ActionListener {
	String menuid, menu, category;
	int price = 0, quantity = 0;
	
	InputStream in;
	BufferedImage image;
	
	Component setMenu(List<menu> list, int idx) { 
		setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel m_panel = new JPanel();
		m_panel.setBackground(Color.WHITE);
		add(m_panel);
		m_panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		m_panel.setLayout(null);
		//m_panel.setBounds(0, 0, 120, 160);
		m_panel.setPreferredSize(new Dimension(150,180));
		

		JLabel menuName = new JLabel(list.get(idx).getMenuName()); //getMenuid();
		menuName.setFont(new Font("굴림", Font.PLAIN, 13));
		menuName.setBounds(12, 105, 96, 21);
		m_panel.add(menuName);

		JLabel  menuPrice = new JLabel(String.valueOf(list.get(idx).getMenuPrice()));
		menuPrice.setForeground(Color.GRAY);
		menuPrice.setBounds(12, 132, 57, 15);
		m_panel.add(menuPrice);

		JButton addBtn = new JButton("add");
		addBtn.setSize(200, 200); //크기 조정 이슈
		addBtn.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	if(e.getActionCommand().equals("add")) {     
	        		   boolean isExist = false; //중복 값 존재 여부
	                   int location = 0; //중복 값이 존재하는 Row의 위치
	                   
	                   if(menuUI.orderTable.getRowCount()>0) {
	                      for(int i=0;i<menuUI.orderTable.getRowCount();i++) {
	                         if(menuUI.orderTable.getValueAt(i, 0).equals(menuName.getText())) { //중복 값 Check
	                            isExist = true;
	                            location = i;
	                         }
	                      }
	                      
	                      if(isExist) {
	                         menuUI.orderTable.setValueAt((Integer) menuUI.orderTable.getValueAt(location, 2)+1, location, 2);
	                      }else {
	                         menuUI.model.addRow(new Object[] { 
	                              menuName.getText(),Integer.parseInt(menuPrice.getText()),1
	                        });
	                      }
	                   }else {
	                      menuUI.model.addRow(new Object[] { 
	                          menuName.getText(),Integer.parseInt(menuPrice.getText()),1
	                    });
	                   }

	                 for(int i=0; i<menuUI.orderTable.getRowCount(); i++) {
	                    price += (int) menuUI.orderTable.getValueAt(i, 1) *(int) menuUI.orderTable.getValueAt(i, 2);
	                 }
	                 menuUI.totalPrice.setText(Integer.toString(price));
	              }
	        } 
	        });
			addBtn.setBackground(Color.WHITE);
			addBtn.setBounds(87, 126, 21, 21);
			m_panel.add(addBtn);

		try {
			in = list.get(idx).getMenuImage().getBinaryStream();
			image = ImageIO.read(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//ImageIcon 객체 생성시 getScaledInstance 메서드를 통해 이미지 크기 조정
		JLabel menuImg = new JLabel(new ImageIcon(image.getScaledInstance(96, 90, Image.SCALE_SMOOTH)));
		//menuImg.setSize(30, 50);
		menuImg.setBounds(12, 10, 96, 90);
		m_panel.add(menuImg);
		
		return m_panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {}
	
	
	
}

