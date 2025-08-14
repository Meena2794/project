package Practicedatdriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SampleDataDrivenTesting {

	public static void main(String[] args) throws IOException {
FileInputStream fis=new FileInputStream("C:\\Users\\admin\\OneDrive\\Desktop\\CommonData.properties");
Properties pobj= new Properties();
pobj.load(fis);
pobj.getProperty("browser");
pobj.getProperty("url");
pobj.getProperty("username");
pobj.getProperty("password");
System.out.println(pobj.getProperty("browser"));
}

}
