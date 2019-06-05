package beeat.hotplace.model;

public class HotPlaceSQL {
	static final String FIND_ALL = "SELECT * FROM HOTPLACE";
	static final String INSERT = "INSERT INTO HOTPLACE VALUES(HOTPLACE_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,?,?,?)";
	static final String FIND_BY_CODE = "SELECT h.*, l.loc_addr1, l.loc_addr2, c.c_name "
			+ "FROM HOTPLACE h "
			+ "  LEFT JOIN LOC l ON h.loc_code=l.loc_code "
			+ "  LEFT JOIN CATEGORY c ON h.c_code=c.c_code "
			+ "WHERE h.h_code=?";
}
