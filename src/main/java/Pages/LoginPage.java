package Pages;

import org.openqa.selenium.WebDriver;

/**
 * This class contains all POM(Page Object Model) methods related to Login Page.
 * To initialization the object of this class need to pass {WebDriver} driver in the constructor.
 * Inherited LoginPageObjects class.
 * @author $@ndy
 * @since 04-Nov-2021
 * @version $@1.0
 * @category POMs
 */

public class LoginPage extends LoginPageObjects {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	
}
