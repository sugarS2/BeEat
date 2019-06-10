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
	// findByTop3ByReadNum : 조회수 기준으로 가장 높은 조회수를 가진 hotplace list를 뽑는 기능
	public ArrayList<HotPlaceDTO> findTop3ByReadNum(){
		return hotplaceDAO.findTop3ByReadNum();
	}
	
	// findBySearchText(String searchText)
	public ArrayList<HotPlaceDTO> findBySearchText(String searchText){
		return hotplaceDAO.findBySearchText(searchText);
	}
	
	// findBySearchText(String searchText, int num)
	public ArrayList<HotPlaceDTO> findBySearchText(String searchText, int num){
		return hotplaceDAO.findBySearchText(searchText, num);
	}
	
	public int countBySearchText(String searchText) {
		return hotplaceDAO.countBySearchText(searchText);
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
