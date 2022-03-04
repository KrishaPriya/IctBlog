package Utilities;

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


    public static String getCellData(int RowNum, int ColNum) throws IOException {
        FileInputStream ExcelFile = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/TestData.xlsx");
        excelWbook = new XSSFWorkbook(ExcelFile);
        excelWSheet = excelWbook.getSheetAt(0);
        return excelWSheet.getRow(RowNum).getCell(ColNum).getStringCellValue();
    }


    public static String getCellDataDateFormat(int RowNum, int ColNum) throws IOException {
        FileInputStream ExcelFile = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/TestData.xlsx");
        excelWbook = new XSSFWorkbook(ExcelFile);
        excelWSheet = excelWbook.getSheetAt(0);
        DataFormatter formatter = new DataFormatter();
        XSSFCell cell = excelWSheet.getRow(RowNum).getCell(ColNum);
        return formatter.formatCellValue(cell);
    }
}
