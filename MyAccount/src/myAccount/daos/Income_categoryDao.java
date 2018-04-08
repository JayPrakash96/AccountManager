package myAccount.daos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import myAccount.pojos.Income_category;
import myAccount.utilities.ConnectionPool;


public class Income_categoryDao {

	public void create(	Income_category category) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "insert into income_category (inc_catid, inc_catname,inc_catdetails,userid) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, category.getInc_catid());
			ps.setString(2, category.getInc_catname());
			ps.setString(3, category.getInc_catdetails());
			ps.setInt(4, category.getUserid());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void edit(Income_category category) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update income_category set inc_catname = ?,inc_catdetails = ?, userid = ? where inc_catid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, category.getInc_catname());
			ps.setString(2, category.getInc_catdetails());
			ps.setInt(3, category.getUserid());
			ps.setInt(4, category.getInc_catid());
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void remove(int inc_catid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from income_category where inc_catid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, inc_catid);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public Income_category find(int inc_catid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
			Income_category category = new 	Income_category();
		try {
			String sql = "select * from expenses_category where exp_catid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, inc_catid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				category.setInc_catid(inc_catid);
				category.setInc_catname(rs.getString("inc_catname"));
				category.setInc_catdetails(rs.getString("inc_catdetails"));
				category.setUserid(rs.getInt("userid"));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return category;
	}

	public ArrayList<Income_category> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Income_category> listCategory = new ArrayList<Income_category>();
		try {
			String sql = "select * from income_category";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Income_category category = new Income_category();
				category.setInc_catid(rs.getInt("inc_catid"));
				category.setInc_catname(rs.getString("inc_catname"));
				category.setInc_catdetails(rs.getString("inc_catdetails"));
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
	public ArrayList<Income_category> findAll(int userid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Income_category> listCategory = new ArrayList<Income_category>();
		try {
			String sql = "select * from income_category where userid =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,userid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Income_category category = new Income_category();
				category.setInc_catid(rs.getInt("inc_catid"));
				category.setInc_catname(rs.getString("inc_catname"));
				category.setInc_catdetails(rs.getString("inc_catdetails"));
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

		
	      Income_categoryDao dc = new  Income_categoryDao();
		  Income_category obj = new Income_category(101,"Direct Income"," Direct Income details",1);
		  dc.create(obj);
		 
//
//		  Income_categoryDao dc1 = new   Income_categoryDao();
//		  Income_category obj1 = new Income_category(101," Income1"," 	Income details1",1);
//		  dc1.edit(obj1);

		/*
		  Income_categoryDao cd = new Income_categoryDao(); 
		  cd.remove(224);
		 */

		/*
		 * CategoriesDaos cd = new CategoriesDaos(); Categories category = new
		 * Categories(); cd.find(223); System.out.println(category);
		 */

//		CategoriesDao cd = new CategoriesDao();
//		ArrayList<Categories> al = cd.findAll();
//		for (Categories category : al) {
//		System.out.println(category);
//
	//	}

	}
}
