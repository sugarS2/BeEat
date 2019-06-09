package beeat.board.model;

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

import beeat.board.model.B_ReplyDTO;

class BoardDAO {
	private DataSource ds;
	
	BoardDAO(){
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne) {
		}
	}
	
	//list
	ArrayList<BoardDTO> list(){
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(BoardSQL.FIND_ALL);
			while(rs.next()) {
				int b_code = rs.getInt("b_code");
				String b_title = rs.getString("b_title");
				int c_code = rs.getInt("c_code");
				String b_content = rs.getString("b_content");
				String b_img1 = rs.getString("b_img1");
				String b_img2 = rs.getString("b_img2");
				String b_img3 = rs.getString("b_img3");
				java.sql.Date b_date = rs.getDate("b_date");
				int b_readnum = rs.getInt("b_readnum");
				String email = rs.getString("email");
				BoardDTO dto = new BoardDTO(b_code, b_title, c_code, b_content, b_img1, b_img2, b_img3,
						b_date, b_readnum, email);
				list.add(dto);
			}
			return list;
		}catch(SQLException se) {
			System.out.println("[SELECT문 오류] : " + se);
			return null;
		}finally {
			try {
				if(stmt!=null) stmt.close();
				if(con!=null) con.close();
			}catch(SQLException se) {}
		}
	}
	
	//insert
	void insert(BoardDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(BoardSQL.INSERT_CONTENT);
			pstmt.setString(1, dto.getB_title());
			pstmt.setInt(2, dto.getC_code());
			pstmt.setString(3, dto.getB_content());
			pstmt.setString(4, dto.getB_img1());
			pstmt.setString(5, dto.getB_img2());
			pstmt.setString(6, dto.getB_img3());
			pstmt.setString(7, dto.getEmail());
			pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println("[INSERT문 오류] : " + se);
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(SQLException se) {}
		}
	}
	
	//content
	BoardDTO content(int b_code) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(BoardSQL.FIND_WITH_CATEGORY);
			pstmt.setInt(1, b_code);
			rs = pstmt.executeQuery();
			rs.next();
			String b_title = rs.getString("b_title");
			int c_code = rs.getInt("c_code");
			String b_content = rs.getString("b_content");
			String b_img1 = rs.getString("b_img1");
			String b_img2 = rs.getString("b_img2");
			String b_img3 = rs.getString("b_img3");
			java.sql.Date b_date = rs.getDate("b_date");
			int b_readnum = rs.getInt("b_readnum");
			String email = rs.getString("email");
			String c_name = rs.getString("c_name");
			BoardDTO dto = new BoardDTO(b_code, b_title, c_code, b_content, b_img1, b_img2, b_img3,
					b_date, b_readnum, email, c_name);	
			return dto;
		}catch(SQLException se) {
			System.out.println("[SELECT문 에러] : " + se);
			return null;
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(SQLException se) {
			}
		}
	}
	
	//update
	void update(BoardDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(BoardSQL.UPDATE_CONTENT);
			pstmt.setString(1, dto.getB_title());
			pstmt.setInt(2, dto.getC_code());
			pstmt.setString(3, dto.getB_content());
			pstmt.setString(4, dto.getB_img1());
			pstmt.setString(5, dto.getB_img2());
			pstmt.setString(6, dto.getB_img3());
			pstmt.setInt(7, dto.getB_code());
			pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println("[UPDATE문 오류] : " + se);
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(SQLException se) {}
		}
	}
	
	//delete
	void delete(int b_code) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(BoardSQL.DELETE_CONTENT);
			pstmt.setInt(1, b_code);
			pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println("[DELETE문 오류] : " + se);
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(SQLException se) {}
		}
	}
	
	//reply
	public ArrayList<B_ReplyDTO> reply(int b_code) {
		ArrayList<B_ReplyDTO> list = new ArrayList<B_ReplyDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(BoardSQL.REPLY);
			pstmt.setInt(1, b_code);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int br_idx = rs.getInt(1);
				String br_content = rs.getString(2);
				java.sql.Date br_date = rs.getDate(3);
				int br_refer = rs.getInt(4);
				int br_lev = rs.getInt(5);
				int br_order = rs.getInt(6);
				b_code = rs.getInt(7);
				String email = rs.getString(8);
				String name = rs.getString(9);
				B_ReplyDTO dto = new B_ReplyDTO(br_idx, br_content, br_date, br_refer, br_lev, br_order, b_code, email, name);
				list.add(dto);
			}
			return list;
		}catch(SQLException se) {
			return null;
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(SQLException se) {}
		}
	}
	
	//insert reply
	public void insertRe(B_ReplyDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(BoardSQL.INSERT_REPLY);
			pstmt.setString(1, dto.getBr_content());
			pstmt.setInt(2, dto.getB_code());
			pstmt.setString(3, dto.getEmail());
			pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println("[INSERT문 오류] : " + se);
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(SQLException se) {}
		}
	}
	
	//delete reply
	public void deleteRe(int br_idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(BoardSQL.DELETE_REPLY);
			pstmt.setInt(1, br_idx);
			pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println("[DELETE문 오류] : " + se);
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(SQLException se) {
			}
		}
	}
	
	//reply reply
	public void insertReRe(B_ReplyDTO dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(BoardSQL.REPLY_REPLY);
			pstmt.setString(1, dto.getBr_content());
			pstmt.setInt(2, dto.getBr_refer());
			pstmt.setInt(3, dto.getBr_lev());
			pstmt.setInt(4, dto.getBr_order());
			pstmt.setInt(5, dto.getB_code());
			pstmt.setString(6, dto.getEmail());
			pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println("[INSERT문 오류] : " + se);
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(SQLException se) {
			}
		}
	}
	
	//reply order update
	public void updateRe(int br_order) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(BoardSQL.REPLY_ORDER);
			pstmt.setInt(1, br_order);
			pstmt.executeUpdate();
		}catch(SQLException se) {
			System.out.println("[UPDATE문 오류] : " + se);
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(SQLException se) {
			}
		}
	}
	
	//reply content
	public B_ReplyDTO reContent(int br_idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(BoardSQL.SELECT_REPLY);
			pstmt.setInt(1, br_idx);
			rs = pstmt.executeQuery();
			rs.next();
			String br_content = rs.getString("br_content");
			java.sql.Date br_date = rs.getDate("br_date");
			int br_refer = rs.getInt("br_refer");
			int br_lev = rs.getInt("br_lev");
			int br_order = rs.getInt("br_order");
			int b_code = rs.getInt("b_code");
			String email = rs.getString("email");
			String name = rs.getString("name");
			B_ReplyDTO dto = new B_ReplyDTO(br_idx, br_content, br_date, br_refer, br_lev, br_order, b_code, email, name);
			return dto;
		}catch(SQLException se) {
			System.out.println("[SELECT문 오류] : " + se);
			return null;
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(SQLException se) {
			}
		}
	}
	
}
