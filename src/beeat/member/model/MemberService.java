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
	
	// 회원 이메일 중복 체크
	public int validate(String email) {
		return memberDAO.validate(email);
	}
	// 회원가입 성공 시 DB에 insert
	public void signup(MemberDTO dto) {
		memberDAO.signup(dto);
	}
	public MemberDTO signin(MemberDTO dto) {
		return memberDAO.signin(dto);
	}
}
