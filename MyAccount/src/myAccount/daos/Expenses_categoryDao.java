package myAccount.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import myAccount.pojos.Expenses_category;
import myAccount.utilities.ConnectionPool;

public class Expenses_categoryDao {

	public void create(Expenses_category category) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "insert into expenses_category (exp_catid, exp_catname,exp_catdetails,userid) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, category.getExp_catid());
			ps.setString(2, category.getExp_catname());
			ps.setString(3, category.getExp_catdetails());
			ps.setInt(4, category.getUserid());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void edit(Expenses_category category) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update expenses_category set exp_catname = ?,exp_catdetails = ?, userid = ? where exp_catid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, category.getExp_catname());
			ps.setString(2, category.getExp_catdetails());
			ps.setInt(3, category.getUserid());
			ps.setInt(4, category.getExp_catid());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void remove(int exp_catid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from expenses_category where exp_catid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, exp_catid);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public Expenses_category find(int exp_catid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Expenses_category category = new Expenses_category();
		try {
			String sql = "select * from expenses_category where exp_catid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, exp_catid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				category.setExp_catid(exp_catid);
				category.setExp_catname(rs.getString("exp_catname"));
				category.setExp_catdetails(rs.getString("exp_catdetails"));
				category.setUserid(rs.getInt("userid"));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return category;
	}

	public ArrayList<Expenses_category> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Expenses_category> listCategory = new ArrayList<Expenses_category>();
		try {
			String sql = "select * from expenses_category";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Expenses_category category = new Expenses_category();
				category.setExp_catid(rs.getInt("exp_catid"));
				category.setExp_catname(rs.getString("exp_catname"));
				category.setExp_catdetails(rs.getString("exp_catdetails"));
				category.setUserid(rs.getInt("userid"));
				listCategory.add(category);
			}
		} catch (SQLException sq) {
			System.out.println("unable to find the record." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listCategory;
	}
	
	
	public ArrayList<Expenses_category> findAll(int userid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Expenses_category> listCategory = new ArrayList<Expenses_category>();
		try {
			String sql = "select * from expenses_category where userid =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,userid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Expenses_category category = new Expenses_category();
				category.setExp_catid(rs.getInt("exp_catid"));
				category.setExp_catname(rs.getString("exp_catname"));
				category.setExp_catdetails(rs.getString("exp_catdetails"));
				category.setUserid(rs.getInt("userid"));
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
//
//		 Expenses_categoryDao dc = new Expenses_categoryDao();
//		 Expenses_category obj = new Expenses_category(103,"Direct Expenses2"," Direct expense2 details",1);
//		 dc.create(obj);

		Expenses_categoryDao dc1 = new Expenses_categoryDao();
		Expenses_category obj1 = new Expenses_category(102, " Expenses4", " Expense details3", 4);
		dc1.edit(obj1);

		/*
		 * CategoriesDaos cd = new CategoriesDaos(); cd.remove(224);
		 */

		/*
		 * CategoriesDaos cd = new CategoriesDaos(); Categories category = new
		 * Categories(); cd.find(223); System.out.println(category);
		 */

//		Expenses_categoryDao cd = new Expenses_categoryDao();
//		ArrayList<Expenses_category> al = cd.findAll();
//		for (Expenses_category category : al) {
//			System.out.println(category);
//
//		}
		Expenses_categoryDao cd = new Expenses_categoryDao();
		ArrayList<Expenses_category> al = cd.findAll(0);
		for (Expenses_category category : al) {
			System.out.println(category);

		}

	}
}
