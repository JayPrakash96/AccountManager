package myAccount.pojos;

import java.util.Date;

public class Expenses {
	
	private int Exp_id;
	private String Exp_ac;
	private int Userid;
	private int Exp_catid;
	private double Amount;
	private Date Tran_date;
	private String Payby;
	private String Remark;
	public int getExp_id() {
		return Exp_id;
	}
	public void setExp_id(int exp_id) {
		Exp_id = exp_id;
	}
	public String getExp_ac() {
		return Exp_ac;
	}
	public void setExp_ac(String exp_ac) {
		Exp_ac = exp_ac;
	}
	public int getUserid() {
		return Userid;
	}
	public void setUserid(int userid) {
		Userid = userid;
	}
	public int getExp_catid() {
		return Exp_catid;
	}
	public void setExp_catid(int exp_catid) {
		Exp_catid = exp_catid;
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
	public String getPayby() {
		return Payby;
	}
	public void setPayby(String payby) {
		Payby = payby;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	public Expenses(int exp_id, String exp_ac, int userid, int exp_catid, double amount, Date tran_date, String payby,
			String remark) {
		super();
		Exp_id = exp_id;
		Exp_ac = exp_ac;
		Userid = userid;
		Exp_catid = exp_catid;
		Amount = amount;
		Tran_date = tran_date;
		Payby = payby;
		Remark = remark;
	}
	public Expenses(String exp_ac, int userid, int exp_catid, double amount, Date tran_date, String payby,
			String remark) {
		super();
		Exp_ac = exp_ac;
		Userid = userid;
		Exp_catid = exp_catid;
		Amount = amount;
		Tran_date = tran_date;
		Payby = payby;
		Remark = remark;
	}
	public Expenses() {
		super();
	}
	@Override
	public String toString() {
		return "expenses [Exp_id=" + Exp_id + ", Exp_ac=" + Exp_ac + ", Userid=" + Userid + ", Exp_catid=" + Exp_catid
				+ ", Amount=" + Amount + ", Tran_date=" + Tran_date + ", Payby=" + Payby + ", Remark=" + Remark + "]";
	}
	

}
