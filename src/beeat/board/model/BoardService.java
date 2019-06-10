package beeat.board.model;

import java.util.ArrayList;

public class BoardService {
	private BoardDAO dao;
	private static BoardService instance = new BoardService();
	private BoardService() {
		dao = new BoardDAO();
	}
	public static BoardService getInstance() {
		return instance;
	}
	public ArrayList<BoardDTO> list(){
		return dao.list();
	}
	public void insert(BoardDTO dto) {
		dao.insert(dto);
	}
	public BoardDTO content(int b_code) {
		return dao.content(b_code);
	}
	public ArrayList<B_ReplyDTO> reply(int b_code){
		return dao.reply(b_code);
	}
	public void update(BoardDTO dto) {
		dao.update(dto);
	}
	public void delete(int b_code) {
		dao.delete(b_code);
	}
	public void insertRe(B_ReplyDTO dto) {
		dao.insertRe(dto);
	}
	public void deleteRe(int br_idx) {
		dao.deleteRe(br_idx);
	}
	public void insertReRe(B_ReplyDTO dto) {
		dao.insertReRe(dto);
	}
	public void updateRe(int br_order) {
		dao.updateRe(br_order);
	}
	public B_ReplyDTO reContent(int br_idx) {
		return dao.reContent(br_idx);
	}
	public ArrayList<BoardDTO> search(String keyword) {
        return dao.search(keyword);
    }
}
