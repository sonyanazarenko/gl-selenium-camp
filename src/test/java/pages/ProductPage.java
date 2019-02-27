package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends BasePage {
    private By addToCartButton = By.name("add_cart_product");
    private By itemsInCartIcon = By.className("quantity");
    private By homeIcon = By.xpath("//i[@class='fa fa-home']");
    private By checkOutButton = By.xpath("//a[@class='link'][text()='Checkout »']");
    private By sizeDropDown = By.name("options[Size]");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage addProductToCart() {
        if(driver.findElements(sizeDropDown).size()>0){
            Select dropdown = new Select(driver.findElement(sizeDropDown));
            dropdown.selectByIndex(1);
        }
        driver.findElement(addToCartButton).click();
        itemsInCart++;
        return this;
    }

    public ProductPage verifyItemsInCartIncreased() {
        waitForTextToBe(itemsInCartIcon, String.valueOf(itemsInCart));
        Assert.assertEquals(itemsInCart, Integer.parseInt(driver.findElement(itemsInCartIcon).getText()));
        return this;
    }

    public MainPage returnToHomePage() {
        waitForElementIsVisible(homeIcon);
        driver.findElement(homeIcon).click();
        return new MainPage(driver);
    }

    public CartPage checkout(){
        driver.findElement(checkOutButton).click();
        return new CartPage(driver);
    }
}
