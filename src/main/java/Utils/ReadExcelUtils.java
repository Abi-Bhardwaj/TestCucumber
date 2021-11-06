package Utils;

import static Utils.CommonUtils.*;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * This class contains methods related to read excel file data.
 * To initialization the object of this class need to pass {@link String} ReadExcelPath in the constructor.
 * @author $@ndy
 * @since 04-Nov-2021
 * @version $@1.0
 * @category Util
 */

public class ReadExcelUtils {
    FileInputStream fis=null;

    XSSFWorkbook workbook=null;
    XSSFSheet sheet=null;
    XSSFRow row=null;
    XSSFCell cell=null;

    HSSFWorkbook excelbook=null;
    HSSFSheet excelsheet=null;
    HSSFRow hrow=null;
    HSSFCell hcell=null;

    int rowCount, colNum;
    String FileExtension, ReadExcelPath, cellValue;

    /**
     * This constructor to initialize the read excel with given excel file path
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {{@link String}} ReadExcelPath - excel file path which we want read
     * @throws Throwable
     */
    public ReadExcelUtils(String ReadExcelPath) throws Throwable {
        fis=new FileInputStream(ReadExcelPath);
        FileExtension = FilenameUtils.getExtension(ReadExcelPath);
        switch (FileExtension) {
		case "xlsx":
			workbook = new XSSFWorkbook(fis);
			break;
			
		case "xls":
			excelbook = new HSSFWorkbook(fis);
			break;
			
		default:
			System.err.println("Invalid Excel File Extension!!!!!!");
			break;
		}
        fis.close();
    }
    
    /**
     * This method count no of row of data is available in excel file with given sheet name and return that count in int
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {@link String} sheetName - sheet name of excel file from where want row count
     * @return {@link Integer} rowCount - return row of excel file from given sheet name
     * @throws Throwable
     */
    public int getNoOfRow(String sheetName) throws Throwable {
    	switch (FileExtension) {
		case "xlsx":
			sheet = workbook.getSheet(sheetName);
            rowCount = sheet.getLastRowNum()+1;
			break;
			
		case "xls":
			excelsheet=excelbook.getSheet(sheetName);
            rowCount = excelsheet.getLastRowNum()+1;
			break;
			
		default:
			System.err.println("Invalid Excel File Extension!!!!!!");
			break;
		}
        return rowCount;
    }
    
    /**
     * This method get cell data from excel file with given sheet name, column name at given row number
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {@link String} sheetName - sheet name of excel file from cell text want read
     * @param {@link String} colName - column name of given sheet name from where cell text want read
     * @param {@link Integer} rowNum - row number of given sheet name from where cell text want read
     * @return {@link String} cellValue - return cell value which read from excel file with given sheet name, column name at given row number
     */
    public String getCellData(String sheetName, String colName, int rowNum) {
        try {
        	switch (FileExtension) {
    		case "xlsx":
    			colNum=-1;
                sheet=workbook.getSheet(sheetName);
                row=sheet.getRow(0);
                for(int i=0;i<row.getLastCellNum();i++) {
                    if(row.getCell(i).getStringCellValue().trim().equals(colName))
                    	colNum=i;
                }

                row=sheet.getRow(rowNum);
                cell=row.getCell(colNum);

                if(cell.getCellTypeEnum()==CellType.STRING)  {
                    cellValue=cell.getStringCellValue();
                }
                else if(cell.getCellTypeEnum()==CellType.NUMERIC || cell.getCellTypeEnum()==CellType.FORMULA) {
                    cellValue=String.valueOf(cell.getNumericCellValue());
                    if(HSSFDateUtil.isCellDateFormatted(cell)) {
                        DateFormat dt=new SimpleDateFormat("dd/mm/yy");
                        java.util.Date date=cell.getDateCellValue();
                        cellValue=dt.format(date);
                    }
                }
                else if(cell.getCellTypeEnum()== CellType.BLANK) {
                    cellValue="";
                }
                else {
                    cellValue=String.valueOf(cell.getBooleanCellValue());
                }
    			break;
    			
    		case "xls":
    			colNum=-1;
                excelsheet=excelbook.getSheet(sheetName);
                hrow=excelsheet.getRow(0);
                for(int i=0;i<hrow.getLastCellNum();i++) {
                    if(hrow.getCell(i).getStringCellValue().trim().equals(colName))
                    	 colNum=i;
                }

                hrow=excelsheet.getRow(rowNum);
                hcell=hrow.getCell(colNum);

                if(hcell.getCellTypeEnum()==CellType.STRING) {
                    cellValue=hcell.getStringCellValue();
                }
                else if(hcell.getCellTypeEnum()==CellType.NUMERIC || hcell.getCellTypeEnum()==CellType.FORMULA) {
                    cellValue=String.valueOf(hcell.getNumericCellValue());
                    if(HSSFDateUtil.isCellDateFormatted(hcell)) {
                        DateFormat dt=new SimpleDateFormat("dd/mm/yy");
                        java.util.Date date=cell.getDateCellValue();
                        cellValue=dt.format(date);
                    }
                }
                else if(hcell.getCellTypeEnum()== CellType.BLANK) {
                    cellValue="";
                }
                else {
                    cellValue=String.valueOf(hcell.getBooleanCellValue());
                }
    			break;
    			
    		default:
    			System.err.println("Invalid Excel File Extension!!!!!!");
    			break;
    		}
        }
        catch(Exception e) {
        	printException(e, "get cell text fail - data not found");
        }

        return cellValue;
    }
}
