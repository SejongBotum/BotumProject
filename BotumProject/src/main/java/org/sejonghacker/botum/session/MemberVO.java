package org.sejonghacker.botum.session;

public class MemberVO {
	private String member_id;
	private String member_pwd;
	private String member_name;
	private Integer is_professor;
	
	public MemberVO() {
		super();
	}
	public MemberVO(String member_id, String member_pwd, String member_name, Integer is_professor) {
		super();
		this.member_id = member_id;
		this.member_pwd = member_pwd;
		this.member_name = member_name;
		this.is_professor = is_professor;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_pwd() {
		return member_pwd;
	}
	public void setMember_pwd(String member_pwd) {
		this.member_pwd = member_pwd;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public Integer getIs_professor() {
		return is_professor;
	}
	public void setIs_professor(Integer is_professor) {
		this.is_professor = is_professor;
	}
	@Override
	public String toString() {
		return "MemberVO [member_id=" + member_id + ", member_pwd=" + member_pwd + ", member_name=" + member_name
				+ ", is_professor=" + is_professor + "]";
	}
	
}
