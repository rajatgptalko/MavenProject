	package FileHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestRead {

	public static void main(String[] args) throws InvalidFormatException, IOException {
		File f = new File("./MyFile.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("testing");
		int totalrows = sheet.getLastRowNum();
		for (int i = 0; i < totalrows + 1; i++)// get index
		{
			Row rows = sheet.getRow(i);
			int totalCell = rows.getLastCellNum();
			for (int j = 0; j < totalCell; j++) {
				Cell cell = rows.getCell(j);
				switch (cell.getCellType())/// getcelltype--return integer value
				{
				case Cell.CELL_TYPE_STRING:
					if (cell.getStringCellValue().equals("vaibhav")) {
						int x = cell.getColumnIndex();
						Cell cell1 = rows.getCell(x + 2);

						System.out.println(cell1.getStringCellValue());

					}
					// System.out.println(cell.getStringCellValue());
					break;
				case Cell.CELL_TYPE_NUMERIC:
					if (cell.getNumericCellValue() == 2) {
						int x = cell.getColumnIndex();
						System.out.println(x);

					}
				}

			}
		}
	}

}
