package App2.test;

import java.sql.*;

public class UpdateEmployeeDAO {
	
   public int k=0;
   
   public int update(EmployeeBean eb) {
	   
	   try {
		   Connection con = DBConnection.getCon();
		   PreparedStatement ps = con.prepareStatement
				   ("update Employee07 set bsal=?,hra=?,da=?,totsal=? where eid=?");
		   
		   ps.setInt(1, eb.getbSal());
		   ps.setFloat(2, eb.getHra());
		   ps.setFloat(3, eb.getDa());
		   ps.setFloat(4, eb.getTotSal());
		   ps.setString(5, eb.geteId());
		   
		   k = ps.executeUpdate();
		   
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
	   
	   return k;
   }
}

