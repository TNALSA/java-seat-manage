package Client;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class menuCom extends JPanel implements ActionListener {
	
	ArrayList<Object> list;
	
	menuCom(){
		try {
			Client.dos.writeUTF("menu//");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    String menuid, menu, category, image;
    int price;
    
	Component setMenu(int idx) { //媛� 硫붾돱留덈떎 而댄룷�꼳�듃瑜� 留뚮뱾�뼱二쇰뒗 硫붿꽌�뱶
		setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel m_panel = new JPanel();
		m_panel.setBackground(Color.WHITE);
		add(m_panel);
		m_panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		m_panel.setLayout(null);
		//m_panel.setBounds(0, 0, 120, 160);
		m_panel.setPreferredSize(new Dimension(120,160));
		

		JLabel menuName = new JLabel(list.get(idx).getMenu()); //getMenuid();
		menuName.setFont(new Font("援대┝", Font.PLAIN, 13));
		menuName.setBounds(12, 105, 96, 21);
		m_panel.add(menuName);

		JLabel  menuPrice = new JLabel(String.valueOf(list.get(idx).getPrice()));
		menuPrice.setForeground(Color.GRAY);
		menuPrice.setBounds(12, 132, 57, 15);
		m_panel.add(menuPrice);

		JButton cartBtn = new JButton("cart");
		cartBtn.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	if(e.getActionCommand().equals("cart")) {
					menuUI.model.addRow(new Object[] {
							menuName.getText(),Integer.parseInt(menuPrice.getText()),1
					});
					menuUI.len = menuUI.orderTable.getRowCount();
					price = 0;
					for(int i=0; i<menuUI.len; i++) {
						price += (int) menuUI.orderTable.getValueAt(i, 1) *(int) menuUI.orderTable.getValueAt(i, 2);	//�긽�뭹 媛�寃� *  �닔�웾
					}
					menuUI.totalPrice.setText(Integer.toString(price));
				}
	           
	        } 
	        });
		cartBtn.setBackground(Color.WHITE);
		cartBtn.setBounds(87, 126, 21, 21);
		m_panel.add(cartBtn);

		JLabel menuImg = new JLabel(list.get(idx).getImage());
		menuImg.setBounds(12, 10, 96, 90);
		m_panel.add(menuImg);
		
		
		return m_panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {}
	
	
	
}

