package beeat.hotplace.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

class HotPlaceDAO {
	private DataSource ds;
	
	HotPlaceDAO(){
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne) {
		}
	}
	
	ArrayList<HotPlaceDTO> findAll() {
		ArrayList<HotPlaceDTO> list = new ArrayList<HotPlaceDTO>();
		Connection conn = null; Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(HotPlaceSQL.FIND_ALL);
			while(rs.next()) {
				int h_code = rs.getInt(1);
				String h_name = rs.getString(2);
				int c_code = rs.getInt(3);
				int loc_code = rs.getInt(4);
				String h_address = rs.getString(5);
				String h_info = rs.getString(6);
				String h_tel = rs.getString(7);
				String h_time = rs.getString(8);
				String h_menu = rs.getString(9);
				String h_img1 = rs.getString(10);
				String h_img2 = rs.getString(11);
				String h_img3 = rs.getString(12);
				int h_readnum = rs.getInt(13);
				int h_grade = rs.getInt(14);
				String email = rs.getString(15);
				HotPlaceDTO dto = new HotPlaceDTO(h_code, h_name, c_code, loc_code, h_address, h_info, h_tel, h_time, h_menu, h_img1, h_img2, h_img3, h_readnum, h_grade, email);
				list.add(dto);
			}
			return list;
		}catch(SQLException se) {
			System.out.println("[SELECT¹® ¿À·ù] "+se);
			return null;
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch(SQLException se) {}
		}
	}
}
