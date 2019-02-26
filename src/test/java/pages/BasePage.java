package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    private int timeOutSeconds = 10;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementIsVisible(By by) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void acceptAlertIfPresent() {
        try {
            if (ExpectedConditions.alertIsPresent() != null) {
                Alert alert = driver.switchTo().alert();
                alert.accept();
            }
        } catch (NoAlertPresentException e) {
        }
    }
}
