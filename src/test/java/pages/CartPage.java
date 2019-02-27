package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{
    private By firstItem = By.xpath("(//ul/li[@class='shortcut'])[1");
    private By removeButton = By.name("remove_cart_item");
    private By orderConfirmationTable = By.id("order_confirmation-wrapper");
    public CartPage(WebDriver driver) {
        super(driver);
    }
}
