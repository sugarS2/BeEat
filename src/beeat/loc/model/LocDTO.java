package beeat.loc.model;

public class LocDTO {
	private int loc_code;
	private String loc_addr1;
	private String loc_addr2;
	
	
	public LocDTO() {}
	public LocDTO(int loc_code, String loc_addr1, String loc_addr2) {
		super();
		this.loc_code = loc_code;
		this.loc_addr1 = loc_addr1;
		this.loc_addr2 = loc_addr2;
	}
	
	
	public int getLoc_code() {
		return loc_code;
	}
	public void setLoc_code(int loc_code) {
		this.loc_code = loc_code;
	}
	public String getLoc_addr1() {
		return loc_addr1;
	}
	public void setLoc_addr1(String loc_addr1) {
		this.loc_addr1 = loc_addr1;
	}
	public String getLoc_addr2() {
		return loc_addr2;
	}
	public void setLoc_addr2(String loc_addr2) {
		this.loc_addr2 = loc_addr2;
	}
}
