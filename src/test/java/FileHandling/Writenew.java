package FileHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Writenew {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create workbook object 
		XSSFWorkbook workbook=new XSSFWorkbook();
		
	//Now create sheet in workbook
		XSSFSheet Sheet =workbook.createSheet("testing");
		
		///Now create row
		for (int i=0;i<3;i++)
		{
		XSSFRow row1=Sheet.createRow(i);
		for (int j=0;j<=3;j++)
		{
		
		//creta a cell in same row 
		 XSSFCell cell1=row1.createCell(j);
		 //set values to cell
		cell1.setCellValue("S. NO");
		}
		}
		
		//above is all virture then now we can create a file
		//for writting a file fileoutptstream and for reading the file fileinputstream
		FileOutputStream fo=null;
		File f= new File("./MyFile.xlsx");
		try {
			fo =new FileOutputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook.write(fo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fo.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("create file");
	}

}
