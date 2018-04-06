package com.evevoni.qa.util;

import static com.evevoni.qa.base.TestBase.driver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
//import jxl.Cell;
//import jxl.Sheet;
//import jxl.Workbook;
//import jxl.read.biff.BiffException;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;



/**
 *
 * @author yvonneak
 */
public class TestUtil {
    
    //These variables can be change or be defined in our config property file
    public static long PAGE_LOAD_TIMEOUT =20;
    public static long IMPLICIT_WAIT = 20;
    
    public static String TESTDATA_SHEET_PATH ="/Users/yvonneak/eclipse-workspace/com.evevoni/src/main/java/com/evevoni/qa/testdata/newUserData.xls";
    


     static Workbook book;
    //static Sheet contacts;
     static Sheet sheet;
     static Sheet sheet2;
    //static Row row;
    
     public static Object[][] getTestData(String sheetName) {
         FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		 System.out.println(sheet.getLastRowNum() + "--------" +
		 sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				System.out.println(data[i][k]);
			}
		}
		return data;
     }
    
     
    public static Object[][] getLonginData(String sheetName){
        FileInputStream file = null;
        
        try {
            file= new FileInputStream(TESTDATA_SHEET_PATH);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            book=WorkbookFactory.create(file);
        } catch (IOException ex) {
            Logger.getLogger(TestUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidFormatException ex) {
            Logger.getLogger(TestUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        sheet2=book.getSheet(sheetName);
        Object[][] data=new Object[sheet2.getLastRowNum()][sheet2.getRow(0).getLastCellNum()];
         System.out.println(sheet2.getLastRowNum() + "--------" +
            sheet2.getRow(0).getLastCellNum());
         for(int i=0; i<sheet2.getLastRowNum(); i++){
             for (int j=0; j<sheet2.getRow(0).getLastCellNum(); j++){
              data[i][j]  =sheet2.getRow(i+1).getCell(j+1).toString();
              System.out.println(data[i][j]);
             }
                    
          }
        return data;
    }
    
    
    public static Object[][] getTestData2(String sheetName) {
                
        try {
			String dataSets[][] = null;
			FileInputStream file = new FileInputStream(new File(TESTDATA_SHEET_PATH));

			// Create Workbook instance holding reference to .xlsx file
			//XSSFWorkbook workbook = new XSSFWorkbook(file);
                        HSSFWorkbook workbook = new HSSFWorkbook(file);
                        //HSSFWorkbook & HSSFSheet
			// Get first/desired sheet from the workbook
			//XSSFSheet sheet = workbook.getSheet(sheetName);
                        HSSFSheet sheet = workbook.getSheet(sheetName);
			// count number of active rows
			int totalRow = sheet.getLastRowNum();
			// count number of active columns in row
			int totalColumn = sheet.getRow(0).getLastCellNum();
			// Create array of rows and column
			dataSets = new String[totalRow][totalColumn];
			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			int i = 0;
			while (rowIterator.hasNext()) {
                            //i=i++;
				System.out.println(i);

				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();
				int j = 0;
				while (cellIterator.hasNext()) {

					Cell cell = cellIterator.next();
					if (cell.getStringCellValue().contains("sName")) {
						break;
					}

					// Check the cell type and format accordingly
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						dataSets[i-1][j++] = cell.getStringCellValue();
						System.out.println(cell.getNumericCellValue());
						break;
					case Cell.CELL_TYPE_STRING:
						dataSets[i][j++] = cell.getStringCellValue();
						System.out.println(cell.getStringCellValue());
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						dataSets[i-1][j++] = cell.getStringCellValue();
						System.out.println(cell.getStringCellValue());
						break;
					case Cell.CELL_TYPE_FORMULA:
						dataSets[i-1][j++] = cell.getStringCellValue();
						System.out.println(cell.getStringCellValue());
						break;
                                                
                                        default:
                                            cell.toString();
					}

				}

				System.out.println("");
				i++;
			}
			file.close();
			return dataSets;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
        


       
    
    public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		
		}
   

}

