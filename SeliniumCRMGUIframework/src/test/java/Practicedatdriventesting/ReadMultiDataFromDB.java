package Practicedatdriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class ReadMultiDataFromDB {
public static void main(String[] args) throws SQLException {

	//step:1 Load/register the database driver
Driver driverRef =new Driver();
DriverManager.registerDriver(driverRef);
//step:2 connect to database
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/performance_schema","root","root");
	 System.out.println("====done====");  
	 //step3:Create sql statement
	 Statement stat = con.createStatement();
	 //step4: execute select query &get result
	 ResultSet set = stat.executeQuery("select * from accounts");
	 while (set.next()) {
	 System.out.println(set.getString(1)+"\t"+set.getString(2)+"\t"+set.getString(3)+"\t"+set.getString(4)+"\t"+set.getString(5)+"\t"+set.getInt(6));
	 }
	 //step5: close the connection
		con.close();
	
}
}
