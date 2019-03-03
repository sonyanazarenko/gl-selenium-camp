package tests;

import listeners.CustomEventListener;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class SampleTest extends BaseTest {

    @Ignore
    @Test
    public void googleTest() {
        EventFiringWebDriver event = new EventFiringWebDriver(driver);
        CustomEventListener handle = new CustomEventListener();

        event.register(handle);
        driver.get("https://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Hello kitty");
        element.submit();
        Assert.assertTrue(driver.findElement(By.id("uid_11")).isDisplayed());
        event.unregister(handle);
    }
}
