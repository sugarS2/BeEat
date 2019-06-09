package beeat.board.model;

public class CategoryDTO {
	private int c_code;
	private String c_name;
	
	
	public CategoryDTO() {}
	public CategoryDTO(int c_code, String c_name) {
		super();
		this.c_code = c_code;
		this.c_name = c_name;
	}
	
	
	public int getC_code() {
		return c_code;
	}
	public void setC_code(int c_code) {
		this.c_code = c_code;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	
}
