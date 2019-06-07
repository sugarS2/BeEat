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
	// insert 
	public void insert(HotPlaceDTO dto) {
		hotplaceDAO.insert(dto);
	}
	// findByCode
	public HotPlaceDTO findByCode(int h_code) {
		return hotplaceDAO.findByCode(h_code);
	}
	// update
	public void update(HotPlaceDTO dto) {
		hotplaceDAO.update(dto);
	}
	// delete 
	public void delete(int h_code) {
		hotplaceDAO.delete(h_code);
	}
	
	
	// findByCategory
	public ArrayList<HotPlaceDTO> findByCategory(int c_code) {
		return hotplaceDAO.findByCategory(c_code);
	}
	// findByOptions
	public ArrayList<HotPlaceDTO> findByOptions(String order, int c_code) {
		return hotplaceDAO.findByOptions(order, c_code);
	}
	
	// updateReadNum
	public void updateReadNum(int h_code) {
		hotplaceDAO.updateReadNum(h_code);
	}
}
