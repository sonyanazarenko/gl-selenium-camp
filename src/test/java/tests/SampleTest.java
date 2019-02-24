package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SampleTest extends BaseTest {
    @Test
    public void googleTest() {
        driver.get("https://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Hello kitty");
        element.submit();
        Assert.assertTrue(driver.findElement(By.id("uid_1")).isDisplayed());
    }
}
