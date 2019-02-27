package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    private By product = By.xpath("(//ul/li[@class='product column shadow hover-light'])[1]");
    public MainPage(WebDriver driver) {
        super(driver);
    }
    public ProductPage selectProduct(){
        driver.get("http://localhost/litecart/");
        driver.findElement(product).click();
        return new ProductPage(driver);
    }
}
