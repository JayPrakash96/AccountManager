package myAccount.daos;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import myAccount.pojos.Cash_book;
import myAccount.utilities.ConnectionPool;


public class Cash_bookDao{

	public void create(	Cash_book category) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "insert into cash_book (account,tran_date,amount,userid,operation) values(?,?,?,?,?)";
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

	public void edit(Cash_book category) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update cash_book set acid = ?,account = ?, tran_Date = ? , amount = ? userid = ? ,operation = ?  where acid = ?";
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
			String sql = "delete from cash_book where acid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, acid);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public ArrayList<Cash_book> findAllDateWise(String sdate , String edate, int userid) 
	{
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Cash_book> listCategory = new ArrayList<Cash_book>();
		try {
			String sql = " select * from cash_book where  tran_date between  ?  and  ?  and userid = ? order by tran_date" ;
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
				Cash_book category = new Cash_book();
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
			String sql="select (SELECT sum(amount) as total_payment FROM cash_book b where userid = ? and operation ='receive') - (SELECT sum(amount) as total_receivied FROM cash_book b where userid = ? and operation='pay') as 'Closing Balance' from dual";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.setInt(2, userid);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				balance=rs.getDouble("Closing Balance");
			}
			System.out.println(balance);
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		return balance;
	}
	
	public Cash_book find(int acid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Cash_book category = new Cash_book();
		try {
			String sql = "select * from cash_book where exp_id = ?";
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

	public ArrayList<Cash_book> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Cash_book> listCategory = new ArrayList<Cash_book>();
		try {
			String sql = "select * from bank_book";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cash_book category = new Cash_book();
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

	public static void main(String args[]) {

		  double balance =Cash_bookDao.closingBalance(104);
		  System.out.println(balance);
		
//		Cash_bookDao cd2 = new Cash_bookDao();
//		ArrayList<Cash_book> al = cd2.findAllDateWise("2018-03-25","2018-03-25",104);
//		for (Cash_book category : al) {
//		System.out.println(category);}
		
		
//		  Cash_bookDao dc = new   Cash_bookDao();
//		  Cash_book obj = new Cash_book(102,"Direct Expenses"," Direct expense details",1);
//		  dc.create(obj);
		 

//		  Cash_bookDao dc1 = new   Cash_bookDao();
//		  Cash_book obj1 = new Cash_book(101," Expenses1"," Expense details1",1);
//		  dc1.edit(obj1);

		/*
		 * Cash_book cd = new Cash_bookDao();
		 *  cd.remove(224);
		 */

		/*
		 * Cash_bookDao cd1 = new Cash_bookDao();
		 *  Cash_book category = new Cash_book();
		 *  cd1.find(223); 
		 *  System.out.println(category);
		 */

//		Cash_bookDao cd2 = new Cash_bookDao();
//		ArrayList<Cash_book> al = cd2.findAll();
//		for (Cash_book category : al) {
//		System.out.println(category);
//
	//	}

	}
}
