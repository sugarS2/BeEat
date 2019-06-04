package beeat.hotplace.model;

public class LocService {
	private LocDAO locDAO;
	private static LocService instance = new LocService();
	
	private LocService() { // �����ڸ� private���� ����
		locDAO = new LocDAO();
	}
	
	public static LocService getInstance() {
		return instance;
	}
}
