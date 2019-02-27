package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage extends BasePage {
    private By LoginField = By.name("username");
    private By PasswordField = By.name("password");
    private By LoginButton = By.name("login");

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public AdminPage logIntoAdmin() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(LoginField).sendKeys("admin");
        driver.findElement(PasswordField).sendKeys("admin");
        driver.findElement(LoginButton).click();
        return this;
    }

    public void headerIsPresent() {
        for (int i = 1; i < driver.findElements(By.xpath("//li[@id='app-']")).size() + 1; i++) {
            driver.findElement(By.xpath("//li[@id='app-'][" + i + "]")).click();
            Assert.assertTrue(driver.findElement(By.xpath("//h1")).isDisplayed());
            for (int j = 1; j < driver.findElements(By.xpath("//li[starts-with(@id,'doc')]")).size() + 1; j++) {
                driver.findElement(By.xpath("//li[starts-with(@id,'doc')][" + j + "]")).click();
                Assert.assertTrue(driver.findElement(By.xpath("//h1")).isDisplayed());
            }
        }
    }
}
