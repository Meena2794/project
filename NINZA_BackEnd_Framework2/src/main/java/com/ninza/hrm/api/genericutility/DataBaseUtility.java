package com.ninza.hrm.api.genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;
import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	FileUtility flib =new FileUtility();
	public static Connection con;
	
	public void getDbconnection() throws SQLException {
	try {
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(flib.getDataFromProperties("DB_Url"),flib.getDataFromProperties("DB_Username"),flib.getDataFromProperties("DB_Password"));	
	} catch (Exception e) {}
	}	
	public void closeDbconnection(){
		try {
			con.close();
			
		} catch (Exception e) {}
	}
	public static boolean executeQueryVerifyAndGetData(String query, int ColumnIndex,String expectedData) throws SQLException {
		
		boolean flag =false; 
				Statement stat = con.createStatement();
				  ResultSet set = stat.executeQuery(query);
				  while (set.next()) {
						 if(set.getString(ColumnIndex).equals(expectedData)) {
							 flag=true;
							 break;
						 }
						 }
if(flag) {
	System.out.println(expectedData +"====> data verified in data base table");
	return true;
}else {
	System.out.println(ColumnIndex +"====> data not verified in data base table");
	return false;
}
	}
	public ResultSet excecuteSelectQuery(String Query, int i, String proName) {
		ResultSet result=null;
		try {
			Statement stat =con.createStatement();
			result= stat.executeQuery(Query);
		} catch (Exception e) {}
		return result;	
	}
	
	public int excuteNonseletQuery(String Query) {
		int result=0;
		try {
			Statement stat= con.createStatement();
			result=stat.executeUpdate(Query);
		} catch (Exception e) {}
		return result;
		
	}
	public void getDbconnections() throws SQLException {
		try {
			Driver driver= new Driver();
			DriverManager.registerDriver(driver);
			con=DriverManager.getConnection(flib.getDataFromProperties("DBurl"),
					flib.getDataFromProperties("DB_Username"),
					flib.getDataFromProperties("DB_Password"));	
		} catch (Exception e) {}
		}		
	}


