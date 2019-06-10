package beeat.board.model;

public class BoardSQL {
   static final String FIND_ALL = "SELECT b_code, b_title, c_code, b_content, b_img1, b_img2, b_img3, b_date, b_readnum, email, name FROM BOARD NATURAL JOIN MEMBER ORDER BY b_code desc";
   static final String INSERT_CONTENT = "INSERT INTO BOARD VALUES(BOARD_SEQ.nextval, ?, ?, ?, ?, ?, ?, SYSDATE, 0, ?)";
   static final String FIND_WITH_CATEGORY = "SELECT b.*, c.c_name FROM BOARD b, CATEGORY c WHERE b.b_code=? and b.c_code=c.c_code";
   static final String UPDATE_CONTENT = "UPDATE BOARD SET b_title=?, c_code=?, b_content=?, b_img1=?, b_img2=?, b_img3=?, b_date=SYSDATE WHERE b_code=?";
   static final String DELETE_CONTENT = "DELETE FROM BOARD WHERE b_code=?";
   static final String REPLY = "SELECT br_idx, br_content, br_date, br_refer, br_lev, br_order, b_code, email, name FROM B_REPLY NATURAL JOIN MEMBER WHERE b_code=? ORDER BY br_refer, br_lev, br_order";
   static final String INSERT_REPLY = "INSERT INTO B_REPLY VALUES(B_REPLY_SEQ.nextval, ?, SYSDATE, 0, 0, 0, ?, ?)";
   static final String DELETE_REPLY = "DELETE FROM B_REPLY WHERE br_idx=?";
   static final String REPLY_REPLY = "INSERT INTO B_REPLY VALUES(B_REPLY_SEQ.nextval, ?, SYSDATE, ?, ?, ?, ?, ?)";
   static final String REPLY_ORDER = "UPDATE B_REPLY SET br_order = br_order+1 WHERE br_order>? AND br_lev>0";
   static final String SELECT_REPLY = "SELECT br_content, br_date, br_refer, br_lev, br_order, b_code, email, name FROM B_REPLY NATURAL JOIN MEMBER WHERE br_idx=?";
   static final String SEARCH_BOARD =  "SELECT * " + 
                              "FROM (SELECT b.*, c.c_name, m.name" + 
                              "    FROM BOARD b" + 
                              "        LEFT JOIN CATEGORY c ON b.c_code=c.c_code" + 
                              "        LEFT JOIN MEMBER m ON b.email=m.email" + 
                              "    WHERE" + 
                              "        c.c_name like '%'||?||'%' or" + 
                              "        b.b_content like '%'||?||'%' or" + 
                              "        b.b_title like '%'||?||'%' " + 
                              "	   ORDER BY b_code DESC " +
                              "    )" + 
                              "WHERE ROWNUM<=4";
}