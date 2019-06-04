package beeat.hotplace.model;

import java.util.ArrayList;

public class LocService {
	private LocDAO locDAO;
	private static LocService instance = new LocService();
	
	private LocService() { // �����ڸ� private���� ����
		locDAO = new LocDAO();
	}
	public static LocService getInstance() {
		return instance;
	}
	
	// findAll
	public ArrayList<LocDTO> findAll(){
		return locDAO.findAll();
	}
}
