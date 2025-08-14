package Practicedatdriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// step1:-get excel path location &java object of physical excel file
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\admin\\eclipse-workspace\\SeliniumCRMGUIframework\\src\\test\\resources\\testscript.xlsx");
		// step2:-open work book in read mode
		Workbook wb = WorkbookFactory.create(fis);
		// step3:-get control of org sheet
		Sheet sh = wb.getSheet("org");
		// step4:- get control of 1st row
		Row row = sh.getRow(1);
		// step5:- get control of 2nd cell & read the string data
		Cell cel = row.getCell(2);
		String data = cel.getStringCellValue();
		System.out.println(data);
		Cell cel1 = row.getCell(3);
		// step6:- close the workbook
		wb.close();

	}

}
