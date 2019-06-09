package beeat.board.model;

import java.util.ArrayList;

public class CategoryService {
	private CategoryDAO categoryDAO;
	private static CategoryService instance = new CategoryService();
	
	private CategoryService() { // 생성자를 private으로 감춤
		categoryDAO = new CategoryDAO();
	}
	
	public static CategoryService getInstance() {
		return instance;
	}
	
	// findAll
	public ArrayList<CategoryDTO> findAll() {
		return categoryDAO.findAll();
	}
}
