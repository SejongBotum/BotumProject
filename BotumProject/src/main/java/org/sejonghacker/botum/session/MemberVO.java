package org.sejonghacker.botum.session;

public class MemberVO {
	private String id;
	private String pw;
	private String name;
	private Integer is_professor;
	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getPw() {
		return pw;
	}



	public void setPw(String pw) {
		this.pw = pw;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Integer getIs_professor() {
		return is_professor;
	}



	public void setIs_professor(Integer is_professor) {
		this.is_professor = is_professor;
	}



	public MemberVO(String id, String pw, String name, Integer is_professor) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.is_professor = is_professor;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", name=" + name + ", is_professor=" + is_professor + "]";
	}
}
