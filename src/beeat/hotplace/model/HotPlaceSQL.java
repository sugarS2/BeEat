package beeat.hotplace.model;

public class HotPlaceSQL {
	static final String FIND_ALL = "SELECT * FROM HOTPLACE";
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
}
