package myAccount.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import myAccount.pojos.Incomes;
import myAccount.utilities.ConnectionPool;

public class IncomesDao {
	public void create(	Incomes category) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "insert into incomes (inc_ac,userid,inc_catid,amount,tran_date,receiveby,remark) values(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, category.getInc_ac());
			ps.setInt(2, category.getUserid());
			ps.setInt(3, category.getInc_catid());
			ps.setDouble(4, category.getAmount());
			Date dt=new Date( category.getTran_date().getTime());
			ps.setDate(5, dt);
			ps.setString(6,category.getReceiveby());
			ps.setString(7,category.getRemark());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void edit(Incomes category) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update incomes set exp_ac = ?,userid = ?, exp_catid= ? ,amount = ? ,tran_date = ? ,payby = ? , remark = ? where exp_catid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, category.getInc_ac());
			ps.setInt(2, category.getUserid());
			ps.setInt(3, category.getInc_catid());
			ps.setDouble(4, category.getAmount());
			Date dt=new Date( category.getTran_date().getTime());
			ps.setDate(5, dt);
			ps.setString(6,category.getReceiveby());
			ps.setString(7,category.getRemark());
			ps.setInt(8, category.getInc_id());
			
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void remove(int inc_id) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from incomes where exp_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, inc_id);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public Incomes find(int inc_id) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Incomes category = new Incomes();
		try {
			String sql = "select * from incomes where exp_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, inc_id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				category.setInc_id(inc_id);
				category.setInc_ac(rs.getString("inc_ac"));
				category.setUserid(rs.getInt("userid"));
				category.setInc_catid(rs.getInt("inc_catid"));
				category.setAmount(rs.getDouble("Amount"));
				java.sql.Date dt = rs.getDate("tran_date");
				category.setTran_date(new java.util.Date(dt.getTime()));
				category.setReceiveby(rs.getString("receiveby"));
				category.setRemark(rs.getString("remark"));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return category;
	}

	public ArrayList<Incomes> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Incomes> listCategory = new ArrayList<Incomes>();
		try {
			String sql = "select * from incomes";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Incomes category = new Incomes();
				category.setInc_id(rs.getInt("inc_id"));
				category.setInc_ac(rs.getString("inc_ac"));
				category.setUserid(rs.getInt("userid"));
				category.setInc_catid(rs.getInt("inc_catid"));
				category.setAmount(rs.getDouble("amount"));
				java.sql.Date dt = rs.getDate("tran_date");
				category.setTran_date(new java.util.Date(dt.getTime()));
				category.setReceiveby(rs.getString("receiveby"));
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
	
	public ArrayList<Incomes> findAll(int userid) {
	ConnectionPool pool = ConnectionPool.getInstance();
	pool.initialize();
	Connection conn = pool.getConnection();
	ArrayList<Incomes> listCategory = new ArrayList<Incomes>();
	try {
		String sql = "select * from incomes where userid =?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,userid);
		ResultSet rs = ps.executeQuery();
	while (rs.next()) {
			Incomes category = new Incomes();
	category.setInc_id(rs.getInt("inc_id"));
	category.setInc_ac(rs.getString("inc_ac"));
	category.setUserid(rs.getInt("userid"));
	category.setInc_catid(rs.getInt("inc_catid"));
	category.setAmount(rs.getDouble("amount"));
	java.sql.Date dt = rs.getDate("tran_date");
	category.setTran_date(new java.util.Date(dt.getTime()));
	category.setReceiveby(rs.getString("receiveby"));
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
	
	
	
	
	
	
	public ArrayList<Incomes> findAllDateWise(String sdate , String edate, int userid)
	{
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		
		ArrayList<Incomes> listCategory = new ArrayList<Incomes>();
		try {
			String sql = " select * from incomes where tran_date  between ? and ? and userid = ? order by tran_date " ;
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
				Incomes category = new Incomes();
				category.setInc_id(rs.getInt("inc_id"));
				category.setInc_ac(rs.getString("inc_ac"));
				category.setUserid(rs.getInt("userid"));
				category.setInc_catid(rs.getInt("inc_catid"));
				category.setAmount(rs.getDouble("amount"));
				category.setTran_date(rs.getDate("tran_date"));
				category.setReceiveby(rs.getString("receiveby"));
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

		
//		  IncomesDao dc = new   IncomesDao();
//		  Incomes obj = new Incomes(102,"Direct Expenses"," Direct expense details",1);
//		  dc.create(obj);
		 

//		  IncomesDao dc1 = new   IncomesDao();
//		  Incomes obj1 = new Incomes(101," Expenses1"," Expense details1",1);
//		  dc1.edit(obj1);

		/*
		 * IncomesDao cd = new IncomesDao();
		 *  cd.remove(224);
		 */

		/*
		 * IncomesDao cd1 = new IncomesDao();
		 *  Incomes category = new Incomes();
		 *  cd1.find(223); 
		 *  System.out.println(category);
		 */

//		IncomesDao cd2 = new IncomesDao();
//		ArrayList<Incomes> al = cd2.findAll();
//		for (Incomes category : al) {
//		System.out.println(category);
//
	//	}

	}
}


