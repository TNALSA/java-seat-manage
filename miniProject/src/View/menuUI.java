package Client;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


public class menuUI extends JFrame {
	private JPanel contentPane;
	private JTextField txtFieldOrderMessage;
	static JTable orderTable;
	static DefaultTableModel model = new DefaultTableModel(new Object[][] {}, //占쎈�믭옙�뵠�뇡占� 揶쏉옙 
			new String[] {
					"상품 이름", "가격", "수량"
				}) ;
	static int len;
	static int price;
	static JLabel totalPrice;
	
	
	//menuCom mc = new menuCom();
	

	public menuUI() {
		setResizable(false);
		setBackground(Color.WHITE);
		setTitle("먹거리 주문");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBackground(Color.WHITE);
		setBounds(100, 100, 893, 672);

		JMenuBar menuBar = new JMenuBar();
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(30, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("신상품");
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

		JLabel totalPriceNotice = new JLabel("총 금액 :");
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
			price += (int) orderTable.getValueAt(i, 1) *(int) orderTable.getValueAt(i, 2);	//占쎄맒占쎈�� 揶쏉옙野껓옙 *  占쎈땾占쎌쎗
		}
		totalPrice.setText(Integer.toString(price));
		
			JButton delBtn = new JButton("삭제");
			delBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int n = orderTable.getSelectedRow();
					DefaultTableModel tm = (DefaultTableModel)orderTable.getModel();
					if(n>=0 && n<orderTable.getRowCount()) {
						tm.removeRow(n);
						len = orderTable.getRowCount();
						price = 0;
						for(int i=0; i<len; i++) {
							price += (int) orderTable.getValueAt(i, 1) *(int) orderTable.getValueAt(i, 2);	//占쎄맒占쎈�� 揶쏉옙野껓옙 *  占쎈땾占쎌쎗
						}
						totalPrice.setText(Integer.toString(price));
					}
				}
			});
			delBtn.setBackground(Color.WHITE);
			delBtn.setBounds(102, 254, 70, 26);
			orderListPane.add(delBtn);
				
		//�닔�웾 媛먯냼 踰꾪듉
		JButton addBtn = new JButton("-");
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
						price += (int) orderTable.getValueAt(i, 1) *(int) orderTable.getValueAt(i, 2);	//占쎄맒占쎈�� 揶쏉옙野껓옙 *  占쎈땾占쎌쎗
					}
					totalPrice.setText(Integer.toString(price));
				} catch(Exception e1) {
					
				}
			}
		});
		addBtn.setBackground(Color.WHITE);
		addBtn.setBounds(29, 254, 58, 12);
		orderListPane.add(addBtn);
		
		JButton rmvBtn = new JButton("+");
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
						price += (int) orderTable.getValueAt(i, 1) *(int) orderTable.getValueAt(i, 2);	//占쎄맒占쎈�� 揶쏉옙野껓옙 *  占쎈땾占쎌쎗
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

		JRadioButton rdbtnCash = new JRadioButton("현금");
		boolean a = false;
		rdbtnCash.setSelected(a);	//占쎄퐨占쎄문 占쎈툧 占쎈쭆 占쎄맒占쎄묶
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
		cbBoxCash.setModel(new DefaultComboBoxModel(new String[] {"50,000원", "10,000원", "5,000원", "1,000원", "금액에 맞게"}));
		cbBoxCash.setToolTipText("");
		cbBoxCash.setBounds(56, 13, 73, 21);
		orderPay.add(cbBoxCash);
		
		// 결제 수단 선택 시 중복 선택이 불가하도록
		ButtonGroup radioGroup;
		radioGroup = new ButtonGroup();
		radioGroup.add(rdbtnCash);
		radioGroup.add(rdbtnCard);

		txtFieldOrderMessage = new JTextField();
		txtFieldOrderMessage.setBackground(Color.WHITE);
		txtFieldOrderMessage.setForeground(Color.LIGHT_GRAY);
		txtFieldOrderMessage.setFont(new Font("굴림", Font.PLAIN, 11));
		txtFieldOrderMessage.setText("주문 시 요청사항 입력");
		txtFieldOrderMessage.setBounds(8, 50, 115, 24);
		orderPay.add(txtFieldOrderMessage);
		txtFieldOrderMessage.setColumns(10);
		
		JButton btnOrder = new JButton("주문");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tm = (DefaultTableModel) orderTable.getModel();
				int len = orderTable.getRowCount();
				if (len >= 1) { // JTable에 행이 하나라도 있다면 + TODO : + 조건문에 라디오버튼(현큼/카드) 하나라도 눌렸는지도 추가
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
		
		//硫붾돱 遺꾨쪟 �꺆 �깮�꽦
	       JTabbedPane Menu = new JTabbedPane(JTabbedPane.TOP);
	       Menu.setBorder(null); 
	       Menu.setBackground(Color.WHITE); 
	       Menu.setBounds(10,159, 645, 464); 
	       contentPane.add(Menu);
	        
	       JScrollPane allScrollPane = new JScrollPane();
	       Menu.addTab("전체 보기",allScrollPane); 
	       JPanel all = new JPanel(); 
	       //�쟾泥대낫湲� �꽑�깮 �떆 �꽌踰꾨줈 �쟾泥� 硫붾돱 由ъ뒪�듃 媛��졇�삤湲� �슂泥� 
	       all.setBackground(Color.WHITE);
	       allScrollPane.setViewportView(all); 
	       all.setLayout(new GridLayout(3, 5));
	       //�슂泥��쓽 寃곌낵媛믪쓣 �쟾�떖諛쏆븘 異붽�
//	       for(int i=0;i<menuCom.list.size();i++) { 
//	          all.add(menu.setMenu(i)); 
//	          }
	       
	       JScrollPane mealScrollPane = new JScrollPane(); 
	       Menu.addTab("식사류",mealScrollPane); 
	       JPanel meal = new JPanel(); 
	       meal.setBackground(Color.WHITE);
	       mealScrollPane.setViewportView(meal); 
	       meal.setLayout(new GridLayout(3, 5));
//	       for(int i=0;i<menu.list.size();i++) {
//	       if(menu.list.get(i).getCategory().equals("�떇�궗瑜�")) { 
//	          meal.add(menu.setMenu(i));
//	       } 
//	   }
	       
	       JScrollPane rameonScrollPane = new JScrollPane();
	       Menu.addTab("라면류",rameonScrollPane); 
	       JPanel rameon = new JPanel();
	       rameon.setBackground(Color.WHITE); 
	       rameonScrollPane.setViewportView(rameon);
	       rameon.setLayout(new GridLayout(3, 5));
//	       for(int i=0;i<menu.list.size();i++) {
//	          if(menu.list.get(i).getCategory().equals("�씪硫대쪟")) {
//	       rameon.add(menu.setMenu(i)); 
//	       } 
//	      }
	       
	       JScrollPane snackScrollPane = new JScrollPane();
	       Menu.addTab("간식류",snackScrollPane); 
	       JPanel snack = new JPanel();
	       snack.setBackground(Color.WHITE); 
	       snackScrollPane.setViewportView(snack);
//	       snack.setLayout(new GridLayout(3, 5)); for(int i=0;i<menu.list.size();i++) {
//	       if(menu.list.get(i).getCategory().equals("간식류")) {
//	       snack.add(menu.setMenu(i)); } }
//	       
	       JScrollPane bevScrollPane = new JScrollPane();
	       Menu.addTab("음료류",bevScrollPane); JPanel bev = new JPanel();
	       bev.setBackground(Color.WHITE); bevScrollPane.setViewportView(bev);
//	       bev.setLayout(new GridLayout(3, 5)); for(int i=0;i<menu.list.size();i++) {
//	       if(menu.list.get(i).getCategory().equals("음료류")) { bev.add(menu.setMenu(i));
//	       } }
//	       
	       JScrollPane toppingScrollPane = new JScrollPane(); Menu.addTab("토핑류",
	       toppingScrollPane); JPanel topping = new JPanel();
	       topping.setBackground(Color.WHITE);
//	       toppingScrollPane.setViewportView(topping); topping.setLayout(new
//	       GridLayout(3, 5)); for(int i=0;i<menu.list.size();i++) {
//	       if(menu.list.get(i).getCategory().equals("토핑류")) {
//	       topping.add(menu.setMenu(i)); } }
//	       
	   }
	}


