package beeat.category.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

class CategoryDAO {
	private DataSource ds;
	
	CategoryDAO(){
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne) {
		}
	}
	
	
	// findAll
	ArrayList<CategoryDTO> findAll() {
		ArrayList<CategoryDTO> list = new ArrayList<CategoryDTO>();
		Connection conn = null; Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(CategorySQL.FIND_ALL);
			while(rs.next()) {
				int c_code = rs.getInt(1);
				String c_name = rs.getString(2);
				CategoryDTO dto = new CategoryDTO(c_code, c_name);
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
