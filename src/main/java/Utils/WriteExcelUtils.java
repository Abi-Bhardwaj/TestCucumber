package Utils;

import java.io.FileOutputStream;
import java.nio.file.Path;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * This class contains all methods related create & write excel.
 * @author $@ndy
 * @version $@1.0
 * @since 04-Nov-2021
 * @category Util
 */

public class WriteExcelUtils {
    public FileOutputStream fos;

    public HSSFWorkbook excelbook;
    public HSSFSheet excelsheet;
    public HSSFRow row;
    public HSSFCell cell;

    public XSSFWorkbook workbook;
    public XSSFSheet sheet;
    public XSSFRow xrow;
    public XSSFCell xcell;

    CellStyle style9;

    Path ExcelSavePath;
    int cellNo;
    String wExcel, returnExcelPath;
    
    /**
     * This method create a excel file with extension '.xls' at give folder path with given excel name & sheet name and add headers given array at given rowNo.
     * Also it return the created excel file path in {@link Path}.
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {@link String} ExcelFolderPath - folder path where excel want create
     * @param {@link String} excelName - excel file name to set create excel file name
     * @param {@link String} sheetName - sheet name to create sheet inside the excel file
     * @param {@link Integer} rowNo - row number at which header will be written
     * @param {@link String[]} headers - header list which want write in excel file
     * @return {@link Path} - return the created excel file path in {@link Path}
     * @throws Throwable
     */
    public Path createExcel(String ExcelFolderPath, String excelName, String sheetName, int rowNo, String headers[]) throws Throwable {
        excelbook=new HSSFWorkbook();
        ExcelSavePath=java.nio.file.Paths.get(ExcelFolderPath, excelName+".xls");
        excelsheet= excelbook.createSheet(sheetName);

        row=excelsheet.createRow(rowNo);
        style9=excelbook.createCellStyle();

        for (int i = 0; i < headers.length; i++) {
            style9.setBorderBottom(BorderStyle.THIN);
            style9.setBorderLeft(BorderStyle.THIN);
            style9.setBorderRight(BorderStyle.THIN);
            style9.setBorderTop(BorderStyle.THIN);
            cell = row.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(style9);
        }

        wExcel=(ExcelSavePath).toString();
        fos=new FileOutputStream(wExcel);
        excelbook.write(fos);
        fos.close();

        return ExcelSavePath;
    }
    
    /**
     * This method create a excel file with extension '.xlsx' at give folder path with given excel name & sheet name and add headers given array at given rowNo.
     * Also it return the created excel file path in {@link Path}.
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {@link String} ExcelFolderPath - folder path where excel want create
     * @param {@link String} excelName - excel file name to set create excel file name
     * @param {@link String} sheetName - sheet name to create sheet inside the excel file
     * @param {@link Integer} rowNo - row number at which header will be written
     * @param {@link String[]} headers - header list which want write in excel file
     * @return {@link Path} - return the created excel file path in {@link Path}
     * @throws Throwable
     */
    public Path createExcelX(String ExcelFolderPath,String excelName,String sheetName, int rowNo, String headers[]) throws Throwable {
        workbook=new XSSFWorkbook();
        ExcelSavePath=java.nio.file.Paths.get(ExcelFolderPath, excelName+".xlsx");
        sheet=workbook.createSheet(sheetName);

        xrow=sheet.createRow(rowNo);
        style9=workbook.createCellStyle();

        for (int i = 0; i < headers.length; i++) {
            style9.setBorderBottom(BorderStyle.THIN);
            style9.setBorderLeft(BorderStyle.THIN);
            style9.setBorderRight(BorderStyle.THIN);
            style9.setBorderTop(BorderStyle.THIN);
            xcell = xrow.createCell(i);
            xcell.setCellValue(headers[i]);
            xcell.setCellStyle(style9);
        }

        wExcel=(ExcelSavePath).toString();
        fos=new FileOutputStream(wExcel);
        workbook.write(fos);
        fos.close();

        return ExcelSavePath;
    }
    
    /**
     * This method write excel file with ".xls" with list of data in excel path at given row number
     * @param {@link Path} ExcelSavePath - excel path where we want write
     * @param {@link Integer} rowNo - row number at which want write 
     * @param {@link String...} variableSet - list of data want to enter
     * @return {@link String} returnExcelPath - return the created excel file path 
     * @throws Throwable
     */
    public String writeExcel(Path ExcelSavePath, int rowNo, String... variableSet) throws Throwable {
        cellNo=0;
        row = excelsheet.createRow(rowNo);
        style9 = excelbook.createCellStyle();

        for (String variable : variableSet) {
            style9.setBorderBottom(BorderStyle.THIN);
            style9.setBorderLeft(BorderStyle.THIN);
            style9.setBorderRight(BorderStyle.THIN);
            style9.setBorderTop(BorderStyle.THIN);
            cell = row.createCell(cellNo++);
            cell.setCellValue(variable);
            cell.setCellStyle(style9);
        }

        wExcel=(ExcelSavePath).toString();
        fos = new FileOutputStream(wExcel);
        excelbook.write(fos);
        fos.close();

        returnExcelPath=(ExcelSavePath).toString();
        return returnExcelPath;
    }
    
    /**
     * This method write excel file with ".xlsx" with list of data in excel path at given row number
     * @param {@link Path} ExcelSavePath - excel path where we want write
     * @param {@link Integer} rowNo - row number at which want write 
     * @param {@link String...} variableSet - list of data want to enter
     * @return {@link String} returnExcelPath - return the created excel file path 
     * @throws Throwable
     */
    public String writeExcelX(Path ExcelSavePath, int rowNo, String... variableSet) throws Throwable {
        cellNo=0;
        xrow = sheet.createRow(rowNo);
        style9 = workbook.createCellStyle();

        for (String variable : variableSet) {
            style9.setBorderBottom(BorderStyle.THIN);
            style9.setBorderLeft(BorderStyle.THIN);
            style9.setBorderRight(BorderStyle.THIN);
            style9.setBorderTop(BorderStyle.THIN);
            xcell = xrow.createCell(cellNo++);
            xcell.setCellValue(variable);
            xcell.setCellStyle(style9);
        }

        wExcel=(ExcelSavePath).toString();
        fos = new FileOutputStream(wExcel);
        workbook.write(fos);
        fos.close();

        returnExcelPath=(ExcelSavePath).toString();
        return returnExcelPath;
    }
}
