package Utils;

import static Utils.CommonUtils.*;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains all methods related Webdriver operations.
 * Each method of class is static method.
 * @author $@ndy
 * @version $@1.0
 * @since 04-Nov-2021
 * @category Util
 */

public class WebDriverUtils {
    static String windowTitle = null, elementText = null, attributeValue = null, alertMessage = null, windowId = null;
    static boolean verify = false;
    static Set<String> set;
    static Iterator<String> itr;
    static String[] windowIdList = null;
    static WebDriverWait wait;
    static WebElement element = null;
    static Alert alert;
    static Select select;
    static JavascriptExecutor jsExecutor;
    static Actions actions;
    
    
    
    /**
     * This method to create a webelment basis on link text and return the webelement
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {String} textValue - link text to create webelement
     * @return {WebElement} element - created webelment using link text
     */
    public static WebElement textContainsWebelement(WebDriver driver, String textValue) {
        element = driver.findElement(By.xpath("//*[contains(text(),'"+textValue+"')]"));
        return element;
    }
    
    /**
     * This method to create a webelment basis on link text and return the webelement
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {String} textValue - link text to create webelement
     * @return {WebElement} element - created webelment using link text
     */
    public static WebElement textMatchWebelement(WebDriver driver, String textValue) {
        element = driver.findElement(By.xpath("//*[text()='"+textValue+"']"));
        return element;
    }
    
    /**
     * This method add Implicit wait in webdriver.
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {int} waitTimeInSec - wait time in seconds
     * @return void
     */
    public static void implicitlyWait(WebDriver driver, int waitTimeInSec) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTimeInSec));
    }
    
    /**
     * This method return window title.
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @return {String} text - return window title in string
     */
    public static String getTitle(WebDriver driver)
    {
    	return driver.getTitle();
    }
    
    /**
     * This method return webelement text.
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {WebElement} element - webelement from which text want capture
     * @return {String} text - return webelement text in string
     */
    public static String getText(WebDriver driver, WebElement element)
    {
    	elementText = element.getText();
    	elementText = elementText.trim();
    	return elementText;
    }
    
    /**
     * This method return webelement Tag Name.
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {WebElement} element - webelement from which text want capture
     * @return {String} text - return webelement Tag Name in string
     */
    public static String getTagName(WebDriver driver, WebElement element)
    {
    	return element.getTagName();
    }
    
    /**
     * This method return webelement text.
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {WebElement} element - webelement from which attribute value want to capture
     * @param {String} attributeName - attribute name from which attribute value want to capture
     * @return {String} attributeValue - return webelement text in string
     */
    public static String getAttributeValue(WebDriver driver, WebElement element, String attributeName)
    {
    	attributeValue = element.getAttribute(attributeName);
    	attributeValue = attributeValue.trim();
    	return attributeValue;
    }
    
    /**
     * This method perform click operation on webelement
     * Methods body is surround with try catch.
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {WebElement} element - webelement where want perform click operation
     * @return void
     */
    public static void click(WebDriver driver, WebElement Element)
    {
    	try {
			Element.click();
		} catch (Exception e) {
			printException(e, "Click fail");
		}
    }
    
    /**
     * This method perform clear operation on webelement
     * Methods body is surround with try catch.
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {WebElement} element - webelement where want perform clear operation
     * @return void
     */
    public static void clear(WebDriver driver, WebElement Element)
    {
    	try {
			Element.clear();
		} catch (Exception e) {
			printException(e, "Clear fail");
		}
    }
    
    /**
     * This method to close the current window of browser
     * Methods body is surround with try catch.
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @return void
     */
    public static void close(WebDriver driver)
    {
    	try {
			driver.close();
		} catch (Exception e) {
			printException(e, "Close fail");
		}
    }
    
    /**
     * This method to close the browser with all window related to driver
     * Methods body is surround with try catch.
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @return void
     */
    public static void quit(WebDriver driver)
    {
    	try {
			driver.quit();
		} catch (Exception e) {
			printException(e, "quit fail");
		}
    }
    
    /**
     * This method perfom enter operation on webelement
     * Methods body is surround with try catch.
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {WebElement} element - webelement where want perform click operation
     * @return void
     */
    public static void enter(WebDriver driver, WebElement Element, String value)
    {
    	try {
			Element.sendKeys(value);
		} catch (Exception e) {
			printException(e, "sendKeys fail");
		}
    }
    
    /**
     * This method initialization webdriverwait object and return the instance of that object
     * Methods body is surround with try catch
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {int} waitTimeInSec - wait time in seconds
     * @return {WebDriverWait} wait - instance of that object
     */
    public static WebDriverWait initWebDriverWait(WebDriver driver, int timeInSec) {
    	wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSec));
    	return wait;
    }
    
    /**
     * This method add Explicit wait in webdriver until invisible the webelment.
     * Methods body is surround with try catch
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {WebElement} element - wait until webbelment object
     * @param {int} waitTimeInSec - wait time in seconds
     * @return void
     */
    public static void InvisibilityOfElementExplicityWait(WebDriver driver, WebElement element, int timeInSec) {
        try {
            wait = initWebDriverWait(driver, timeInSec);
            wait.until(ExpectedConditions.invisibilityOf(element));
        }
        catch (Exception e) {
        	printException(e, "Explicity Wait fail");
        }
    }
    
    
    /**
     * This method add Explicit wait in webdriver until Element Attribute Contains of webelment
     * Methods body is surround with try catch
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {WebElement} element - wait until webbelment object
     * @param {String} attributename - attribute name form which value want to capture
     * @param {String} attributevalue = attribute value which partially need to verify
     * @param {int} waitTimeInSec - wait time in seconds
     * @return void
     */
    public static void ElementAttributeContainsExplicityWait(WebDriver driver, WebElement element, String attributename, String attributevalue, int timeInSec) {
        try {
            wait = initWebDriverWait(driver, timeInSec);
            wait.until(ExpectedConditions.attributeContains(element, attributename, attributevalue));
        }
        catch (Exception e) {
        	printException(e, "Explicity Wait fail");
        }
    }
    
    
    /**
     * This method add Explicit wait in webdriver until Element To be Clickable of webelment
     * Methods body is surround with try catch
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {WebElement} element - wait until webbelment object
     * @param {int} waitTimeInSec - wait time in seconds
     * @return void
     */
    public static void ExplicityWaitForElementTobeClickable(WebDriver driver, WebElement element, int timeInSec) {
        try {
            wait = initWebDriverWait(driver, timeInSec);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }
        catch (Exception e) {
        	printException(e, "Explicity Wait fail");
        }
    }
    
    
    /**
     * This method add Explicit wait in webdriver until Visibility of webelment
     * Methods body is surround with try catch
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {List <WebElement>} element - wait until list of webbelment object
     * @param {int} waitTimeInSec - wait time in seconds
     * @return void
     */
    public static void VisibilityOfElementExplicityWait(WebDriver driver, List <WebElement> Element, int timeInSec) {
        try {
            wait = initWebDriverWait(driver, timeInSec);
            wait.until(ExpectedConditions.visibilityOfAllElements(Element));
        }
        catch (Exception e) {
        	printException(e, "Explicity Wait fail");
        }
    }
    
    
    /**
     * This method add Explicit wait in webdriver until Visibility of webelment
     * Methods body is surround with try catch
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {WebElement} element - wait until list of webbelment object
     * @param {int} waitTimeInSec - wait time in seconds
     * @return void
     */
    public static void VisibilityOfElementExplicityWait(WebDriver driver, WebElement element, int timeInSec) {
        try {
            wait = initWebDriverWait(driver, timeInSec);
            wait.until(ExpectedConditions.visibilityOf(element));
        }
        catch (Exception e) {
        	printException(e, "Explicity Wait fail");
        }
    }
    

    /**
     * This method check window title match with given title and return in true or false
     * Methods body is surround with try catch.
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {String} title - title text to match window title
     * @return {boolean} verify - title match or not in true or false
     */
    public static boolean isTitleMatch(WebDriver driver, String title) {
        try {
        	windowTitle = getTitle(driver);
            if (windowTitle.equalsIgnoreCase(title))
                verify = true;
            else
            	verify = false;
        }
        catch (Exception e) {
        	verify = false;
        	printException(e, "Title Match fail");
        }

        return verify;
    }
    
    
    /**
     * This method check window title partially match with given title and return in true or false
     * Methods body is surround with try catch.
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {String} title - title text to partially match window title
     * @return {boolean} verify - title partially match or not in true or false
     */
    public static boolean isTitleContains(WebDriver driver, String title) {
        try {
        	windowTitle = getTitle(driver);
            if (windowTitle.contains(title))
                verify = true;
            else
            	verify = false;
        }
        catch (Exception e) {
        	verify = false;
        	printException(e, "Title Partially Match fail");
        }

        return verify;
    }
    
    
    /**
     * This method check webelement is present or not and return in true or false
     * Methods body is surround with try catch.
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {WebElement} Element - webelement which present or not
     * @return {boolean} verify - webelement is present or not in true or false
     */
    public static Boolean isElementPresent(WebDriver driver, WebElement Element) {
        try {
        	verify = Element.isDisplayed();
        }
        catch (Exception e) {
        	verify = false;
        	printException(e, "Element Present fail");
        }

        return verify;
    }
    
    
    /**
     * This method check webelement is present or not and return in true or false
     * Methods body is surround with try catch.
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {List <WebElement>} Element - list of webelement which present or not
     * @return {boolean} verify - webelement is present or not in true or false
     */
    public static Boolean isElementPresent(WebDriver driver, List <WebElement> Element) {
        try {
        	verify = Element.get(0).isDisplayed();
        }
        catch (Exception e) {
        	verify = false;
        	printException(e, "Element Present fail");
        }

        return verify;
    }
    
    
    /**
     * This method check webelement is present or not and return in true or false.
     * Methods body is surround with try catch.
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {String} linkTextValue - linkText value which present or not
     * @return {boolean} verify - webelement is present or not in true or false
     * @throws Throwable
     */
    public static Boolean isElementPresent(WebDriver driver, String linkTextValue) throws Throwable {
        try {
            element = textContainsWebelement(driver, linkTextValue);
            Thread.sleep(500);
            verify = element.isDisplayed();
        }
        catch (Exception e) {
        	verify = false;
        	printException(e, "Element Present fail");
        }

        return verify;
    }
    
    /**
     * This method check webelement text match with expected text or not and return in true or false.
     * Methods body is surround with try catch.
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {WebElement} Element - webelement which text get cpature
     * @param {String} ElementText - expected text which match with webelment text or not 
     * @return {boolean} verify - webelement text match with expected text or not in true or false
     */
    public static Boolean isElementTextMatch(WebDriver driver, WebElement Element, String expectedText) {
        try {
            elementText = getText(driver, Element);
            verify = elementText.equalsIgnoreCase(expectedText);
        }
        catch (Exception e) {
        	verify = false;
        	printException(e, "Element text match fail");
        }

        return verify;
    }
    
    /**
     * This method check webelement text partially match with expected text  or not and return in true or false.
     * Methods body is surround with try catch.
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {WebElement} Element - webelement which text get cpature
     * @param {String} ElementText - expected text which partially match with webelment text or not 
     * @return {boolean} verify - webelement text partially match with expected text or not in true or false
     */
    public static Boolean isElementTextContain(WebDriver driver, WebElement Element, String expectedText) {
        try {
            elementText = getText(driver, Element);
            verify = elementText.contains(expectedText);
        }
        catch (Exception e) {
        	verify = false;
        	printException(e, "Element text partially match fail");
        }

        return verify;
    }
    
    /**
     * This method check webelement attribute value match with expected attribute value or not and return in true or false.
     * Methods body is surround with try catch.
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {WebElement} Element - webelement which attribute value want to cpature
     * @param {String} attributeName - attribute name which attribute value want to cpature 
     * @param {String} expectedAttributeValue - expected attribute value which match with attribute value or not 
     * @return {boolean} verify - webelement attribute value match with expected attribute value or not in true or false
     */
    public static Boolean isElementAttributeValueEqual(WebDriver driver, WebElement Element, String attributeName, String expectedAttributeValue) {
        try {
            attributeName = getAttributeValue(driver, Element, attributeName);
            verify = attributeName.equalsIgnoreCase(expectedAttributeValue);
        }
        catch (Exception e) {
        	verify = false;
        	printException(e, "Element attribute value match fail");
        }

        return verify;
    }
    
    /**
     * This method check webelement attribute value partially match with expected attribute value or not and return in true or false.
     * Methods body is surround with try catch.
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {WebElement} Element - webelement which attribute value want to cpature
     * @param {String} attributeName - attribute name which attribute value want to cpature 
     * @param {String} expectedAttributeValue - expected attribute value which partially match with attribute value or not 
     * @return {boolean} verify - webelement attribute value partially match with expected attribute value or not in true or false
     */
    public static Boolean isElementAttributeValueContains(WebDriver driver, WebElement Element, String attributeName, String expectedAttributeValue) {
        try {
            attributeName = getAttributeValue(driver, Element, attributeName);
            verify = attributeName.contains(expectedAttributeValue);
        }
        catch (Exception e) {
        	verify = false;
        	printException(e, "Element attribute value partially match fail");
        }

        return verify;
    }
    
    /**
     * This method to initialization Actions class object and return the instance of the object
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @return {Actions} actions - return the instance of object
     */
    public static Actions initActions(WebDriver driver) {
    	actions = new Actions(driver);
    	return actions;
    }
    
    /**
     * This method is to perform hover the mouse and click on webelement using actions class
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {WebElement} Element - webelment to perform hover the mouse and click on webelement using actions class
     * @return void
     */
    public static void MoveToElementAndClick_Actions(WebDriver driver, WebElement Element) {
        try {
        	actions = initActions(driver);
            actions.moveToElement(Element).click().perform();
        } catch (Exception e) {
        	printException(e, "Actions move to element & click fail");
        }
    }
    
    /**
     * This method is to perform drag & drop operation on webelement using actions class
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {WebElement} fromElement - webelment to drag using actions class
     * @param {WebElement} toElement - webelment to drop location using actions class
     * @return void
     */
    public static void DragAndDrop_Actions(WebDriver driver, WebElement fromElement, WebElement toElement) throws Throwable {
    	try {
			actions = initActions(driver);
			actions.moveToElement(fromElement)
			        .clickAndHold(fromElement)
			        .moveToElement(toElement)
			        .release(toElement).build().perform();

			Thread.sleep(3000);
		} catch (Exception e) {
        	printException(e, "Actions drag & drop fail");
		}
    }
    
    /**
     * This method to initialization JavascriptExecutor class object and return the instance of the object
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @return {JavascriptExecutor} jsExecutor - return the instance of object
     */
    public static JavascriptExecutor initJavascriptExecutor(WebDriver driver) {
        jsExecutor = (JavascriptExecutor) driver;
        return jsExecutor;
    }
    
    /**
     * This method is to perform click operation on webelement using JavascriptExecutor class
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {WebElement} Element - webelment to perform click operation on webelement using JavascriptExecutor class
     * @return void
     */
    public static void javascriptExecutorClick(WebDriver driver, WebElement Element) {
    	try {
			jsExecutor = initJavascriptExecutor(driver);
			jsExecutor.executeScript("arguments[0].click();", Element);
		} catch (Exception e) {
        	printException(e, "JavascriptExecutor click fail");
		}
    }
    
    /**
     * This method is to perform scroll operation on webelement using JavascriptExecutor class
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {WebElement} Element - webelment to perform scroll operation on webelement using JavascriptExecutor class
     * @return void
     */
    public static void javascriptExecutorScroll(WebDriver driver, WebElement Element) {
    	try {
			jsExecutor = initJavascriptExecutor(driver);
			jsExecutor.executeScript("arguments[0].scrollIntoView();", Element);
		} catch (Exception e) {
        	printException(e, "JavascriptExecutor scroll fail");
		}
	}
    
    /**
     * This method return current window id
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @return {String} windowId - windows id in string
     */
    public static String getWindowId(WebDriver driver) {
        windowId = driver.getWindowHandle();
        return windowId;
    }
    
    /**
     * This method return list of windows id in array
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @return {String[]} windowIdList - list of windows id in array string
     */
    public static String[] getListWindowId(WebDriver driver) {
        set = driver.getWindowHandles();
        itr = set.iterator();
        int i=0;
        while (itr.hasNext()) {
        	windowIdList[i]=itr.next();
            i++;
        }
        return windowIdList;
    }
    
    /**
     * This method switch to window base on index
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {String[]} windowIdList - list of windows id to pass index and switch window
     * @param {int} index - index no to switch to window id
     * @return void
     */
    public static void windowSwtich(WebDriver driver, String[] windowIdList, int index) throws Throwable {
        try {
           driver.switchTo().window(windowIdList[index]);
           Thread.sleep(1000);
        }
        catch (Exception e) {
        	printException(e, "Switch to window fail");
        }
    }
	
    /**
     * This method switch to window base on window title
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {String[]} windowIdList - list of windows id to pass index and switch window
     * @param {String} expectedTitle - window title to verify and switch window
     * @return void
     */
	public static void windowSwtich(WebDriver driver, String[] windowIdList, String expectedTitle) throws Throwable {
        try {
           for (int i = 0; i < windowIdList.length; i++) 
           {
        	   driver.switchTo().window(windowIdList[i]);
               Thread.sleep(2000);
               System.out.println(getTitle(driver));
               if (isTitleContains(driver, expectedTitle))
            	   break;
           }
           Thread.sleep(2000);
        }
        catch (Exception e) {
        	printException(e, "Switch to window fail");
        }
    }
	
	/**
     * This method switch to window base on index
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {int} index - index no to switch to window id
     * @return void
     */
	public static void switchToWindow(WebDriver driver, int index) throws Throwable {
		windowSwtich(driver, getListWindowId(driver), index);
	}
	
	/**
     * This method switch to window base on window title
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {String} expectedTitle - window title to verify and switch window
     * @return void
     */
	public static void switchToWindow(WebDriver driver, String expectedTitle) throws Throwable {
		windowSwtich(driver, getListWindowId(driver), expectedTitle);
	}
	
	/**
     * This method switch to default content
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @return void
     */
	public static void switchToDefaultContent(WebDriver driver) throws Throwable {
        try {
           driver.switchTo().defaultContent();
           Thread.sleep(1000);
        }
        catch (Exception e) {
        	printException(e, "Switch to default content fail");
        }
    }
	
	/**
     * This method switch to frame base on index no
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {int} frameIndex - frame index no to switch
     * @return void
     */
	public static void switchToFrame(WebDriver driver, int frameIndex) throws Throwable {
        try {
           driver.switchTo().frame(frameIndex);
           Thread.sleep(1000);
        }
        catch (Exception e) {
        	printException(e, "Switch to frame fail");
        }
    }
	
	/**
     * This method switch to frame base on name or id
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {String} nameOrId - frame id or name to switch
     * @return void
     */
	public static void switchToFrame(WebDriver driver, String nameOrId) throws Throwable {
        try {
           driver.switchTo().frame(nameOrId);
           Thread.sleep(1000);
        }
        catch (Exception e) {
        	printException(e, "Switch to frame fail");
        }
    }
	
	/**
     * This method switch to frame base on webelement
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {WebElement} element - frame webelment to swtich
     * @return void
     */
	public static void switchToFrame(WebDriver driver, WebElement element) throws Throwable {
        try {
           driver.switchTo().frame(element);
           Thread.sleep(1000);
        }
        catch (Exception e) {
        	printException(e, "Switch to frame fail");
        }
    }
	
	/**
     * This method switch to alert
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @return {Alert} alert - return initialization  alert
     */
	public static Alert switchToAlert(WebDriver driver) throws Throwable {
        try {
           alert = driver.switchTo().alert();
           Thread.sleep(1000);
        }
        catch (Exception e) {
        	printException(e, "Switch to alert fail");
        }
        return alert;
    }
	
	/**
     * This method get text from alert
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {Alert} alert - initialization alert object
     * @return {String} alertMessage - return alert message in string
     */
	public static String getAlertMessage(WebDriver driver, Alert alert) throws Throwable {
        try {
        	alertMessage = alert.getText();
        }
        catch (Exception e) {
        	printException(e, "Alert message fail");
        }
        
        return alertMessage;
    }
	
	/**
     * This method check alert is present or not
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @return {boolean} verify - return alert present or not in true or false
     */
	public static boolean isAlertPresent(WebDriver driver) throws Throwable {
        try {
        	switchToAlert(driver);
        	verify = true;
        }
        catch (Exception e) {
        	verify = false;
        	printException(e, "Switch to alert fail");
        }
        
        return verify;
    }
	
	/**
     * This method check alert message is match with expected alert message.
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {Alert} alert - initialization alert object
     * @param {String} alertMsg - expected alert message to match with alert messagge
     * @return {boolean} verify - return alert message is match or not in true or false
     */
	public static boolean isAlertMessageMatch(WebDriver driver, Alert alert, String alertMsg) throws Throwable {
        try {
           verify = getAlertMessage(driver, alert).equalsIgnoreCase(alertMsg);
        }
        catch (Exception e) {
        	verify = false;
        	printException(e, "Alert message match fail");
        }
        
        return verify;
    }
	
	/**
     * This method check alert message is partially match with expected alert message.
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {Alert} alert - initialization alert object
     * @param {String} alertMsg - expected alert message to partially match with alert message
     * @return {boolean} verify - return alert message is partially match or not in true or false
     */
	public static boolean isAlertMessageContains(WebDriver driver, Alert alert, String alertMsg) throws Throwable {
        try {
           verify = getAlertMessage(driver, alert).contains(alertMsg);
        }
        catch (Exception e) {
        	verify = false;
        	printException(e, "Alert message partially match fail");
        }
        return verify;
    }
	
	/**
     * This method to accept or dismiss the alert.
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {Alert} alert - initialization alert object
     * @param {boolean} action - action in true or false, true - accept & false - dismiss
     * @return void
     */
	public static void alertAction(WebDriver driver, Alert alert, boolean action) throws Throwable {
        try {
        	if(action == true)
        		alert.accept();
            else
         	   alert.dismiss();
        }
        catch (Exception e) {
        	verify = false;
        	printException(e, "Alert action fail");
        }
    }
	
	/**
     * This method to handle alert with verifying alert message
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {String} alertMsg - expected alert message to partially match with alert message
     * @param {boolean} action - action in true or false, true - accept & false - dismiss
     * @return void
     */
	public static void handleAlert(WebDriver driver, String alertMsg, boolean action) throws Throwable {
        try {
        	alert = switchToAlert(driver);
        	Verify(isAlertMessageContains(driver, alert, alertMsg), true, alertMsg+" alert message is not displayed!!!");
        	alertAction(driver, alert, action);
        }
        catch (Exception e) {
        	printException(e, "Alert handle fail");
        }
    }
	
	/**
     * This method to handle alert
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {boolean} action - action in true or false, true - accept & false - dismiss
     * @return void
     */
	public static void handleAlert(WebDriver driver, boolean action) throws Throwable {
        try {
        	alert = switchToAlert(driver);
        	alertAction(driver, alert, action);
        }
        catch (Exception e) {
        	printException(e, "Alert handle fail");
        }
    }
	
	/**
     * This method to handle alert
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {WebElement} Element - webelement to init the select calss
     * @return {Select} select - return instance of select class
     */
	public static Select initSelect(WebDriver driver, WebElement Element) {
		try {
			select = new Select(Element);
		} catch (Exception e) {
        	printException(e, "Select init fail");
		}
		
		return select;
	}
	
	/**
     * This method to select a option from dropdown using select class
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {WebElement} Element - webelement to init the select calss
     * @param {String} optionVisibleText - option name/value which want select from the dropdown
     * @return void
     */
	public static void select(WebDriver driver, WebElement Element, String optionVisibleText) {
		try {
			select = initSelect(driver, Element);
			select.selectByVisibleText(optionVisibleText);
		} catch (Exception e) {
        	printException(e, "Select fail");
		}
	}
	
	/**
     * This method to select a option from dropdown using select class
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {WebDriver} driver - initialization webdriver object
     * @param {WebElement} Element - webelement to init the select calss
     * @param {int} optionIndex - option index no which want select from the dropdown
     * @return void
     */
	public static void select(WebDriver driver, WebElement Element, int optionIndex) {
		try {
			select = initSelect(driver, Element);
			select.selectByIndex(optionIndex);
		} catch (Exception e) {
        	printException(e, "Select fail");
		}
	}

}
