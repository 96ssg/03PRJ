package co.yedam.book.vo;

import java.sql.Date;

public class BookVO {
 //VO
 private int bId;
 private String bName;
 private String bWriter;
 private String bContent;
 private Date bRegister;
 private String bCompany;
 private int bPrice;
 private String bImage;
 private String bCountry;
 
public int getbId() {
	return bId;
}
public void setbId(int bId) {
	this.bId = bId;
}
public String getbName() {
	return bName;
}
public void setbName(String bName) {
	this.bName = bName;
}
public String getbWriter() {
	return bWriter;
}
public void setbWriter(String bWriter) {
	this.bWriter = bWriter;
}
public String getbContent() {
	return bContent;
}
public void setbContent(String bContent) {
	this.bContent = bContent;
}
public Date getbRegister() {
	return bRegister;
}
public void setbRegister(Date bRegister) {
	this.bRegister = bRegister;
}
public String getbCompany() {
	return bCompany;
}
public void setbCompany(String bCompany) {
	this.bCompany = bCompany;
}
public int getbPrice() {
	return bPrice;
}
public void setbPrice(int bPrice) {
	this.bPrice = bPrice;
}
public String getbImage() {
	return bImage;
}
public void setbImage(String bImage) {
	this.bImage = bImage;
}
public String getbCountry() {
	return bCountry;
}
public void setbCountry(String bCountry) {
	this.bCountry = bCountry;
}
 
 
}
