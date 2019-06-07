package beeat.member.model;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

class MemberDAO {
private DataSource ds;
	
	MemberDAO(){
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne) {
		}
	}
	
	// validate
	int validate(String email){
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rs = null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(MemberSQL.FIND_BY_EMAIL);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			rs.next(); 
			return rs.getInt(1);
		}catch(SQLException se) {
			System.out.println("[SELECT문 오류] "+se);
			return -1;
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(SQLException se) {}
		}
	}
	
	// signup
	void signup(MemberDTO dto) {
		Connection conn = null; PreparedStatement pstmt = null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(MemberSQL.SIGN_UP);
			pstmt.setString(1,dto.getEmail());
			pstmt.setString(2,dto.getName());
			pstmt.setString(3,dto.getPwd());
			int i = pstmt.executeUpdate();
			if(i>0) System.out.println("회원가입 성공");
			else System.out.println("회원가입 실패");
		}catch(SQLException se) {
			System.out.println("[INSERT문 오류] "+se);
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(SQLException se) {}
		}
	}
	
	// signin
	MemberDTO signin(MemberDTO dto) {
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rs = null;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(MemberSQL.SIGN_IN);
			pstmt.setString(1,dto.getEmail());
			pstmt.setString(2,dto.getPwd());
			rs = pstmt.executeQuery();
			rs.next();
			String email = rs.getString("email");
			String name = rs.getString("name");
			String pwd = rs.getString("pwd");
			MemberDTO memberDTO = new MemberDTO(email, name, pwd);
			return memberDTO;
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
}
