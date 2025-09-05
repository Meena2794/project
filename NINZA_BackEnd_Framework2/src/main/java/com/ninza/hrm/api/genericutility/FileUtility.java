package com.ninza.hrm.api.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {

	
  public String getDataFromProperties(String Key) throws IOException {
	  FileInputStream fis= new FileInputStream("./config_envData.properties");
	 Properties pobj=new Properties();
	 pobj.load(fis);
	String data = pobj.getProperty(Key);
	  return data;
	
	 
 }
 
	}


