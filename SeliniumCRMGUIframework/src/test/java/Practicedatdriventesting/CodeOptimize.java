package Practicedatdriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class CodeOptimize {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\admin\\eclipse-workspace\\SeliniumCRMGUIframework\\src\\test\\resources\\testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet("org").getRow(1).getCell(2).getStringCellValue();
		System.out.println(data);
		String data1 = wb.getSheet("org").getRow(1).getCell(3).toString();
		System.out.println(data1);
		wb.close();

	}

}
