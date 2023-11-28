package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBmanager extends DAO{
	private PreparedStatement pst;
	
	public int login(String id,String password) {
		String sql = "select * from info where id = ?";
		try {
			pst = con.prepareStatement(sql); 
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery(); 
			if(rs.next()) { 
				if(rs.getString("password").equals(password)) {
					return 1;
				}else return 0;
			}else return 2; 
		}catch(Exception e) {
			e.getMessage();
			System.out.println("[DB]login Error...");
			return 3; 
		}
	}
	
	public boolean check(String id) {
		String sql = "select * from info where id = ?";
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
		String sql = "insert into info(id, password, name, birth, phone) values(?,?,?,?,?)";
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
		String sql = "select * from info where id = ?";
		try {
		pst = con.prepareStatement(sql);
		pst.setString(1, id);
		ResultSet rs = pst.executeQuery();
		
		if(rs.next()) {
			int remainTime = rs.getInt("remain_time");
			return remainTime;
		}else return 0; //�젙蹂닿� 議댁옱�븯吏� �븡�쓬
		}catch(Exception e) {
			e.getMessage();
			System.out.println("[DB]check Error...");
			return 1;
		}
	}
	
	public void exit(String id, int time) {
		String sql = "update info set remain_time = ? where id = ?";
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
	
	public void menu() {//硫붾돱 �젙蹂� �쟾遺� �씫�뼱�삤湲�
		String sql = "select * from menu";
		try {
			pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) { //荑쇰━臾몄뿉 ���븳 寃곌낵媛믪씠 議댁옱�븯硫�..
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
