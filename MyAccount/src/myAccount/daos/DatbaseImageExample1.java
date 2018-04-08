package myAccount.daos;
import java.io.*;
import java.sql.*;
public class DatbaseImageExample1 {
	 public static void main(String args[]){
	        try{
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/myaccount","root","1234");
	            
	            File file=new File("E:\\image2.jpg");
	            FileOutputStream fos=new FileOutputStream(file);
	            byte b[];
	            Blob blob;
	            
	            PreparedStatement ps=con.prepareStatement("select * from image"); 
	            ResultSet rs=ps.executeQuery();
	            
	            while(rs.next()){
	                blob=rs.getBlob("image");
	                b=blob.getBytes(1,(int)blob.length());
	                fos.write(b);
	            }
	            
	            ps.close();
	            fos.close();
	            con.close();
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	    }

}
