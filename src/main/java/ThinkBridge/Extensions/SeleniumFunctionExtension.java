package ThinkBridge.Extensions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class SeleniumFunctionExtension 
{
	
	public static Select SelectValueinDropDown(WebElement webElement, String SelectValue)
    {
        Select OutputOption = new Select(webElement);
        OutputOption.selectByValue(SelectValue);
        return OutputOption;
    }

    public static void DragDropWebElement(WebElement Source, WebElement Target, WebDriver driver)
    {
        Actions action = new Actions(driver);
        action.dragAndDrop(Source, Target).perform();
    }

    public static void MoveToElement(WebDriver driver, WebElement element)
    {
        Actions action = new Actions(driver);
        action.moveToElement(element);
    }

    public static void JSGetElementByID(WebDriver driver, String Id)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver ;
        String Script = "document.getElementById('" + Id + "').Click()";
        js.executeScript(Script);
    }

    public static void JSClick(WebDriver driver, By locator)
    {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String Script = "arguments[0].click();";
        js.executeScript(Script,element);
    }

    public static WebElement FindElementByJs(WebDriver driver, String jsCommand)
    {
        return (WebElement)((JavascriptExecutor)driver).executeScript(jsCommand);
    }
}
