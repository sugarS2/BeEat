package beeat.hotplace.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	// findAll
	ArrayList<HotPlaceDTO> findAll() {
		ArrayList<HotPlaceDTO> list = new ArrayList<HotPlaceDTO>();
		Connection conn = null; Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(HotPlaceSQL.FIND_ALL);
			while(rs.next()) {
				int h_code = rs.getInt("h_code");
				String h_name = rs.getString("h_name");
				int c_code = rs.getInt("c_code");
				int loc_code = rs.getInt("loc_code");
				String h_address = rs.getString("h_address");
				String h_info = rs.getString("h_info");
				String h_tel = rs.getString("h_tel");
				String h_time = rs.getString("h_time");
				String h_menu = rs.getString("h_menu");
				String h_img1 = rs.getString("h_img1");
				String h_img2 = rs.getString("h_img2");
				String h_img3 = rs.getString("h_img3");
				int h_readnum = rs.getInt("h_readnum");
				int h_grade = rs.getInt("h_grade");
				String email = rs.getString("email");
				HotPlaceDTO dto = new HotPlaceDTO(h_code, h_name, c_code, loc_code, h_address, h_info, h_tel, h_time, h_menu, h_img1, h_img2, h_img3, h_readnum, h_grade, email);
				list.add(dto);
			}
			return list;
		}catch(SQLException se) {
			System.out.println("[SELECT�� ����] "+se);
			return null;
		}finally {
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				if(conn!=null) conn.close();
			}catch(SQLException se) {}
		}
	}
	
	
	// insert 
	void insert(HotPlaceDTO dto) {
		Connection conn=null; PreparedStatement pstmt=null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(HotPlaceSQL.INSERT);
			pstmt.setString(1, dto.getH_name());
			pstmt.setInt(2, dto.getC_code());
			pstmt.setInt(3, dto.getLoc_code());
			pstmt.setString(4, dto.getH_address());
			pstmt.setString(5, dto.getH_info());
			pstmt.setString(6, dto.getH_tel());
			pstmt.setString(7, dto.getH_time());
			pstmt.setString(8, dto.getH_menu());
			pstmt.setString(9, dto.getH_img1());
			pstmt.setString(10, dto.getH_img2());
			pstmt.setString(11, dto.getH_img3());
			pstmt.setInt(12, dto.getH_readnum());
			pstmt.setFloat(13, dto.getH_grade());
			pstmt.setString(14, dto.getEmail());
			
			int i = pstmt.executeUpdate();
			if(i>0) System.out.println("HotPlace �۾��� ����");
			else System.out.println("HotPlace �۾��� ����");
		}catch(SQLException se) {
			System.out.println("[INSERT�� ����] "+se);
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(SQLException se) {}
		}
	}
	
	
	// findByCode
	HotPlaceDTO findByCode(int h_code) {
		Connection conn=null; PreparedStatement pstmt=null; ResultSet rs=null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(HotPlaceSQL.FIND_BY_CODE);
			pstmt.setInt(1, h_code);
			rs = pstmt.executeQuery();
			rs.next();
			//int h_code = rs.getInt("h_code");
			String h_name = rs.getString("h_name");
			int c_code = rs.getInt("c_code");
			int loc_code = rs.getInt("loc_code");
			String h_address = rs.getString("h_address");
			String h_info = rs.getString("h_info");
			String h_tel = rs.getString("h_tel");
			String h_time = rs.getString("h_time");
			String h_menu = rs.getString("h_menu");
			String h_img1 = rs.getString("h_img1");
			String h_img2 = rs.getString("h_img2");
			String h_img3 = rs.getString("h_img3");
			int h_readnum = rs.getInt("h_readnum");
			int h_grade = rs.getInt("h_grade");
			String email = rs.getString("email");
			String loc_addr1 = rs.getString("loc_addr1");
			String loc_addr2 = rs.getString("loc_addr2");
			String c_name = rs.getString("c_name");
			HotPlaceDTO dto = new HotPlaceDTO(h_code, h_name, c_code, loc_code, h_address, h_info, h_tel, h_time, h_menu, h_img1, h_img2, h_img3, h_readnum, h_grade, email, loc_addr1, loc_addr2, c_name);
			return dto; 
		}catch(SQLException se) {
			System.out.println("[SELECT�� ����] "+se);
			return null;
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(SQLException se) {}
		}
	}
}
