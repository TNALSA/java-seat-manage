package Database;

import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Domain.menu;

public class DBmanager extends DAO{
	private PreparedStatement pst;
	
	public int login(String id,String password) {
		String sql = "select userPassword from users where userId = ?";
		try {
			pst = con.prepareStatement(sql); 
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery(); 
			if(rs.next()) { 
				if(rs.getString("userPassword").equals(password)) {
					return 1;
				}else return 0;
			}else return 2; 
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("[DB]login Error...");
			return 3; 
		}
	}
	
	public boolean check(String id) {
		String sql = "select * from users where userId = ?";
		try {
		pst = con.prepareStatement(sql);
		pst.setString(1, id);
		ResultSet rs = pst.executeQuery();
		
		if(rs.next()) {
			return true; 
		}else return false;
		}catch(Exception e) {
			e.getMessage();
			System.out.println("[DB]check Error...");
			return false;
		}
		
	}
	
	public boolean register(String id,String password, String name, String birth, String phone) {
		String sql = "insert into users(userId, userPassword, userName, userBirth, userPhone) values(?,?,?,?,?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1,id);
			pst.setString(2, password);
			pst.setString(3,name);
			pst.setString(4,birth);
			pst.setString(5,phone);
			pst.executeUpdate();
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public int load(String id) {
		String sql = "select userTime from users where userId = ?";
		try {
		pst = con.prepareStatement(sql);
		pst.setString(1, id);
		ResultSet rs = pst.executeQuery();
		
		if(rs.next()) {
			int remainTime = rs.getInt("userTime");
			return remainTime;
		}else return 0; //�젙蹂닿� 議댁옱�븯吏� �븡�쓬
		}catch(Exception e) {
			e.getMessage();
			System.out.println("[DB]check Error...");
			return 1;
		}
	}
	
	public void exit(String id, int time) {
		String sql = "update users set userTime = ? where userId = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, time);
			pst.setString(2, id);
			pst.executeUpdate();
			
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("[DB]exit Error...");
			}
	}
	
	public List<menu> menu() {
		String sql = "select * from menu";
		try {
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			List<menu> menuList = new ArrayList<menu>();
			
			while(rs.next()) {
				menu md = new menu();
				md.setMenuId(rs.getString("menuId"));
				md.setMenuName(rs.getString("menuName"));
				md.setMenuPrice(rs.getInt("menuPrice"));
				md.setMenuCategory(rs.getString("menuCategory"));
				md.setMenuIsout(rs.getBoolean("menuIsout"));
				md.setMenuImage(rs.getBlob("menuImage"));
				
				menuList.add(md);
			}
			return menuList;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
