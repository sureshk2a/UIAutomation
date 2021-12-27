package utils.seleniumUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumActions
{
    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor jsExecutor;
    WebElement ele;

    public SeleniumActions(WebDriver _driver){
        this.driver = _driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        jsExecutor = ((JavascriptExecutor) this.driver);
    }

    public void highlightElement(WebElement element) throws InterruptedException{
        jsExecutor.executeScript("arguments[0].style.cssText = 'background-color:yellow'",element);
        Thread.sleep(350);
        jsExecutor.executeScript("arguments[0].style.cssText = 'background-color:none'",element);

    }

    public boolean waitForElementToVisible(WebElement element) {
        try{
            this.wait.until(ExpectedConditions.visibilityOf((element)));
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public WebElement GetElementFromList(List<WebElement> elements, String textDisplayed){
        for(int i=0;i<elements.size();i++){
            if(elements.get(i).getText().equalsIgnoreCase(textDisplayed)){
                ele = elements.get(i);
                break;
            }
        }
        return ele;
    }

    public void sendKeysToElement(WebElement element,String textToSend){
        if(this.waitForElementToVisible(element)){
            element.clear();
            element.sendKeys(textToSend);
        }
    }

    public void waitAndClickElement(By locator){
        ele = driver.findElement(locator);
        if(this.waitForElementToVisible(ele)){
            ele.click();
        }
    }
}
