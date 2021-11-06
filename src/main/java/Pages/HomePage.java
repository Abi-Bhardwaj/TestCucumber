package Pages;

import org.openqa.selenium.WebDriver;

/**
 * This class contains all POM(Page Object Model) methods related to Home Page.
 * To initialization the object of this class need to pass {WebDriver} driver in the constructor.
 * Inherited HomePageObjects class. 
 * @author $@ndy
 * @since 04-Nov-2021
 * @version $@1.0
 * @category POM
 */

public class HomePage extends HomePageObjects {
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	
}
