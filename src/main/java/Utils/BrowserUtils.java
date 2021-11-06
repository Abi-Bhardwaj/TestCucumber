package Utils;


import static Helper.BaseObejcts.*;
import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * This class contains all browser related methods using Selenium.
 * Each method of class is static method.
 * @author $@ndy
 * @since 04-Nov-2021
 * @version $@1.0
 * @category Util
 */

public class BrowserUtils {
	
	/**
     * LaunchChromeBroswer is method for initialization of WebDriver object
     * @author $@ndy
     * @since 04-Nov-2021
     * and return initialization WebDiver object
     * and also set download path in chrome browswer
     * @param {String} chromeDriverPath - path of the chrome driver
     * @return {WebDriver} driver - return initialization WebDiver object
     */
    public static WebDriver LaunchChromeBrowser(String chromeDriverPath) {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        return driver;
    }

    /**
     * LaunchChromeBroswer is method for initialization of WebDriver object
     * and return inizalize WebDiver object
     * and also set download path in chrome browswer
     * @param {String} chromeDriverPath - path of the chrome driver
     * @param {String} downloadFolderPath  - path of download folder where we want download files
     * @return {WebDriver} driver - return initialization WebDiver object
     */
    public static WebDriver LaunchChromeBrowser(String chromeDriverPath, String downloadFolderPath) {
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        ChromeOptions options=new ChromeOptions();
        HashMap<String, Object> chromePref = new HashMap<String, Object>();
        chromePref.put("profile.default_content_settings.popups", 0);
        chromePref.put("download.default_directory", downloadFolderPath);
        options.setExperimentalOption("prefs", chromePref);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        return driver;
    }
	
}
