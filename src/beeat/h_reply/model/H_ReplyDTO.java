package beeat.h_reply.model;

import java.util.*;

public class H_ReplyDTO {
	private int hr_idx;
	private String hr_content;
	private Date hr_date;
	private int h_code;
	private String email;
	private String name;
	
	
	public H_ReplyDTO(){}
	public H_ReplyDTO(int hr_idx, String hr_content, Date hr_date, int h_code, String email, String name) {
		super();
		this.hr_idx = hr_idx;
		this.hr_content = hr_content;
		this.hr_date = hr_date;
		this.h_code = h_code;
		this.email = email;
		this.name = name;
	}
	
	
	public int getHr_idx() {
		return hr_idx;
	}
	public void setHr_idx(int hr_idx) {
		this.hr_idx = hr_idx;
	}
	public String getHr_content() {
		return hr_content;
	}
	public void setHr_content(String hr_content) {
		this.hr_content = hr_content;
	}
	public Date getHr_date() {
		return hr_date;
	}
	public void setHr_date(Date hr_date) {
		this.hr_date = hr_date;
	}
	public int getH_code() {
		return h_code;
	}
	public void setH_code(int h_code) {
		this.h_code = h_code;
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
	public void setName(String name) {
		this.name = name;
	}
}
