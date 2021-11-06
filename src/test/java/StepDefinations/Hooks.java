package StepDefinations;

import static Helper.BaseVariables.*;
import static Helper.BaseObejcts.*;
import static Helper.Constants.*;
import Utils.BrowserUtils;
import Utils.ScreenShotsUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/**
 * This class contains all hooks of cucumber framework.
 * @author $@ndy
 * @version $@1.0
 * @since 04-Nov-2021
 * @category Hook
 */

public class Hooks {


    @Before(order=1)
    public void LaunchChromeBrowser() {
        driver = BrowserUtils.LaunchChromeBrowser(ChromeDriverPath);
    }

    @Before(order=2)
    public void LaunchApplication() {
        driver.get(URL);
    }

    @Before(order=2)
    public void Initialize(Scenario sc) {
        
    }

    @After(order=1)
    public void TakeAndAttachScreenshot(Scenario sc) {
        ScreenShotsUtils.AttachScreenShotToExtentReport(driver, sc);
    }

    @After(order=0)
    public void CloseBrowser() throws Throwable
    {
        Thread.sleep(2000);

        driver.quit();

        System.out.println(" <----------------------- Scenario End ------------------------->");
    }

}

