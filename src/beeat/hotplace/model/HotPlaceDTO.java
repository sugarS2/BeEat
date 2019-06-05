package beeat.hotplace.model;

import java.util.Date;

public class HotPlaceDTO {
	private int h_code;
	private String h_name;
	private int c_code; // 외래키
	private int loc_code; // 외래키
	private String h_address;
	private String h_info;
	private String h_tel;
	private String h_time;
	private String h_menu;
	private String h_img1;
	private String h_img2;
	private String h_img3;
	private Date h_date;
	private int h_readnum;
	private float h_grade;
	private String email; // 외래키
	
	//loc table
	private String loc_addr1;
	private String loc_addr2;
	//category table
	private String c_name;
	
	public HotPlaceDTO() {}
	public HotPlaceDTO(int h_code, String h_name, int c_code, int loc_code, String h_address, String h_info,
			String h_tel, String h_time, String h_menu, String h_img1, String h_img2, String h_img3, Date h_date, int h_readnum,
			float h_grade, String email) {
		super();
		this.h_code = h_code;
		this.h_name = h_name;
		this.c_code = c_code;
		this.loc_code = loc_code;
		this.h_address = h_address;
		this.h_info = h_info;
		this.h_tel = h_tel;
		this.h_time = h_time;
		this.h_menu = h_menu;
		this.h_img1 = h_img1;
		this.h_img2 = h_img2;
		this.h_img3 = h_img3;
		this.h_date = h_date;
		this.h_readnum = h_readnum;
		this.h_grade = h_grade;
		this.email = email;
	}
	// LOC테이블과 CATEGORY테이블의 컬럼명들도 포함된 생성자
	public HotPlaceDTO(int h_code, String h_name, int c_code, int loc_code, String h_address, String h_info,
			String h_tel, String h_time, String h_menu, String h_img1, String h_img2, String h_img3, Date h_date, int h_readnum,
			float h_grade, String email, String loc_addr1, String loc_addr2, String c_name) {
		super();
		this.h_code = h_code;
		this.h_name = h_name;
		this.c_code = c_code;
		this.loc_code = loc_code;
		this.h_address = h_address;
		this.h_info = h_info;
		this.h_tel = h_tel;
		this.h_time = h_time;
		this.h_menu = h_menu;
		this.h_img1 = h_img1;
		this.h_img2 = h_img2;
		this.h_img3 = h_img3;
		this.h_date = h_date;
		this.h_readnum = h_readnum;
		this.h_grade = h_grade;
		this.email = email;
		this.loc_addr1 = loc_addr1;
		this.loc_addr2 = loc_addr2;
		this.c_name = c_name;
	}
	
	
	public int getH_code() {
		return h_code;
	}
	public void setH_code(int h_code) {
		this.h_code = h_code;
	}
	public String getH_name() {
		return h_name;
	}
	public void setH_name(String h_name) {
		this.h_name = h_name;
	}
	public int getC_code() {
		return c_code;
	}
	public void setC_code(int c_code) {
		this.c_code = c_code;
	}
	public int getLoc_code() {
		return loc_code;
	}
	public void setLoc_code(int loc_code) {
		this.loc_code = loc_code;
	}
	public String getH_address() {
		return h_address;
	}
	public void setH_address(String h_address) {
		this.h_address = h_address;
	}
	public String getH_info() {
		return h_info;
	}
	public void setH_info(String h_info) {
		this.h_info = h_info;
	}
	public String getH_tel() {
		return h_tel;
	}
	public void setH_tel(String h_tel) {
		this.h_tel = h_tel;
	}
	public String getH_time() {
		return h_time;
	}
	public void setH_time(String h_time) {
		this.h_time = h_time;
	}
	public String getH_menu() {
		return h_menu;
	}
	public void setH_menu(String h_menu) {
		this.h_menu = h_menu;
	}
	public String getH_img1() {
		return h_img1;
	}
	public void setH_img1(String h_img1) {
		this.h_img1 = h_img1;
	}
	public String getH_img2() {
		return h_img2;
	}
	public void setH_img2(String h_img2) {
		this.h_img2 = h_img2;
	}
	public String getH_img3() {
		return h_img3;
	}
	public void setH_img3(String h_img3) {
		this.h_img3 = h_img3;
	}
	public Date getH_date() {
		return h_date;
	}
	public void setH_date(Date h_date) {
		this.h_date = h_date;
	}
	public int getH_readnum() {
		return h_readnum;
	}
	public void setH_readnum(int h_readnum) {
		this.h_readnum = h_readnum;
	}
	public float getH_grade() {
		return h_grade;
	}
	public void setH_grade(float h_grade) {
		this.h_grade = h_grade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
}
