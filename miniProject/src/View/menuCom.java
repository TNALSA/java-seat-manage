package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Domain.menu;

public class menuCom extends JPanel implements ActionListener {
	String menuid, menu, category, image;
	int price;
	
	Component setMenu(List<menu> list, int idx) { 
		setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel m_panel = new JPanel();
		m_panel.setBackground(Color.WHITE);
		add(m_panel);
		m_panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		m_panel.setLayout(null);
		//m_panel.setBounds(0, 0, 120, 160);
		m_panel.setPreferredSize(new Dimension(120,160));
		

		JLabel menuName = new JLabel(list.get(idx).getMenuName()); //getMenuid();
		menuName.setFont(new Font("굴림", Font.PLAIN, 13));
		menuName.setBounds(12, 105, 96, 21);
		m_panel.add(menuName);

		JLabel  menuPrice = new JLabel(String.valueOf(list.get(idx).getMenuPrice()));
		menuPrice.setForeground(Color.GRAY);
		menuPrice.setBounds(12, 132, 57, 15);
		m_panel.add(menuPrice);

		JButton cartBtn = new JButton("cart");
		cartBtn.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	if(e.getActionCommand().equals("cart")) { //cart onClick
					menuUI.model.addRow(new Object[] { //?��른쪽 cell?�� row 추�?
							menuName.getText(),Integer.parseInt(menuPrice.getText()),1
					});
					menuUI.len = menuUI.orderTable.getRowCount();
					price = 0;
					
					for(int i=0; i<menuUI.len; i++) {
						price += (int) menuUI.orderTable.getValueAt(i, 1) *(int) menuUI.orderTable.getValueAt(i, 2);	//�긽��?? 媛�寃� *  �닔�웾
					}
					menuUI.totalPrice.setText(Integer.toString(price));
				}
	           
	        } 
	        });
		cartBtn.setBackground(Color.WHITE);
		cartBtn.setBounds(87, 126, 21, 21);
		m_panel.add(cartBtn);

		JLabel menuImg = new JLabel();
		menuImg.setBounds(12, 10, 96, 90);
		m_panel.add(menuImg);
		
		
		return m_panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {}
	
	
	
}

