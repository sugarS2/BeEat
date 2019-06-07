package beeat.h_reply.model;

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


class H_ReplyDAO {
	private DataSource ds;
	
	H_ReplyDAO(){
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne) {
		}
	}
	
	
	// findByH_CODE
	ArrayList<H_ReplyDTO> findByHCODE(int h_code) {
		ArrayList<H_ReplyDTO> list = new ArrayList<H_ReplyDTO>();
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rs = null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(H_ReplySQL.FIND_BY_HCODE);
			pstmt.setInt(1, h_code);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int hr_idx = rs.getInt("hr_idx");
				String hr_content = rs.getString("hr_content");
				java.sql.Date hr_date = rs.getDate("hr_date");
				//int h_code = rs.getInt("h_code");
				String email = rs.getString("email");
				String name = rs.getString("name");
				H_ReplyDTO dto = new H_ReplyDTO(hr_idx, hr_content, hr_date, h_code, email, name);
				list.add(dto);
			}
			return list;
		}catch(SQLException se) {
			System.out.println("[SELECT문 오류] "+se);
			return null;
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(SQLException se) {}
		}
	}	
	
	
	// insert 
	void insert(H_ReplyDTO dto) {
		Connection conn=null; PreparedStatement pstmt=null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(H_ReplySQL.INSERT);
			pstmt.setString(1, dto.getHr_content());
			pstmt.setInt(2, dto.getH_code());
			pstmt.setString(3, dto.getEmail());
			int i = pstmt.executeUpdate();
			if(i>0) System.out.println("H_Reply 글쓰기 성공");
			else System.out.println("H_Reply 글쓰기 실패");
		}catch(SQLException se) {
			System.out.println("[INSERT문 오류] "+se);
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(SQLException se) {}
		}
	}
	
	
	// update 
	void update(H_ReplyDTO dto) {
		Connection conn=null; PreparedStatement pstmt=null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(H_ReplySQL.UPDATE);
			pstmt.setString(1, dto.getHr_content());
			pstmt.setInt(2, dto.getHr_idx());
			int i = pstmt.executeUpdate();
			if(i>0) System.out.println("H_Reply 글수정 성공");
			else System.out.println("H_Reply 글수정 실패");
		}catch(SQLException se) {
			System.out.println("[UPDATE문 오류] "+se);
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(SQLException se) {}
		}
	}	
	
	
	// update 
	void delete(int hr_idx) {
		Connection conn=null; PreparedStatement pstmt=null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(H_ReplySQL.DELETE);
			pstmt.setInt(1, hr_idx);
			int i = pstmt.executeUpdate();
			if(i>0) System.out.println("H_Reply 글삭제 성공");
			else System.out.println("H_Reply 글삭제 실패");
		}catch(SQLException se) {
			System.out.println("[DELETE문 오류] "+se);
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(SQLException se) {}
		}
	}	
}
