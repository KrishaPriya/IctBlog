package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtility {

	 
	




    private static XSSFWorkbook excelWbook;
    private static XSSFSheet excelWSheet;
    private static XSSFCell cell;


    public static String getTrainerCellData(int RowNum, int ColNum) throws IOException {
        FileInputStream ExcelFile = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/TestDatas.xlsx");
        excelWbook = new XSSFWorkbook(ExcelFile);
        excelWSheet = excelWbook.getSheetAt(0);
      //  if(excelWSheet.getRow(RowNum) != null)
        return excelWSheet.getRow(RowNum).getCell(ColNum).getStringCellValue();
    }


    public static String getCellDataFormat(int RowNum, int ColNum) throws IOException {
        FileInputStream ExcelFile = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/TestDatas.xlsx");
        excelWbook = new XSSFWorkbook(ExcelFile);
        excelWSheet = excelWbook.getSheetAt(0);
        DataFormatter formatter = new DataFormatter();
      
        XSSFCell cell = excelWSheet.getRow(RowNum).getCell(ColNum);
        return formatter.formatCellValue(cell);
       
        
       
    }

    public static String getAdminCellData(int RowNum, int ColNum) throws IOException {
        // Open the Excel file
        FileInputStream ExcelFile = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/TestDatas.xlsx");
        excelWbook = new XSSFWorkbook(ExcelFile);
        excelWSheet = excelWbook.getSheetAt(0);
        DataFormatter formatter = new DataFormatter();
        cell= excelWSheet.getRow(RowNum).getCell(ColNum);
        return formatter.formatCellValue(cell);
    }

}