package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private By productItems = By.xpath("(//ul/li[@class='shortcut'])");
    private By removeButton = By.name("remove_cart_item");
    private By orderConfirmationTable = By.id("order_confirmation-wrapper");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage removeAllItemsFromCart() {
        for (int i = 0; i < driver.findElements(productItems).size(); i++) {
            driver.findElement(removeButton).click();
            waitForStalenessOf(driver.findElement(orderConfirmationTable));
        }
        itemsInCart = 0;
        return this;
    }
}
