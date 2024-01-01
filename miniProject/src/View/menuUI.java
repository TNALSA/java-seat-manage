package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Database.DBmanager;
import Domain.menu;


public class menuUI extends JFrame {
	private JPanel contentPane;
	private JTextField txtFieldOrderMessage;
	static JTable orderTable;
	static DefaultTableModel model = new DefaultTableModel(new Object[][] {}, //?��?����???���뵠�뇡?���? ?��?��?�� 
			new String[] {
					"?��?�� ?���?", "�?�?", "?��?��"
				}) ;
	static int len;
	static int price;
	static JLabel totalPrice;
	List<menu> list;
	DBmanager dm = new DBmanager();
	
	public menuUI() {
		list = dm.menu(); //?��?��?��베이?��?��?�� ?���? 메뉴 리스?�� 불러?���?
		menuCom mc = new menuCom(); //menuCom 객체 ?��?��
		
		setVisible(true);
		setResizable(false);
		setBackground(Color.WHITE);
		setTitle("먹거�? 주문");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBackground(Color.WHITE);
		setBounds(100, 100, 893, 672);

		JMenuBar menuBar = new JMenuBar();
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(30, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("?��?��?��");
		lblNewLabel_4.setBounds(10, 10, 67, 25);
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_4);

		JPanel orderListPane = new JPanel();
		orderListPane.setBounds(667, 180, 198, 339);
		orderListPane.setBorder(null);
		orderListPane.setBackground(Color.WHITE);
		contentPane.add(orderListPane);
		orderListPane.setLayout(null);

		JPanel totalPane = new JPanel();
		totalPane.setBorder(new LineBorder(SystemColor.inactiveCaption, 2));
		totalPane.setBackground(Color.WHITE);
		totalPane.setBounds(12, 290, 177, 39);
		orderListPane.add(totalPane);
		totalPane.setLayout(null);

		JLabel totalPriceNotice = new JLabel("�? 금액 :");
		totalPriceNotice.setBounds(30, 7, 60, 26);
		totalPane.add(totalPriceNotice);
		totalPriceNotice.setFont(new Font("굴림", Font.PLAIN, 15));
		
		JScrollPane orderListlPane = new JScrollPane();
		orderListlPane.setBounds(0, 0, 198, 245);
		orderListlPane.getViewport().setBackground(Color.WHITE);
		orderListPane.add(orderListlPane);
		
		orderTable = new JTable();
		orderTable.setBackground(Color.WHITE);
		orderTable.setRowHeight(23);
		orderTable.setShowVerticalLines(false);
		orderTable.setShowHorizontalLines(false);
		orderTable.getTableHeader().setReorderingAllowed(false);
		orderTable.getTableHeader().setResizingAllowed(false);
		orderTable.setModel(model);
		orderTable.getColumnModel().getColumn(0).setPreferredWidth(100);
		orderTable.getColumnModel().getColumn(0).setMinWidth(16);
		orderTable.getColumnModel().getColumn(1).setPreferredWidth(60);
		orderTable.getColumnModel().getColumn(2).setPreferredWidth(40);
		orderListlPane.setViewportView(orderTable);
		
		totalPrice = new JLabel("");
		totalPrice.setFont(new Font("굴림", Font.PLAIN, 15));
		totalPrice.setBounds(90, 7, 60, 26);
		totalPane.add(totalPrice);
		len = orderTable.getRowCount();
		price = 0;
		for(int i=0; i<len; i++) {
			price += (int) orderTable.getValueAt(i, 1) *(int) orderTable.getValueAt(i, 2);	//?��?��맒占?���� ?��?��?��?��껓옙 *  ?��?��?��?��?��?��
		}
		totalPrice.setText(Integer.toString(price));
		
			JButton delBtn = new JButton("?��?��");
			delBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int n = orderTable.getSelectedRow();
					DefaultTableModel tm = (DefaultTableModel)orderTable.getModel();
					if(n>=0 && n<orderTable.getRowCount()) {
						tm.removeRow(n);
						len = orderTable.getRowCount();
						price = 0;
						for(int i=0; i<len; i++) {
							price += (int) orderTable.getValueAt(i, 1) *(int) orderTable.getValueAt(i, 2);	//?��?��맒占?���� ?��?��?��?��껓옙 *  ?��?��?��?��?��?��
						}
						totalPrice.setText(Integer.toString(price));
					}
				}
			});
			delBtn.setBackground(Color.WHITE);
			delBtn.setBounds(102, 254, 70, 26);
			orderListPane.add(delBtn);
				
		//�닔�웾 媛먯?�� 踰꾪?��
		JButton addBtn = new JButton("+");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int n = orderTable.getSelectedRow();
					int v = (int) orderTable.getValueAt(n, 2);
					v++;
					orderTable.setValueAt(v, n, 2);
					len = orderTable.getRowCount();
					price = 0;
					for(int i=0; i<len; i++) {
						price += (int) orderTable.getValueAt(i, 1) *(int) orderTable.getValueAt(i, 2);	//?��?��맒占?���� ?��?��?��?��껓옙 *  ?��?��?��?��?��?��
					}
					totalPrice.setText(Integer.toString(price));
				} catch(Exception e1) {
					
				}
			}
		});
		addBtn.setBackground(Color.WHITE);
		addBtn.setBounds(29, 254, 58, 12);
		orderListPane.add(addBtn);
		
		JButton rmvBtn = new JButton("-");
		rmvBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int n = orderTable.getSelectedRow();
					int v = (int) orderTable.getValueAt(n, 2);
					if(v<=1) {}
					else 
						v--;
					orderTable.setValueAt(v, n, 2);	
					len = orderTable.getRowCount();
					price = 0;
					for(int i=0; i<len; i++) {
						price += (int) orderTable.getValueAt(i, 1) *(int) orderTable.getValueAt(i, 2);	//?��?��맒占?���� ?��?��?��?��껓옙 *  ?��?��?��?��?��?��
					}
					totalPrice.setText(Integer.toString(price));
				} catch(Exception e1) {
				}
			}
		});
		rmvBtn.setBackground(Color.WHITE);
		rmvBtn.setBounds(29, 268, 58, 12);
		orderListPane.add(rmvBtn);	
		
		JPanel orderPay = new JPanel();
		orderPay.setBounds(670, 529, 195, 94);
		orderPay.setBorder(null);
		orderPay.setBackground(Color.WHITE);
		contentPane.add(orderPay);
		orderPay.setLayout(null);

		JRadioButton rdbtnCash = new JRadioButton("?���?");
		boolean a = false;
		rdbtnCash.setSelected(a);	//?��?��?��?��?���? ?��?��?�� ?��?���? ?��?��맒占?���?
		rdbtnCash.setBackground(Color.WHITE);
		rdbtnCash.setBounds(5, 14, 50, 20);
		orderPay.add(rdbtnCash);

		JRadioButton rdbtnCard = new JRadioButton("카드");
		rdbtnCard.setBackground(Color.WHITE);
		rdbtnCard.setFont(new Font("굴림", Font.PLAIN, 11));
		rdbtnCard.setBounds(135, 13, 47, 23);
		orderPay.add(rdbtnCard);

		JComboBox cbBoxCash = new JComboBox();
		cbBoxCash.setFont(new Font("굴림", Font.PLAIN, 11));
		cbBoxCash.setBackground(Color.WHITE);
		cbBoxCash.setModel(new DefaultComboBoxModel(new String[] {"50,000?��", "10,000?��", "5,000?��", "1,000?��", "금액?�� 맞게"}));
		cbBoxCash.setToolTipText("");
		cbBoxCash.setBounds(56, 13, 73, 21);
		orderPay.add(cbBoxCash);
		
		// 결제 ?��?�� ?��?�� ?�� 중복 ?��?��?�� 불�??��?���?
		ButtonGroup radioGroup;
		radioGroup = new ButtonGroup();
		radioGroup.add(rdbtnCash);
		radioGroup.add(rdbtnCard);

		txtFieldOrderMessage = new JTextField();
		txtFieldOrderMessage.setBackground(Color.WHITE);
		txtFieldOrderMessage.setForeground(Color.LIGHT_GRAY);
		txtFieldOrderMessage.setFont(new Font("굴림", Font.PLAIN, 11));
		txtFieldOrderMessage.setText("주문 ?�� ?���??��?�� ?��?��");
		txtFieldOrderMessage.setBounds(8, 50, 115, 24);
		orderPay.add(txtFieldOrderMessage);
		txtFieldOrderMessage.setColumns(10);
		
		JButton btnOrder = new JButton("주문");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tm = (DefaultTableModel) orderTable.getModel();
				int len = orderTable.getRowCount();
				if (len >= 1) { // JTable?�� ?��?�� ?��?��?��?�� ?��?���? + TODO : + 조건문에 ?��?��?��버튼(?��?��/카드) ?��?��?��?�� ?��?��?���??�� 추�?
					price = 0;
					tm.setNumRows(0); 
					totalPrice.setText(Integer.toString(price));
				} 
			}
		});
		btnOrder.setBackground(Color.WHITE);
		btnOrder.setFont(new Font("Gulim", Font.PLAIN, 12));
		btnOrder.setBounds(128, 49, 59, 25);
		orderPay.add(btnOrder);
		
		//메뉴 분류 ?�� ?��?��
	       JTabbedPane Menu = new JTabbedPane(JTabbedPane.TOP);
	       Menu.setBorder(null); 
	       Menu.setBackground(Color.WHITE); 
	       Menu.setBounds(10,159, 645, 464); 
	       contentPane.add(Menu);
	        
	       JScrollPane allScrollPane = new JScrollPane();
	       Menu.addTab("?���? 보기",allScrollPane); 
	       JPanel all = new JPanel(); 
	       //?��체보�? ?��?�� ?�� ?��버로 ?���? 메뉴 리스?�� �??��?���?
	       all.setBackground(Color.WHITE);
	       allScrollPane.setViewportView(all); 
	       all.setLayout(new GridLayout(3, 5));
	       
	       for(int i=0;i<list.size();i++) { 
	          all.add(mc.setMenu(list,i)); 
	       }
	       
	       JScrollPane mealScrollPane = new JScrollPane(); 
	       Menu.addTab("?��?���?",mealScrollPane); 
	       JPanel meal = new JPanel(); 
	       meal.setBackground(Color.WHITE);
	       mealScrollPane.setViewportView(meal); 
	       meal.setLayout(new GridLayout(3, 5));
	       for(int i=0;i<list.size();i++) {
	       if(list.get(i).getMenuCategory().equals("?��?���?")) { 
	          meal.add(mc.setMenu(list,i));
	       } 
	   }
	       
	       JScrollPane rameonScrollPane = new JScrollPane();
	       Menu.addTab("?��면류",rameonScrollPane); 
	       JPanel rameon = new JPanel();
	       rameon.setBackground(Color.WHITE); 
	       rameonScrollPane.setViewportView(rameon);
	       rameon.setLayout(new GridLayout(3, 5));
	       for(int i=0;i<list.size();i++) {
	          if(list.get(i).getMenuCategory().equals("?��면류")) {
		       rameon.add(mc.setMenu(list,i)); 
		      } 
	      }
	       
	       JScrollPane snackScrollPane = new JScrollPane();
	       Menu.addTab("간식�?",snackScrollPane); 
	       JPanel snack = new JPanel();
	       snack.setBackground(Color.WHITE); 
	       snackScrollPane.setViewportView(snack);
	       snack.setLayout(new GridLayout(3, 5)); 
	       for(int i=0;i<list.size();i++) {
		       if(list.get(i).getMenuCategory().equals("간식�?")) {
		    	   snack.add(mc.setMenu(list,i)); 
		       } 
	       }
	       
	       JScrollPane bevScrollPane = new JScrollPane();
	       Menu.addTab("?��료류",bevScrollPane); JPanel bev = new JPanel();
	       bev.setBackground(Color.WHITE); bevScrollPane.setViewportView(bev);
	       bev.setLayout(new GridLayout(3, 5)); 
	       for(int i=0;i<list.size();i++) {
		       if(list.get(i).getMenuCategory().equals("?��료류")) { 
		    	   bev.add(mc.setMenu(list,i));
		       } 
	       }
	       
	       JScrollPane toppingScrollPane = new JScrollPane(); Menu.addTab("?��?���?",
	       toppingScrollPane); JPanel topping = new JPanel();
	       topping.setBackground(Color.WHITE);
	       toppingScrollPane.setViewportView(topping); topping.setLayout(new
	       GridLayout(3, 5)); for(int i=0;i<list.size();i++) {
		       if(list.get(i).getMenuCategory().equals("?��?���?")) {
		    	   topping.add(mc.setMenu(list,i)); 
		       } 
	       }
	       
	   }
	}


