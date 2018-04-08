package myAccount.pojos;

public class Income_category {
	private int Inc_catid;
	private String Inc_catname;
	private String Inc_catdetails;
	private int Userid;
	public int getInc_catid() {
		return Inc_catid;
	}
	public void setInc_catid(int inc_catid) {
		Inc_catid = inc_catid;
	}
	public String getInc_catname() {
		return Inc_catname;
	}
	public void setInc_catname(String inc_catname) {
		Inc_catname = inc_catname;
	}
	public String getInc_catdetails() {
		return Inc_catdetails;
	}
	public void setInc_catdetails(String inc_catdetails) {
		Inc_catdetails = inc_catdetails;
	}
	public int getUserid() {
		return Userid;
	}
	public void setUserid(int userid) {
		Userid = userid;
	}
	public Income_category(int inc_catid, String inc_catname, String inc_catdetails, int userid) {
		super();
		Inc_catid = inc_catid;
		Inc_catname = inc_catname;
		Inc_catdetails = inc_catdetails;
		Userid = userid;
	}
	public Income_category(String inc_catname, String inc_catdetails, int userid) {
		super();
		Inc_catname = inc_catname;
		Inc_catdetails = inc_catdetails;
		Userid = userid;
	}
	public Income_category() {
		super();
	}
	@Override
	public String toString() {
		return "Income_category [Inc_catid=" + Inc_catid + ", Inc_catname=" + Inc_catname + ", Inc_catdetails="
				+ Inc_catdetails + ", Userid=" + Userid + "]";
	}
	
}
