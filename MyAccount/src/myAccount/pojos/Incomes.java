package myAccount.pojos;

import java.util.Date;

public class Incomes {
	private int Inc_id;
	private String Inc_ac;
	private int Userid;
	private int Inc_catid;
	private double Amount;
	private Date Tran_date;
	private String Receiveby;
	private String Remark;
	public int getInc_id() {
		return Inc_id;
	}
	public void setInc_id(int inc_id) {
		Inc_id = inc_id;
	}
	public String getInc_ac() {
		return Inc_ac;
	}
	public void setInc_ac(String inc_ac) {
		Inc_ac = inc_ac;
	}
	public int getUserid() {
		return Userid;
	}
	public void setUserid(int userid) {
		Userid = userid;
	}
	public int getInc_catid() {
		return Inc_catid;
	}
	public void setInc_catid(int inc_catid) {
		Inc_catid = inc_catid;
	}
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
	public Date getTran_date() {
		return Tran_date;
	}
	public void setTran_date(Date tran_date) {
		Tran_date = tran_date;
	}
	public String getReceiveby() {
		return Receiveby;
	}
	public void setReceiveby(String receiveby) {
		Receiveby = receiveby;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	public Incomes(int inc_id, String inc_ac, int userid, int inc_catid, double amount, Date tran_date,
			String receiveby, String remark) {
		super();
		Inc_id = inc_id;
		Inc_ac = inc_ac;
		Userid = userid;
		Inc_catid = inc_catid;
		Amount = amount;
		Tran_date = tran_date;
		Receiveby = receiveby;
		Remark = remark;
	}
	public Incomes(String inc_ac, int userid, int inc_catid, double amount, Date tran_date, String receiveby,
			String remark) {
		super();
		Inc_ac = inc_ac;
		Userid = userid;
		Inc_catid = inc_catid;
		Amount = amount;
		Tran_date = tran_date;
		Receiveby = receiveby;
		Remark = remark;
	}
	public Incomes() {
		super();
	}
	@Override
	public String toString() {
		return "incomes [Inc_id=" + Inc_id + ", Inc_ac=" + Inc_ac + ", Userid=" + Userid + ", Inc_catid=" + Inc_catid
				+ ", Amount=" + Amount + ", Tran_date=" + Tran_date + ", Receiveby=" + Receiveby + ", Remark=" + Remark
				+ "]";
	}
	

}
