
package Server;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.SystemColor;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Caret;

import com.mysql.cj.jdbc.Blob;

public class adminUI {
	private JPanel contentPane;
	JButton btnBrowse;
	JFileChooser fileChooser;
	private JTable menu_table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private ButtonGroup radioGroup;
	
	
	public static JFrame mngFrame = new JFrame();
	public static Object seatNum;
	JRadioButton rdbtnNewRadioButton;
	JRadioButton rdbtnNewRadioButton_1;
	JRadioButton rdbtnNewRadioButton_1_1;
	JRadioButton rdbtnNewRadioButton_1_2;
	JRadioButton rdbtnNewRadioButton_1_3;
	JRadioButton rdbtnNewRadioButton_1_4;
	JButton add_b;
	JButton edit_b;
	JButton del_b;
	String m_category = "전체";
	Server server;
	
	
	static JButton seat1 = new JButton("1");
	static JButton seat5 = new JButton("5");
	static JButton seat2 = new JButton("2");
	static JButton seat6 = new JButton("6");
	static JButton seat3 = new JButton("3");
	static JButton seat7 = new JButton("7");
	static JButton seat8 = new JButton("8");
	static JButton seat4 = new JButton("4");
	static JButton seat9 = new JButton("9");
	static JButton seat11 = new JButton("11");
	static JButton seat10 = new JButton("10");
	static JButton seat12 = new JButton("12");
	static JButton seat13 = new JButton("13");
	static JButton seat14 = new JButton("14");
	static JButton seat15 = new JButton("15");
	static JButton seat16 = new JButton("16");
	static JButton seat17 = new JButton("17");
	static JButton seat18 = new JButton("18");
	static JButton seat24 = new JButton("24");
	static JButton seat19 = new JButton("19");
	static JButton seat20 = new JButton("20");
	static JButton seat21 = new JButton("21");
	static JButton seat25 = new JButton("25");
	static JButton seat30 = new JButton("30");
	static JButton seat23 = new JButton("23");
	static JButton seat26 = new JButton("26");
	static JButton seat28 = new JButton("28");
	static JButton seat22 = new JButton("22");
	static JButton seat29 = new JButton("29");
	static JButton seat27 = new JButton("27");
	JPanel panel;

	static Map<String, JButton> mngbtnMap = new HashMap<>();

	public adminUI() {
		//mngFrame.setIconImage(
				//Toolkit.getDefaultToolkit().getImage("C:\\Users\\msa18\\OneDrive\\Desktop\\占쎈뼄占쎌뒲嚥≪뮆諭� (1).png"));
		mngFrame.setTitle("I4 PC Manage");
		mngFrame.getContentPane().setForeground(new Color(155, 255, 30));
		mngFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mngFrame.setBounds(100, 100, 893, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		mngFrame.setContentPane(contentPane);

		btnBrowse = new JButton("Browse");
		btnBrowse.setBounds(85, 190, 97, 34);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		JPanel seat_t = new JPanel();
		seat_t.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Seat", null, seat_t, null);

		seat1.setBounds(12, 10, 60, 60);
		seat1.setBackground(Color.white);
		seat1.setHorizontalAlignment(SwingConstants.LEFT);
		seat1.setFont(new Font("굴림", Font.BOLD, 10));
		seat1.setVerticalAlignment(SwingConstants.TOP);

		seat5.setBackground(Color.WHITE);
		seat5.setFont(new Font("굴림", Font.BOLD, 10));
		seat5.setBounds(72, 10, 60, 60);
		seat5.setVerticalAlignment(SwingConstants.TOP);
		seat5.setHorizontalAlignment(SwingConstants.LEFT);

		seat2.setBackground(Color.WHITE);
		seat2.setFont(new Font("굴림", Font.BOLD, 10));
		seat2.setVerticalAlignment(SwingConstants.TOP);
		seat2.setHorizontalAlignment(SwingConstants.LEADING);
		seat2.setBounds(12, 70, 60, 60);

		seat6.setBackground(Color.WHITE);
		seat6.setFont(new Font("굴림", Font.BOLD, 10));
		seat6.setVerticalAlignment(SwingConstants.TOP);
		seat6.setHorizontalAlignment(SwingConstants.LEADING);
		seat6.setBounds(72, 70, 60, 60);
		seat6.setText("6");

		seat3.setBackground(Color.WHITE);
		seat3.setFont(new Font("굴림", Font.BOLD, 10));
		seat3.setVerticalAlignment(SwingConstants.TOP);
		seat3.setHorizontalAlignment(SwingConstants.LEADING);
		seat3.setBounds(12, 129, 60, 60);

		seat7.setBackground(Color.WHITE);
		seat7.setFont(new Font("굴림", Font.BOLD, 10));
		seat7.setVerticalAlignment(SwingConstants.TOP);
		seat7.setHorizontalAlignment(SwingConstants.LEADING);
		seat7.setBounds(72, 129, 60, 60);

		seat4.setBackground(Color.WHITE);
		seat4.setFont(new Font("굴림", Font.BOLD, 10));
		seat4.setVerticalAlignment(SwingConstants.TOP);
		seat4.setHorizontalAlignment(SwingConstants.LEADING);
		seat4.setBounds(12, 190, 60, 60);

		seat8.setBackground(Color.WHITE);
		seat8.setFont(new Font("굴림", Font.BOLD, 10));
		seat8.setVerticalAlignment(SwingConstants.TOP);
		seat8.setHorizontalAlignment(SwingConstants.LEADING);
		seat8.setBounds(72, 190, 60, 60);

		seat9.setBackground(Color.WHITE);
//      seat9.setForeground(SystemColor.activeCaption);
		seat9.setFont(new Font("굴림", Font.BOLD, 10));
		seat9.setVerticalAlignment(SwingConstants.TOP);
		seat9.setHorizontalAlignment(SwingConstants.LEFT);
		seat9.setBounds(178, 10, 60, 60);

		seat10.setBackground(Color.WHITE);
//      seat10.setForeground(SystemColor.activeCaption);
		seat10.setFont(new Font("굴림", Font.BOLD, 10));
		seat10.setVerticalAlignment(SwingConstants.TOP);
		seat10.setHorizontalAlignment(SwingConstants.LEFT);
		seat10.setBounds(178, 70, 60, 60);

		seat11.setBackground(Color.WHITE);
		// seat11.setForeground(SystemColor.activeCaption);
		seat11.setFont(new Font("굴림", Font.BOLD, 10));
		seat11.setVerticalAlignment(SwingConstants.TOP);
		seat11.setHorizontalAlignment(SwingConstants.LEFT);
		seat11.setBounds(178, 129, 60, 60);

		seat12.setBackground(Color.WHITE);
//      seat12.setForeground(SystemColor.activeCaption);
		seat12.setFont(new Font("굴림", Font.BOLD, 10));
		seat12.setVerticalAlignment(SwingConstants.TOP);
		seat12.setHorizontalAlignment(SwingConstants.LEFT);
		seat12.setBounds(178, 190, 60, 60);

		seat13.setBackground(Color.WHITE);
//      seat13.setForeground(SystemColor.activeCaption);
		seat13.setFont(new Font("굴림", Font.BOLD, 10));
		seat13.setVerticalAlignment(SwingConstants.TOP);
		seat13.setHorizontalAlignment(SwingConstants.LEFT);
		seat13.setBounds(238, 10, 60, 60);

		seat14.setBackground(Color.WHITE);
//      seat14.setForeground(SystemColor.activeCaption);
		seat14.setFont(new Font("굴림", Font.BOLD, 10));
		seat14.setVerticalAlignment(SwingConstants.TOP);
		seat14.setHorizontalAlignment(SwingConstants.LEFT);
		seat14.setBounds(238, 70, 60, 60);

		seat15.setBackground(Color.WHITE);
		// seat15.setForeground(SystemColor.activeCaption);
		seat15.setFont(new Font("굴림", Font.BOLD, 10));
		seat15.setVerticalAlignment(SwingConstants.TOP);
		seat15.setHorizontalAlignment(SwingConstants.LEFT);
		seat15.setBounds(238, 129, 60, 60);

		seat16.setBackground(Color.WHITE);
		// seat16.setForeground(SystemColor.activeCaption);
		seat16.setFont(new Font("굴림", Font.BOLD, 10));
		seat16.setVerticalAlignment(SwingConstants.TOP);
		seat16.setHorizontalAlignment(SwingConstants.LEFT);
		seat16.setBounds(238, 190, 60, 60);

		seat17.setBackground(Color.WHITE);
		// seat17.setForeground(SystemColor.activeCaption);
		seat17.setFont(new Font("굴림", Font.BOLD, 10));
		seat17.setVerticalAlignment(SwingConstants.TOP);
		seat17.setHorizontalAlignment(SwingConstants.LEFT);
		seat17.setBounds(375, 10, 60, 60);

		seat18.setBackground(Color.WHITE);
//      seat18.setForeground(SystemColor.activeCaption);
		seat18.setFont(new Font("굴림", Font.BOLD, 10));
		seat18.setVerticalAlignment(SwingConstants.TOP);
		seat18.setHorizontalAlignment(SwingConstants.LEFT);
		seat18.setBounds(434, 10, 60, 60);
		
		
		seat24.setBackground(Color.WHITE);
		// seat24.setForeground(SystemColor.activeCaption);
		seat24.setFont(new Font("굴림", Font.BOLD, 10));
		seat24.setVerticalAlignment(SwingConstants.TOP);
		seat24.setHorizontalAlignment(SwingConstants.LEFT);
		seat24.setBounds(375, 70, 60, 60);

		seat19.setBackground(Color.WHITE);
		// seat19.setForeground(SystemColor.activeCaption);
		seat19.setFont(new Font("굴림", Font.BOLD, 10));
		seat19.setVerticalAlignment(SwingConstants.TOP);
		seat19.setHorizontalAlignment(SwingConstants.LEFT);
		seat19.setBounds(493, 10, 60, 60);

		seat20.setBackground(Color.WHITE);
//      seat20.setForeground(SystemColor.activeCaption);
		seat20.setFont(new Font("굴림", Font.BOLD, 10));
		seat20.setVerticalAlignment(SwingConstants.TOP);
		seat20.setHorizontalAlignment(SwingConstants.LEFT);
		seat20.setBounds(553, 10, 60, 60);

		seat25.setBackground(Color.WHITE);
		// seat25.setForeground(SystemColor.activeCaption);
		seat25.setFont(new Font("�뤃���뵝", Font.BOLD, 10));
		seat25.setVerticalAlignment(SwingConstants.TOP);
		seat25.setHorizontalAlignment(SwingConstants.LEFT);
		seat25.setBounds(434, 70, 60, 60);

		seat26.setBackground(Color.WHITE);
		// seat26.setForeground(SystemColor.activeCaption);
		seat26.setFont(new Font("굴림", Font.BOLD, 10));
		seat26.setVerticalAlignment(SwingConstants.TOP);
		seat26.setHorizontalAlignment(SwingConstants.LEFT);
		seat26.setBounds(493, 70, 60, 60);

		seat27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		seat27.setBackground(Color.WHITE);
//      seat27.setForeground(SystemColor.activeCaption);
		seat27.setFont(new Font("굴림", Font.BOLD, 10));
		seat27.setVerticalAlignment(SwingConstants.TOP);
		seat27.setHorizontalAlignment(SwingConstants.LEFT);
		seat27.setBounds(553, 70, 60, 60);

//      seat21.setContentAreaFilled(false);
//      seat21.setOpaque(true);
		seat21.setBackground(Color.WHITE);
		// seat21.setForeground(SystemColor.activeCaption);
		seat21.setFont(new Font("굴림", Font.BOLD, 10));
		seat21.setVerticalAlignment(SwingConstants.TOP);
		seat21.setHorizontalAlignment(SwingConstants.LEFT);
		seat21.setBounds(612, 10, 60, 60);

		seat28.setBackground(Color.WHITE);
		// seat28.setForeground(SystemColor.activeCaption);
		seat28.setFont(new Font("굴림", Font.BOLD, 10));
		seat28.setVerticalAlignment(SwingConstants.TOP);
		seat28.setHorizontalAlignment(SwingConstants.LEFT);
		seat28.setBounds(612, 70, 60, 60);

		seat22.setBackground(Color.WHITE);
		// seat22.setForeground(SystemColor.activeCaption);
		seat22.setFont(new Font("굴림", Font.BOLD, 10));
		seat22.setVerticalAlignment(SwingConstants.TOP);
		seat22.setHorizontalAlignment(SwingConstants.LEFT);
		seat22.setBounds(672, 10, 60, 60);

		seat29.setBackground(Color.WHITE);
		// seat29.setForeground(SystemColor.activeCaption);
		seat29.setFont(new Font("굴림", Font.BOLD, 10));
		seat29.setVerticalAlignment(SwingConstants.TOP);
		seat29.setHorizontalAlignment(SwingConstants.LEFT);
		seat29.setBounds(672, 70, 60, 60);

		seat23.setBackground(Color.WHITE);
		// seat23.setForeground(SystemColor.activeCaption);
		seat23.setFont(new Font("굴림", Font.BOLD, 10));
		seat23.setVerticalAlignment(SwingConstants.TOP);
		seat23.setHorizontalAlignment(SwingConstants.LEFT);
		seat23.setBounds(731, 10, 60, 60);

		seat30.setBackground(Color.WHITE);
		// seat30.setForeground(SystemColor.activeCaption);
		seat30.setFont(new Font("굴림", Font.BOLD, 10));
		seat30.setVerticalAlignment(SwingConstants.TOP);
		seat30.setHorizontalAlignment(SwingConstants.LEFT);
		seat30.setBounds(731, 70, 60, 60);

		JButton[] button = new JButton[] 
				{ 
				seat1, seat2, seat3, seat4, seat5, 
				seat6, seat7, seat8, seat9, seat10,
				seat11, seat12, seat13, seat14, seat15, 
				seat16, seat17, seat18, seat19, seat20, 
				seat21, seat22, seat23,seat24, seat25, 
				seat26, seat27, seat28, seat29, seat30 
				};
		
		for (int i = 0; i < button.length; i++) {
			mngbtnMap.put(Integer.toString(i + 1), button[i]);
		}

		seat_t.setLayout(null);
		seat_t.add(seat1);
		seat_t.add(seat5);
		seat_t.add(seat2);
		seat_t.add(seat6);
		seat_t.add(seat3);
		seat_t.add(seat7);
		seat_t.add(seat4);
		seat_t.add(seat8);
		seat_t.add(seat9);
		seat_t.add(seat10);
		seat_t.add(seat11);
		seat_t.add(seat12);
		seat_t.add(seat13);
		seat_t.add(seat14);
		seat_t.add(seat15);
		seat_t.add(seat16);
		seat_t.add(seat17);
		seat_t.add(seat18);
		seat_t.add(seat24);
		seat_t.add(seat19);
		seat_t.add(seat20);
		seat_t.add(seat25);
		seat_t.add(seat26);
		seat_t.add(seat27);
		seat_t.add(seat21);
		seat_t.add(seat28);
		seat_t.add(seat22);
		seat_t.add(seat29);
		seat_t.add(seat23);
		seat_t.add(seat30);

		TextArea textArea = new TextArea();
		textArea.setBounds(375, 190, 440, 222);
		seat_t.add(textArea);

		JButton btnNewButton_1 = new JButton("채팅");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setForeground(SystemColor.inactiveCaption);
		btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 12));

		btnNewButton_1.setBounds(383, 438, 97, 35);
		seat_t.add(btnNewButton_1);

		JPanel menu_t = new JPanel();
		menu_t.setBackground(SystemColor.inactiveCaption);
		tabbedPane.addTab("Menu", null, menu_t, null);
		menu_t.setLayout(null);

		radioGroup = new ButtonGroup();

		rdbtnNewRadioButton = new JRadioButton("전체");
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBounds(8, 6, 121, 23);
		rdbtnNewRadioButton.setBackground(SystemColor.inactiveCaption);
		rdbtnNewRadioButton.setActionCommand("전체");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				m_category = "전체";
			}

		});

		menu_t.add(rdbtnNewRadioButton);

		rdbtnNewRadioButton_1 = new JRadioButton("식사류");
		rdbtnNewRadioButton_1.setBounds(133, 6, 121, 23);
		rdbtnNewRadioButton_1.setBackground(SystemColor.inactiveCaption);
		rdbtnNewRadioButton_1.setActionCommand("식사류");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				m_category = "식사류";
				
			}

		});
		menu_t.add(rdbtnNewRadioButton_1);

		rdbtnNewRadioButton_1_1 = new JRadioButton("라면류");
		rdbtnNewRadioButton_1_1.setBounds(258, 6, 121, 23);
		rdbtnNewRadioButton_1_1.setBackground(SystemColor.inactiveCaption);
		rdbtnNewRadioButton_1_1.setActionCommand("라면류");
		// rdbtnNewRadioButton_1_1.addActionListener(this);
		rdbtnNewRadioButton_1_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				m_category = "라면류";
				

			}

		});
		menu_t.add(rdbtnNewRadioButton_1_1);

		rdbtnNewRadioButton_1_2 = new JRadioButton("음료류");
		rdbtnNewRadioButton_1_2.setBounds(383, 6, 121, 23);
		rdbtnNewRadioButton_1_2.setBackground(SystemColor.inactiveCaption);
		rdbtnNewRadioButton_1_2.setActionCommand("음료류");
		// rdbtnNewRadioButton_1_2.addActionListener(this);
		rdbtnNewRadioButton_1_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				m_category = "음료류";

			}

		});
		menu_t.add(rdbtnNewRadioButton_1_2);

		rdbtnNewRadioButton_1_3 = new JRadioButton("간식류");
		rdbtnNewRadioButton_1_3.setBounds(508, 6, 121, 23);
		rdbtnNewRadioButton_1_3.setBackground(SystemColor.inactiveCaption);
		rdbtnNewRadioButton_1_3.setActionCommand("간식류");
		// rdbtnNewRadioButton_1_3.addActionListener(this);
		rdbtnNewRadioButton_1_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				m_category = "간식류";
				
			}

		});
		
		menu_t.add(rdbtnNewRadioButton_1_3);

		rdbtnNewRadioButton_1_4 = new JRadioButton("토핑");
		rdbtnNewRadioButton_1_4.setBounds(633, 6, 78, 23);
		rdbtnNewRadioButton_1_4.setBackground(SystemColor.inactiveCaption);
		rdbtnNewRadioButton_1_4.setActionCommand("토핑");
		rdbtnNewRadioButton_1_4.addActionListener(new ActionListener() {
			@Override
		public void actionPerformed(ActionEvent e) {
			m_category = "토핑";
		
		}

		});
		menu_t.add(rdbtnNewRadioButton_1_4);

		radioGroup.add(rdbtnNewRadioButton);
		radioGroup.add(rdbtnNewRadioButton_1);
		radioGroup.add(rdbtnNewRadioButton_1_1);
		radioGroup.add(rdbtnNewRadioButton_1_2);
		radioGroup.add(rdbtnNewRadioButton_1_3);
		radioGroup.add(rdbtnNewRadioButton_1_4);

		String[] header = { "메뉴번호","메뉴명","가격","분류" };

		add_b = new JButton("추가");
		add_b.setBounds(30, 310, 97, 34);
		menu_t.add(add_b);
		

		edit_b = new JButton("수정");
		edit_b.setBounds(140, 310, 97, 34);
		menu_t.add(edit_b);
		

		del_b = new JButton("삭제");
		del_b.setBounds(249, 310, 97, 34);
		menu_t.add(del_b);
		

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(387, 40, 451, 422);
		menu_t.add(scrollPane);

		menu_table = new JTable();
		JButton btn = new JButton("버튼");
		menu_table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		menu_table.setModel(new DefaultTableModel(new Object[][] {

				{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null }, { null, null, null, null }, },
				new String[] { "\uBA54\uB274\uBC88\uD638", "\uBA54\uB274\uBA85", "\uAC00\uACA9", "\uBD84\uB958" }) {
			Class[] columnTypes = new Class[] { Object.class, String.class, Object.class, Object.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		menu_table.getColumnModel().getColumn(0).setResizable(false);
		menu_table.getColumnModel().getColumn(1).setResizable(false);
		menu_table.getColumnModel().getColumn(1).setPreferredWidth(137);
		menu_table.getColumnModel().getColumn(2).setPreferredWidth(94);
		menu_table.getColumnModel().getColumn(3).setResizable(false);
		scrollPane.setViewportView(menu_table);

		panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"\uBA54\uB274\uB4F1\uB85D", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(15, 62, 349, 227);
		menu_t.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("메뉴명");
		lblNewLabel.setBounds(27, 38, 45, 28);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("KoPubWorld돋움체 Medium", Font.PLAIN, 13));

		textField_3 = new JTextField();
		textField_3.setBounds(86, 39, 226, 28);
		panel.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblPrice = new JLabel("가격");
		lblPrice.setBounds(27, 100, 45, 28);
		panel.add(lblPrice);
		lblPrice.setFont(new Font("KoPubWorld돋움체 Medium", Font.PLAIN, 13));

		textField_2 = new JTextField();
		textField_2.setBounds(86, 101, 226, 28);
		panel.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblPrice_1 = new JLabel("이미지");
		lblPrice_1.setBounds(27, 165, 45, 28);
		panel.add(lblPrice_1);
		lblPrice_1.setFont(new Font("KoPubWorld돋움체 Medium", Font.PLAIN, 13));

		textField_1 = new JTextField();
		textField_1.setBounds(86, 166, 226, 28);
		panel.add(textField_1);
		textField_1.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"\uAC80\uC0C9", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_1.setBounds(15, 362, 349, 100);
		menu_t.add(panel_1);
		panel_1.setLayout(null);

		textField = new JTextField();
		textField.setBounds(86, 39, 226, 28);
		panel_1.add(textField);
		textField.setColumns(10);
		textField.addKeyListener(new KeyAdapter() {
		});

		JLabel lblPrice_1_1 = new JLabel("메뉴번호");
		lblPrice_1_1.setBounds(27, 38, 45, 28);
		panel_1.add(lblPrice_1_1);
		lblPrice_1_1.setFont(new Font("KoPubWorld돋움체 Medium", Font.PLAIN, 13));

		panel.add(btnBrowse);
		
	}
	
}
