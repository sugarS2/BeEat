package beeat.h_reply.model;

public class H_ReplySQL {
	static final String FIND_BY_HCODE = "SELECT hr.*, m.name FROM H_REPLY hr LEFT JOIN MEMBER m ON hr.email=m.email WHERE h_code=? ORDER BY hr_idx ASC";
	static final String INSERT = "INSERT INTO H_REPLY VALUES(HREPLY_SEQ.NEXTVAL, ?, SYSDATE, ?, ?)";
	static final String UPDATE = "UPDATE H_REPLY SET hr_content=? WHERE hr_idx=?";
	static final String DELETE ="DELETE FROM H_REPLY WHERE hr_idx=?";
}
