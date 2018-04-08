package myAccount.daos;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import myAccount.pojos.Users;
import myAccount.utilities.ConnectionPool;


public class UsersDao{
	
	public static int verify(String username, String password) {
		int id = -1;
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "select userid from users where username = ? and password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getInt("userid");
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return id;
	}

	public void create(	Users category) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "insert into users (userid,username,password,name,address,mobile,email)values(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, category.getUserid());
			ps.setString(2, category.getUsername());
			ps.setString(3, category.getPassword());
			ps.setString(4, category.getName());
			ps.setString(5, category.getAddress());
			ps.setString(6, category.getMobile());
			ps.setString(7, category.getEmail());
			
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void edit(Users category) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "update Users set username = ?, password = ? , name = ?, address = ? ,mobile = ?,email = ?  where userid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			ps.setString(1, category.getUsername());
			ps.setString(2, category.getPassword());
			ps.setString(3, category.getName());
			ps.setString(4, category.getAddress());
			ps.setString(5, category.getMobile());
			ps.setString(6, category.getEmail());
			ps.setInt(7, category.getUserid());
			
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public void remove(int userid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		try {
			String sql = "delete from users where acid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ps.executeUpdate();
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
	}

	public Users find(int userid) {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Users category = new Users();
		try {
			String sql = "select * from users where userid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				category.setUserid(userid);
				category.setUsername(rs.getString("username"));
				category.setPassword(rs.getString("password"));
				category.setName(rs.getString("name"));
				category.setAddress(rs.getString("address"));
				category.setMobile(rs.getString("mobile"));
				category.setEmail(rs.getString("email"));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return category;
	}

	public static ArrayList<Users> findAll() {
		ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		ArrayList<Users> listCategory = new ArrayList<Users>();
		try {
			String sql = "select * from users";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Users category = new Users();
				category.setUserid(rs.getInt("userid"));
				category.setUsername(rs.getString("username"));
				category.setPassword(rs.getString("password"));
				category.setName(rs.getString("name"));
				category.setAddress(rs.getString("address"));
				category.setMobile(rs.getString("mobile"));
				category.setEmail(rs.getString("email"));
				listCategory.add(category);
			}
		} catch (SQLException sq) {
			System.out.println("unable to find the record." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return listCategory;
	}
 public static Users authenticate(String username,String password)
 {
	 ConnectionPool pool = ConnectionPool.getInstance();
		pool.initialize();
		Connection conn = pool.getConnection();
		Users category = new Users();
		try {
			String sql = "select * from users where username = ? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				category.setUserid(rs.getInt(1));
				category.setUsername(rs.getString("username"));
				category.setPassword(rs.getString("password"));
				category.setName(rs.getString("name"));
				category.setAddress(rs.getString("address"));
				category.setMobile(rs.getString("mobile"));
				category.setEmail(rs.getString("email"));
			}
		} catch (SQLException sq) {
			System.out.println("Unable to create a new row." + sq);
		} finally {
			pool.putConnection(conn);
		}
		return category;
 }
	public static void main(String args[]) {

		
//		  UsersDao dc = new   UsersDao();
//		  Users obj = new Users(103,"Jayprakash96"," Prakash@123","Jay Prakash","Chhatrasal Nagar","9685163279","jayprakashjp007@gmail.com");
//		  dc.create(obj);
		 
		  
		  System.out.println(UsersDao.authenticate("Jayprakash","1234"));
		  
//		  UsersDao dc1 = new   UsersDao();
//		  Users obj1 = new Users(101," Expenses1"," Expense details1",1);
//		  dc1.edit(obj1);

		/*
		 * Users cd = new UsersDao();
		 *  cd.remove(224);
		 */

		/*
		 * UsersDao cd1 = new UsersDao();
		 *  Users category = new Users();
		 *  cd1.find(223); 
		 *  System.out.println(category);
		 */

//		UsersDao cd2 = new UsersDao();
//		ArrayList<Users> al = cd2.findAll();
//		for (Users category : al) {
//		System.out.println(category);
//
	//	}

	}
}
