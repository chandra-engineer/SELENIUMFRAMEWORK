package dataDriven;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import java.io.*;
import java.util.Iterator;

public class Exampl {

	

	private static final int STRING = 0;


	public static void main(String[] args) throws IOException {

		
		


		String xlpath = "D:\\Naidu\\empdata.xlsx";

		FileInputStream file = new FileInputStream(xlpath);

		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");

		int row = sheet.getLastRowNum();
		int col = sheet.getRow(0).getLastCellNum();

		for (int r = 0; r <= row; r++) {

			XSSFRow cr = sheet.getRow(r);

			for (int c = 0; c < col; c++) {
				XSSFCell cell = cr.getCell(c);
				
//					String value = cell.getCell(c).toString();
				
				int value = cell.getCellType();
					System.out.print("   " + value);
				}
				System.out.println();

			}
		
		
	/*	 Iterator iterator=sheet.iterator();
		 
		 while(iterator.hasNext())
		 {
			 
			 
			 XSSFRow currentrow= (XSSFRow) iterator.next();
			 Iterator cellIterator= currentrow.cellIterator();
			 
			 while(cellIterator.hasNext()) {
				 
				 XSSFCell cell=(XSSFCell) cellIterator.next();
				 
				 switch(cell.getCellType()) {
				 
				 case STRING: System.out.println(cell.getStringCellValue()); break;
				 case BOOLEAN:System.out.println(cell.getBooleanCellValue());break;
				 default:
					 System.out.println(cell.getNumericCellValue());break;
				 
				 }
				 
				 
				 System.out.print("     "  +cell.getNumericCellValue());
			 }
		 }System.out.println();
		
		
	*/
		
		}

	}


