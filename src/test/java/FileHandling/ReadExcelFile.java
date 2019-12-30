package FileHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelFile {

	public static void main(String[] args) throws InvalidFormatException, IOException {
		// TODO Auto-generated method stub
		File f = new File("./MyFile.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("testsheet");
		// Total number of rows---:
		//System.out.println(sheet.getLastRowNum());
		int totalrows = sheet.getLastRowNum();// retrun number of indexs
		for (int i = 0; i < totalrows + 1; i++) {
			Row rows = sheet.getRow(i);
			int totalCell = rows.getLastCellNum();// return number of cells
			for (int j = 0; j < totalCell; j++) {
				Cell cell = rows.getCell(j);// this is for get the cell not read
				switch(cell.getCellType())///getcelltype--return integer value
				{
				case Cell.CELL_TYPE_STRING:
					System.out.println(cell.getStringCellValue());
					break;
				case Cell.CELL_TYPE_NUMERIC:
					System.out.println(cell.getNumericCellValue());
				}

			}

		}

	}

}
