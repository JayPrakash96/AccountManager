package myAccount.pojos;
import java.util.*;

public class Bank_book {
	private int Acid;
	private String Account;
	private Date Tran_date;
	private double Amount;
	private int Userid;
	private String Operation;
	public int getAcid() {
		return Acid;
	}
	public void setAcid(int acid) {
		Acid = acid;
	}
	public String getAccount() {
		return Account;
	}
	public void setAccount(String account) {
		Account = account;
	}
	public Date getTran_date() {
		return Tran_date;
	}
	public void setTran_date(Date tran_date) {
		Tran_date = tran_date;
	}
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
	public int getUserid() {
		return Userid;
	}
	public void setUserid(int userid) {
		Userid = userid;
	}
	public String getOperation() {
		return Operation;
	}
	public void setOperation(String operation) {
		Operation = operation;
	}
	public Bank_book(int acid, String account, Date tran_date, double amount, int userid, String operation) {
		super();
		Acid = acid;
		Account = account;
		Tran_date = tran_date;
		Amount = amount;
		Userid = userid;
		Operation = operation;
	}
	public Bank_book(String account, Date tran_date, double amount, int userid, String operation) {
		super();
		Account = account;
		Tran_date = tran_date;
		Amount = amount;
		Userid = userid;
		Operation = operation;
	}
	public Bank_book() {
		super();
	}
	@Override
	public String toString() {
		return "bank_book [Acid=" + Acid + ", Account=" + Account + ", Tran_date=" + Tran_date + ", Amount=" + Amount
				+ ", Userid=" + Userid + ", Operation=" + Operation + "]";
	}
	

}
