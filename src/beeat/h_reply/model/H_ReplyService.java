package beeat.h_reply.model;

import java.util.ArrayList;

public class H_ReplyService {
	private H_ReplyDAO h_replyDAO;
	private static H_ReplyService instance = new H_ReplyService();
	
	private H_ReplyService() { // 생성자를 private으로 감춤
		h_replyDAO = new H_ReplyDAO();
	}
	public static H_ReplyService getInstance() {
		return instance;
	}

	// findAll
	public ArrayList<H_ReplyDTO> findByHCODE(int h_code){
		return h_replyDAO.findByHCODE(h_code);
	}
	// insert
	public void insert(H_ReplyDTO dto) {
		h_replyDAO.insert(dto);
	}
	// update
	public void update(H_ReplyDTO dto) {
		h_replyDAO.update(dto);
	}
	// delete
	public void delete(int hr_idx) {
		h_replyDAO.delete(hr_idx);
	}
}
