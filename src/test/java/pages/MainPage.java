package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    private By product = By.xpath("(//ul/li[@class='product column shadow hover-light'])[1]");
    private By search = By.xpath("//input[@name='query']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage selectProduct(){
        driver.get("http://localhost/litecart/");
        driver.findElement(product).click();
        return new ProductPage(driver);
    }

    public ProductPage selectProductByName(String productName){
        driver.get("http://localhost/litecart/");
        driver.findElement(search).sendKeys(productName+Keys.ENTER);
        return new ProductPage(driver);
    }
}
