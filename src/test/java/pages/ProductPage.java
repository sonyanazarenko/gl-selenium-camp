package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    private By product = By.name("add_cart_product");
    public ProductPage(WebDriver driver) {
        super(driver);
    }
}
