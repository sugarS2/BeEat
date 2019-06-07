package beeat.member.model;

public class MemberService {
	private MemberDAO memberDAO;
	private static MemberService instance = new MemberService();
	private MemberService() {
		memberDAO = new MemberDAO();
	}
	public static MemberService getInstance() {
		return instance;
	}
	
	// ȸ�� �̸��� �ߺ� üũ
	public int validate(String email) {
		return memberDAO.validate(email);
	}
	// ȸ������ ���� �� DB�� insert
	public void signup(MemberDTO dto) {
		memberDAO.signup(dto);
	}
	public MemberDTO signin(MemberDTO dto) {
		return memberDAO.signin(dto);
	}
}
