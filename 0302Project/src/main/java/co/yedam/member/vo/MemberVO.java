package co.yedam.member.vo;

public class MemberVO {
	
	//VO
	private String uId;
	private String uPassword;
	private String uName;
	private int uTel;
	private String uAddress;
	private String uBirth;
	
	
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getuPassword() {
		return uPassword;
	}
	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public int getuTel() {
		return uTel;
	}
	public void setuTel(int uTel) {
		this.uTel = uTel;
	}
	public String getuAddress() {
		return uAddress;
	}
	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}
	public String getuBirth() {
		return uBirth;
	}
	public void setuBirth(String uBirth) {
		this.uBirth = uBirth;
	}
	
	
}
