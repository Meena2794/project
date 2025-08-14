package Practicedatdriventesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class SimpleDataTest {

	public static void main(String[] args) throws SQLException {
		//step:Load/registor the Database driver
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		//step2:coneect database//step3:create Sql
		Connection con = DriverManager.getConnection("jdbc.mysql://http://localhost:3306/project", "root", "root");
		System.out.println("=====done=====");
		//step3:create Sql statement
		Statement stat = con.createStatement();
		//step4: Execute select query &get result
		ResultSet resultSet = stat.executeQuery("select * from project");
	while (resultSet.next()) {
		System.out.println(resultSet.getString(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getString(3)+"\t"+resultSet.getString(4)+"\t"+resultSet.getString(5)+"\t"+resultSet.getString(6));
		//step5:close the connect
		con.close();
		
	}
	}

}
