package TestDataHandler;

import static Helper.Constants.*;
import static Helper.BaseObejcts.*;
import static Helper.BaseVariables.*;
import Helper.BaseVariables;
import Helper.Constants;
import Utils.ReadExcelUtils;

/**
 * This class contains all test data reader method.
 * Each method of class is static method.
 * @author $@ndy
 * @version $@1.0
 * @since 04-Nov-2021
 * @category TestDataHandler
 */

public class TestDataReader {
	
	/**
	 * This method to initialize the {@link ReadExcelUtils} class object with excel file path form {@link Constants} class.
     * @author $@ndy
     * @since 04-Nov-2021
	 * @return void
	 * @throws Throwable
	 */
	public static void initTestDataReader() throws Throwable {
		read = new ReadExcelUtils(TestDataPath);
	}
	
	/**
	 * This method to read the url/test link from the excel file and set the url in {@link BaseVariables}
     * @author $@ndy
     * @since 04-Nov-2021
	 * @return void
	 * @throws Throwable
	 */
	public static void readURL() throws Throwable {
		URL = read.getCellData(TestLinkSheet, "URL", 1);
	}
	
	
}
