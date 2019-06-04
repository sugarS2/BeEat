package beeat.hotplace.model;

import java.util.ArrayList;

public class HotPlaceService {
	private HotPlaceDAO hotplaceDAO;
	private static HotPlaceService instance = new HotPlaceService();
	
	private HotPlaceService() { // 생성자를 private으로 감춤
		hotplaceDAO = new HotPlaceDAO();
	}
	public static HotPlaceService getInstance() {
		return instance;
	}
	
	// findAll
	public ArrayList<HotPlaceDTO> findAll() {
		return hotplaceDAO.findAll();
	}
}
