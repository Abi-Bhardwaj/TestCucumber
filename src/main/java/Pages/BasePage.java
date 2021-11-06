package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * This class contains common variable, objects & steps of Page Factory & Page Object Model classes.
 * By using inheritance Page Factory & Page Object Model classes can use this class all variable, object & steps.
 * To initialization the object of this class need to pass {WebDriver} driver in the constructor.
 * @author $@ndy
 * @since 04-Nov-2021
 * @version $@1.0
 * @category BasePFandPOM
 */

public class BasePage {
	public WebDriver driver;
	
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}
