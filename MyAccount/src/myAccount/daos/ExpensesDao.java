package myAccount.daos;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import myAccount.pojos.Expenses;
import myAccount.utilities.ConnectionPool;


public class ExpensesDao{

	public void create(	Expenses category) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "insert into expenses (exp_ac,userid,exp_catid,amount,tran_date,payby,remark) values(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, category.getExp_ac());
			ps.setInt(2, category.getUserid());
			ps.setInt(3, category.getExp_catid());
			ps.setDouble(4, category.getAmount());
			Date dt=new Date( category.getTran_date().getTime());
			ps.setDate(5, dt);
			ps.setString(6,category.getPayby());
			ps.setString(7,category.getRemark());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void edit(Expenses category) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update expenses set exp_ac = ?,userid = ?, exp_catid= ? ,amount = ? ,tran_date = ? ,payby = ? , remark = ? where exp_catid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, category.getExp_ac());
			ps.setInt(2, category.getUserid());
			ps.setInt(3, category.getExp_catid());
			ps.setDouble(4, category.getAmount());
			Date dt=new Date( category.getTran_date().getTime());
			ps.setDate(5, dt);
			ps.setString(6,category.getPayby());
			ps.setString(7,category.getRemark());
			ps.setInt(8, category.getExp_id());
			
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void remove(int exp_id) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from expenses where exp_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, exp_id);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public Expenses find(int exp_id) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Expenses category = new Expenses();
		try {
			String sql = "select * from expenses where exp_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, exp_id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				category.setExp_id(exp_id);
				category.setExp_ac(rs.getString("exp_ac"));
				category.setUserid(rs.getInt("userid"));
				category.setExp_catid(rs.getInt("exp_catid"));
				category.setAmount(rs.getDouble("amount"));
				java.sql.Date dt = rs.getDate("tran_date");
				category.setTran_date(new java.util.Date(dt.getTime()));
				category.setPayby(rs.getString("payby"));
				category.setRemark(rs.getString("remark"));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return category;
	}

	public ArrayList<Expenses> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Expenses> listCategory = new ArrayList<Expenses>();
		try {
			String sql = "select * from expenses";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Expenses category = new Expenses();
				category.setExp_id(rs.getInt("exp_id"));
				category.setExp_ac(rs.getString("exp_ac"));
				category.setUserid(rs.getInt("userid"));
				category.setExp_catid(rs.getInt("exp_catid"));
				category.setAmount(rs.getDouble("Amount"));
				java.sql.Date dt = rs.getDate("tran_date");
				category.setTran_date(new java.util.Date(dt.getTime()));
				category.setPayby(rs.getString("payby"));
				category.setRemark(rs.getString("remark"));
				listCategory.add(category);
			}
		} catch (SQLException sq) {
			System.out.println("unable to find the record." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listCategory;
	}
	public ArrayList<Expenses> findAll(int userid) {
	ConnectionPool pool = ConnectionPool.getInstance();
	pool.initialize();
	Connection conn = pool.getConnection();
	ArrayList<Expenses> listCategory = new ArrayList<Expenses>();
	try {
		String sql = "select * from expenses where userid =?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,userid);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Expenses category = new Expenses();
			category.setExp_id(rs.getInt("exp_id"));
	        category.setExp_ac(rs.getString("exp_ac"));
	        category.setUserid(rs.getInt("userid"));
	        category.setExp_catid(rs.getInt("exp_catid"));
	        category.setAmount(rs.getDouble("Amount"));
	        java.sql.Date dt = rs.getDate("tran_date");
	        category.setTran_date(new java.util.Date(dt.getTime()));
	        category.setPayby(rs.getString("payby"));
	        category.setRemark(rs.getString("remark"));
	        listCategory.add(category);
		}
	} catch (SQLException sq) {
		System.out.println("unable to find the record." + sq);
	} finally {
		pool.putConnection(conn);
	}
	return listCategory;
}
	
	
	
	
	
	
	public ArrayList<Expenses> findAllDateWise(String sdate , String edate, int userid)
	{
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		
		ArrayList<Expenses> listCategory = new ArrayList<Expenses>();
		try {
			String sql = " select * from expenses where  tran_date between  ? and  ? and userid = ? order by tran_date " ;
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
				Expenses category = new Expenses();
				category.setExp_id(rs.getInt("exp_id"));
	            category.setExp_ac(rs.getString("exp_ac"));
	            category.setUserid(rs.getInt("userid"));
	category.setExp_catid(rs.getInt("exp_catid"));
	category.setAmount(rs.getDouble("Amount"));
	category.setTran_date(rs.getDate("tran_date"));
	category.setPayby(rs.getString("payby"));
	category.setRemark(rs.getString("remark"));
	listCategory.add(category);
			}
		} catch (SQLException sq) {
			System.out.println("unable to find the record." + sq);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pool.putConnection(conn);
		}
		return listCategory;
			
			
	}

	public static void main(String args[]) {
		
		ExpensesDao cd2 = new ExpensesDao();
		ArrayList<Expenses> al = cd2.findAllDateWise("2018-03-19","2018-03-21",2);
		for (Expenses category : al) {
		System.out.println(category);}
		

//		java.util.Date date=new java.util.Date();
//          ExpensesDao dc = new   ExpensesDao();
//		  Expenses obj = new Expenses("exp_ac",1, 1, 20,date, "payby",
//	      			"remark");
//		  dc.create(obj);
		 

//		  ExpensesDao dc1 = new   ExpensesDao();
//		  Expenses obj1 = new Expenses(101," Expenses1"," Expense details1",1);
//		  dc1.edit(obj1);

		/*
		 * ExpensesDao cd = new ExpensesDao();
		 *  cd.remove(224);
		 */

		/*
		 * ExpensesDao cd1 = new ExpensesDao();
		 *  Expenses category = new Expenses();
		 *  cd1.find(223); 
		 *  System.out.println(category);
		 */

//		ExpensesDao cd2 = new ExpensesDao();
//		ArrayList<Expenses> al = cd2.findAll();
//		for (Expenses category : al) {
//		System.out.println(category);
//
	//	}

	}
}
