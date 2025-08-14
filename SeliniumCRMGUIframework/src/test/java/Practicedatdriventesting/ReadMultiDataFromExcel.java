package Practicedatdriventesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultiDataFromExcel {
public static void main(String[] args) throws Throwable {
	FileInputStream fis = new FileInputStream(
"C:\\Users\\admin\\eclipse-workspace\\SeliniumCRMGUIframework\\src\\test\\resources\\TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	 Sheet sh = wb.getSheet("Sheet1");
	 int rowcount=sh.getLastRowNum();
	 for (int i = 1; i <=rowcount ; i++) {
		Row row = sh.getRow(i);
		String col1Data = row.getCell(0).toString();
		String col2Data = row.getCell(1).toString();
			System.out.println(col1Data+"\t"+col2Data);
	}
	 wb.close();
}
}
