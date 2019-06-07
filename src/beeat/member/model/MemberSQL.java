package beeat.member.model;

public class MemberSQL {
	static final String FIND_BY_EMAIL = "SELECT COUNT(*) FROM MEMBER WHERE email=?";
	static final String SIGN_UP = "INSERT INTO MEMBER VALUES(?,?,?)";
	static final String SIGN_IN = "SELECT * FROM MEMBER WHERE email=? AND pwd=?";
}
