package myAccount.daos;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import myAccount.pojos.Bank_book;
import myAccount.utilities.ConnectionPool;


public class Bank_bookDao{

	public void create(	Bank_book category) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "insert into bank_book (account,tran_date,amount,userid,operation) values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, category.getAccount());
			Date dt=new Date( category.getTran_date().getTime());
			ps.setDate(2, dt);
			ps.setDouble(3, category.getAmount());
			ps.setInt(4, category.getUserid());
			ps.setString(5, category.getOperation());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}
	
	public ArrayList<Bank_book> findAllDateWise(String sdate , String edate, int userid) 
	{
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Bank_book> listCategory = new ArrayList<Bank_book>();
		try {
			String sql = " select * from bank_book where  tran_date between  ?  and  ?  and userid = ? order by tran_date " ;
			PreparedStatement ps =conn.prepareStatement(sql);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date dt = df.parse(sdate);
			java.sql.Date dt1 = new java.sql.Date(dt.getTime());
			ps.setDate(1, dt1);
			java.util.Date dt2 = df.parse(edate);
			java.sql.Date dt3 = new java.sql.Date(dt2.getTime());
			ps.setDate(2, dt3);
			ps.setInt(3,userid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Bank_book category = new Bank_book();
				category.setAcid(rs.getInt("acid"));
				category.setAccount(rs.getString("account"));
				category.setTran_date(rs.getDate(3));
				category.setAmount(rs.getDouble("amount"));
				category.setUserid(rs.getInt("userid"));
				category.setOperation(rs.getString("operation"));
				listCategory.add(category);
			}
		} catch (SQLException sq) {
			System.out.println("unable to find the record." + sq);
		}
		
		 catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
			finally {
			pool.putConnection(conn);
		}
		return listCategory;
			
			
	}
	public static double closingBalance(int userid) 
	{
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		double balance=0;
		try
		{
			String sql="select (SELECT sum(amount) as total_payment FROM bank_book b where userid = ? and operation ='receive') - (SELECT sum(amount) as total_receivied FROM bank_book b where userid = ? and operation='pay') as 'Closing Balance' from dual";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.setInt(2, userid);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				balance=rs.getDouble("Closing Balance");
			}
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		return balance;
	}

	public void edit(Bank_book category) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update bank_book set acid = ?,account = ?, tran_Date = ? , amount = ? userid = ? ,operation = ?  where acid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, category.getAccount());
			Date dt=new Date( category.getTran_date().getTime());
			ps.setDate(2, dt);
			ps.setDouble(3, category.getAmount());
			ps.setInt(4, category.getUserid());
			ps.setString(5, category.getOperation());
			ps.setInt(6, category.getAcid());
			
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void remove(int acid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from bank_book where acid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, acid);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public Bank_book find(int acid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Bank_book category = new Bank_book();
		try {
			String sql = "select * from bank_book where exp_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, acid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				category.setAcid(acid);
				category.setAccount(rs.getString("account"));
				java.sql.Date dt = rs.getDate("tran_date");
				category.setTran_date(new java.util.Date(dt.getTime()));
				category.setAmount(rs.getDouble("amount"));
				category.setUserid(rs.getInt("userid"));
				category.setOperation(rs.getString("operation"));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return category;
	}

	public ArrayList<Bank_book> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Bank_book> listCategory = new ArrayList<Bank_book>();
		try {
			String sql = "select * from bank_book";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Bank_book category = new Bank_book();
				category.setAcid(rs.getInt("acid"));
				category.setAccount(rs.getString("account"));
				java.sql.Date dt = rs.getDate("tran_date");
				category.setTran_date(new java.util.Date(dt.getTime()));
				category.setAmount(rs.getDouble("amount"));
				category.setUserid(rs.getInt("userid"));
				category.setOperation(rs.getString("operation"));

				listCategory.add(category);
			}
		} catch (SQLException sq) {
			System.out.println("unable to find the record." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listCategory;
	}

	public static void main(String args[]) throws java.text.ParseException {
 
		  double balance = Bank_bookDao.closingBalance(104);
		  System.out.println(balance);
		
//		Bank_bookDao cd2 = new Bank_bookDao();
//		ArrayList<Bank_book> al = cd2.findAllDateWise("2018-03-19","2018-03-20",2);
//		for (Bank_book category : al) {
//		System.out.println(category);}

		
//		  Bank_bookDao dc = new   Bank_bookDao();
//		  java.util.Date dt= new java.util.Date();
//		  Bank_book obj = new Bank_book(102,"Jay",dt,500.2,4,"create");
//		  dc.create(obj);
		 

//		  Bank_bookDao dc1 = new   Bank_bookDao();
//		  Bank_book obj1 = new Bank_book(101," Expenses1"," Expense details1",1);
//		  dc1.edit(obj1);

		/*
		 * Bank_bookDao cd = new Bank_bookDao();
		 *  cd.remove(224);
		 */

		/*
		 * Bank_bookDao cd1 = new Bank_bookDao();
		 *  Bank_book category = new Bank_book();
		 *  cd1.find(223); 
		 *  System.out.println(category);
		 */

//		Bank_bookDao cd2 = new Bank_bookDao();
//		ArrayList<Bank_book> al = cd2.findAll();
//		for (Bank_book category : al) {
//		System.out.println(category);
//
	//	}
//		Bank_bookDao cd2 = new Bank_bookDao();
//		ArrayList<Bank_book> al = cd2.findAllDateWise("2018-03-19","2018-03-20",4);
//		for (Bank_book category : al) {
//		System.out.println(category);}

		//System.out.println(Bank_bookDao.closingBalance(4));

	}
}
