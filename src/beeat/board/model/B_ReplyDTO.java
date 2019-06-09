package beeat.board.model;

import java.sql.Date;

public class B_ReplyDTO {
	private int br_idx;
	private String br_content;
	private Date br_date;
	private int br_refer;
	private int br_lev;
	private int br_order;
	private int b_code;
	private String email;
	private String name;
	
	B_ReplyDTO(){}

	public B_ReplyDTO(int br_idx, String br_content, Date br_date, int br_refer, int br_lev, int br_order, int b_code,
			String email) {
		super();
		this.br_idx = br_idx;
		this.br_content = br_content;
		this.br_date = br_date;
		this.br_refer = br_refer;
		this.br_lev = br_lev;
		this.br_order = br_order;
		this.b_code = b_code;
		this.email = email;
	}
	
	public B_ReplyDTO(int br_idx, String br_content, Date br_date, int br_refer, int br_lev, int br_order, int b_code,
			String email, String name) {
		super();
		this.br_idx = br_idx;
		this.br_content = br_content;
		this.br_date = br_date;
		this.br_refer = br_refer;
		this.br_lev = br_lev;
		this.br_order = br_order;
		this.b_code = b_code;
		this.email = email;
		this.name = name;
	}

	public int getBr_idx() {
		return br_idx;
	}

	public void setBr_idx(int br_idx) {
		this.br_idx = br_idx;
	}

	public String getBr_content() {
		return br_content;
	}

	public void setBr_content(String br_content) {
		this.br_content = br_content;
	}

	public Date getBr_date() {
		return br_date;
	}

	public void setBr_date(Date br_date) {
		this.br_date = br_date;
	}

	public int getBr_refer() {
		return br_refer;
	}

	public void setBr_refer(int br_refer) {
		this.br_refer = br_refer;
	}

	public int getBr_lev() {
		return br_lev;
	}

	public void setBr_lev(int br_lev) {
		this.br_lev = br_lev;
	}

	public int getBr_order() {
		return br_order;
	}

	public void setBr_order(int br_order) {
		this.br_order = br_order;
	}

	public int getB_code() {
		return b_code;
	}

	public void setB_code(int b_code) {
		this.b_code = b_code;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String Name) {
		this.name = name;
	}
}
