package myAccount.pojos;

public class Expenses_category {

	private int Exp_catid;
	private String Exp_catname;
	private String Exp_catdetails;
	private int Userid;
	public int getExp_catid() {
		return Exp_catid;
	}
	public void setExp_catid(int exp_catid) {
		Exp_catid = exp_catid;
	}
	public String getExp_catname() {
		return Exp_catname;
	}
	public void setExp_catname(String exp_catname) {
		Exp_catname = exp_catname;
	}
	public String getExp_catdetails() {
		return Exp_catdetails;
	}
	public void setExp_catdetails(String exp_catdetails) {
		Exp_catdetails = exp_catdetails;
	}
	public int getUserid() {
		return Userid;
	}
	public void setUserid(int userid) {
		Userid = userid;
	}
	public Expenses_category(int exp_catid, String exp_catname, String exp_catdetails, int userid) {
		super();
		Exp_catid = exp_catid;
		Exp_catname = exp_catname;
		Exp_catdetails = exp_catdetails;
		Userid = userid;
	}
	public Expenses_category(String exp_catname, String exp_catdetails, int userid) {
		super();
		Exp_catname = exp_catname;
		Exp_catdetails = exp_catdetails;
		Userid = userid;
	}
	public Expenses_category() {
		super();
	}
	@Override
	public String toString() {
		return "expenses_category [Exp_catid=" + Exp_catid + ", Exp_catname=" + Exp_catname + ", Exp_catdetails="
				+ Exp_catdetails + ", Userid=" + Userid + "]";
	}
	
}
