package beeat.loc.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

class LocDAO {
	private DataSource ds;
	
	LocDAO(){
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/myoracle");
		}catch(NamingException ne) {
		}
	}
	
	
	// findAll
	ArrayList<LocDTO> findAll() {
		ArrayList<LocDTO> list = new ArrayList<LocDTO>();
		Connection conn = null; Statement stmt = null; ResultSet rs = null;
		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(LocSQL.FIND_ALL);
			while(rs.next()) {
				int loc_code = rs.getInt(1);
				String loc_addr1 = rs.getString(2);
				String loc_addr2 = rs.getString(3);
				LocDTO dto = new LocDTO(loc_code, loc_addr1, loc_addr2);
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
