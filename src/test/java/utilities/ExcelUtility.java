package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
   public FileInputStream fi;
   public XSSFWorkbook workbook;
   public XSSFSheet sheet;
   public XSSFRow row;
   public XSSFCell cell;
   public CellStyle style;
   String path;
   
   public ExcelUtility(String path) {
	   this.path=path;
   }
   
   public int getRowCount(String sheetname) throws IOException {
	   fi= new FileInputStream(path);
	   workbook= new XSSFWorkbook(fi);
	   sheet= workbook.getSheet(sheetname);
	   int rowCount=sheet.getLastRowNum();
	   workbook.close();
	   fi.close();
	   return rowCount;
    }
   
   public int getCellCount(String sheetname, int rowNum) throws IOException {
	   fi= new FileInputStream(path);
	   workbook= new XSSFWorkbook(fi);
	   sheet=workbook.getSheet(sheetname);
	   row= sheet.getRow(rowNum);
	   int cellCount= row.getLastCellNum();
	   workbook.close();
	   fi.close();
	   return cellCount;
   }
   
   public String getCellData(String sheetname, int rowNum, int colNum) throws IOException {
	   fi= new FileInputStream(path);
	   workbook=new XSSFWorkbook(fi);
	   sheet= workbook.getSheet(sheetname);
	   row=sheet.getRow(rowNum);
	   cell= row.getCell(colNum);
	   
	   DataFormatter df= new DataFormatter();
	   String data;
	   try 
	   {
		data= df.formatCellValue(cell);
	   } 
	   catch (Exception e) 
	   {
		data="";
	   }
	   workbook.close();
	   fi.close();
	   return data;	
   }
   
}
