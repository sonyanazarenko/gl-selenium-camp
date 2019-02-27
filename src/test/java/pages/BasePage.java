package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    private int timeOutSeconds = 10;
    static int itemsInCart = 0;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementIsVisible(By by) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForTextToBe(By by, String expectedText){
        WebDriverWait wait = new WebDriverWait(driver,timeOutSeconds);
        wait.until(ExpectedConditions.textToBe(by, expectedText));
    }

    public void waitForStalenessOf(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver,timeOutSeconds);
        wait.until(ExpectedConditions.stalenessOf(webElement));
    }
}
