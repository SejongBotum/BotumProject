package org.sejonghacker.botum.Crawling;

public class Lecture {
	private Integer lect_id;
	private String member_id;
	private String lect_name;
	private String dir_name;
	public Lecture() {
		super();
	}
	public Lecture(Integer lect_id, String member_id, String lect_name, String dir_name) {
		super();
		this.lect_id = lect_id;
		this.member_id = member_id;
		this.lect_name = lect_name;
		this.dir_name = dir_name;
	}
	public Integer getLect_id() {
		return lect_id;
	}
	public void setLect_id(Integer lect_id) {
		this.lect_id = lect_id;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getLect_name() {
		return lect_name;
	}
	public void setLect_name(String lect_name) {
		this.lect_name = lect_name;
	}
	public String getDir_name() {
		return dir_name;
	}
	public void setDir_name(String dir_name) {
		this.dir_name = dir_name;
	}
	@Override
	public String toString() {
		return "Lecture [lect_id=" + lect_id + ", member_id=" + member_id + ", lect_name=" + lect_name + ", dir_name="
				+ dir_name + "]";
	}
	
}
