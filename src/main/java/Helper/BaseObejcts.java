package Helper;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import Pages.LoginPage;
import Utils.ReadExcelUtils;

/**
 * This class contain all base objects.
 * Each object of class is static object.
 * @author $@ndy
 * @since 04-Nov-2021
 * @version $@1.0
 * @category Helper
 */

public class BaseObejcts {
	public static WebDriver driver;
	
	public static ReadExcelUtils read;
	
	public static LoginPage login;
	
	public static File file;
    public static InputStream fis;
    public static Properties pf;
	
}
