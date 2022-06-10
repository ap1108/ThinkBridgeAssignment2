package ThinkBridge.Extensions;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitExtensions 
{
	
	public static void ExplicitWaitForElementPresence(WebDriver driver, int TimeinSeconds, By SearchLinkLocator)
    {
        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(TimeinSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(SearchLinkLocator));
    }

    public static void ImplicitWait(WebDriver driver, int TimeinSeconds)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TimeinSeconds));
    }

    public static void ExplicitWaitForElementDisplayed(WebDriver driver, int TimeinSeconds, By SearchLinkLocator)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeinSeconds));
        wait.until(ExpectedConditions.presenceOfElementLocated(SearchLinkLocator));
    }

    public static void ExplicitWaitForElementPresence(WebDriver driver, int TimeinSeconds, WebElement webElement)
    {
    	WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(TimeinSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void IgnoreExceptionElementNotPresent(WebDriver driver, int TimeinSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeinSeconds));
        wait.ignoring(NoSuchElementException.class);
    }
    
    public static void ExplicitWaitForElementVisible(WebDriver driver, int TimeinSeconds, By SearchLinkLocator)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeinSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(SearchLinkLocator));
    }
    
    public static void IgnoreExceptionElementNotInteractable(WebDriver driver, int TimeinSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeinSeconds));
        wait.ignoring(ElementNotInteractableException.class);
    }

}
