package beeat.hotplace.model;

public class HotPlaceSQL {
	static final String FIND_ALL = "SELECT * FROM HOTPLACE";
	static final String FIND_TOP3_BY_READNUM = "SELECT * FROM (SELECT * FROM HOTPLACE ORDER BY h_readnum desc) WHERE ROWNUM<=3";
	static final String INSERT = "INSERT INTO HOTPLACE VALUES(HOTPLACE_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?)";
	static final String FIND_BY_CODE = "SELECT h.*, l.loc_addr1, l.loc_addr2, c.c_name, m.name "
									+ "FROM HOTPLACE h "
									+ "  LEFT JOIN MEMBER m ON h.email=m.email "
									+ "  LEFT JOIN LOC l ON h.loc_code=l.loc_code "
									+ "  LEFT JOIN CATEGORY c ON h.c_code=c.c_code "
									+ "WHERE h.h_code=?";
	static final String UPDATE = "UPDATE HOTPLACE SET h_name=?, c_code=?, loc_code=?, h_address=?, h_info=?, "
								+ "  h_tel=?, h_time=?, h_menu=?, h_img1=?, h_img2=?, h_img3=?, h_date=SYSDATE, h_grade=? "
								+ "WHERE h_code=?";
	static final String DELETE = "DELETE FROM HOTPLACE WHERE h_code=?";
	
	static final String UPDATE_READNUM = "UPDATE HOTPLACE SET h_readnum=h_readnum+1 WHERE h_code=?";
	
	static final String FIND_BY_CATEGORY = "SELECT * FROM HOTPLACE WHERE c_code=?";
	
	// order와 c_code에 따른 조회
	static final String FIND_BY_OPTION1 = "SELECT * FROM HOTPLACE WHERE c_code=? ORDER BY h_code desc"; 
	static final String FIND_BY_OPTION2 = "SELECT * FROM HOTPLACE WHERE c_code=? ORDER BY h_readnum desc";
	static final String FIND_BY_OPTION3 = "SELECT * FROM HOTPLACE WHERE c_code=? ORDER BY h_grade desc";
	
	// order에 따른 조회
	static final String FINDALL_BY_OPTION1 = "SELECT * FROM HOTPLACE ORDER BY h_code desc"; 
	static final String FINDALL_BY_OPTION2 = "SELECT * FROM HOTPLACE ORDER BY h_readnum desc";
	static final String FINDALL_BY_OPTION3 = "SELECT * FROM HOTPLACE ORDER BY h_grade desc";
}
