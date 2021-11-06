package Utils;

import static Utils.CommonUtils.*;
import io.cucumber.java.Scenario;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * ScreenshotUtils class contains all methods related to Screenshots.
 * Each method of class is static method.
 * @author $@ndy
 * @since 04-Nov-2021
 * @version $@1.0
 * @category Util
 */
public class ScreenShotsUtils {

    /**
     * This is method for to take a screenshot and attach the screenshot to extent report
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {{@link WebDriver}}driver
     * @param {{@link Scenario}}sc
     * @return void
     */
    public static void AttachScreenShotToExtentReport(WebDriver driver, Scenario sc)
    {
        try {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			sc.attach(screenshot, "image/png", "image");
		} catch (Exception e) {
	  		printException(e, "Attach screenshot to extent report Fail");
		}
    }
    
    /**
     * This is method for to take a screenshot, store the screenshot with given name at given folder path and return the screenshot file path in string
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {{@link WebDriver}} driver 
     * @param {{@link String}} screenshotFolderPath - screenshot folder path where screenshot will store
     * @param {{@link String}} screenshotName - screenshot name which will given to screenshot
     * @return {{@link String}} ScreenShotPath - return capture screenshot path in string
     */
    public String ScreenShot(WebDriver driver, String screenshotFolderPath, String screenshotName) throws Throwable {
		String ScreenShotPath = null;
    	try {
	  	    ScreenShotPath = screenshotFolderPath + screenshotName + "_" + CurrentDate("dd-MM-yyyy_HH.mm.ss") + ".jpg";
	  	    File screenshots = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);       		 
		    FileUtils.copyFile(screenshots, new File(ScreenShotPath));
        }
	  	catch(Exception e) {
	  		printException(e, "Screenshot Fail");
	  	}
	  	return ScreenShotPath;
  	 }
    

}
