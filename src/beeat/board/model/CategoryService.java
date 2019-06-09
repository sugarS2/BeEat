package beeat.board.model;

import java.util.ArrayList;

public class CategoryService {
	private CategoryDAO categoryDAO;
	private static CategoryService instance = new CategoryService();
	
	private CategoryService() { // �����ڸ� private���� ����
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
