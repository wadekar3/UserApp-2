package App2.test;

import java.io.*;
@SuppressWarnings({ "unused", "serial" })
public class AdminBean implements Serializable{

	private String uName,pWord,fName,lName,city,mId;
	private long phNo;
	public AdminBean() {}
	
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getpWord() {
		return pWord;
	}
	public void setpWord(String pWord) {
		this.pWord = pWord;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public long getPhNo() {
		return phNo;
	}
	public void setPhNo(long phNo) {
		this.phNo = phNo;
	} 
	
	
}
