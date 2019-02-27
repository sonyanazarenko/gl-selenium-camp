package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    private By addToCartButton = By.name("add_cart_product");
    private By itemsInCartIcon = By.className("quantity");
    private By homeIcon = By.xpath("//i[@class='fa fa-home']");
    private By checkOutButton = By.xpath("//a[@class='link'][text()='Checkout »']");
    private By sizeDropDown = By.name("options[Size]");
    public ProductPage(WebDriver driver) {
        super(driver);
    }
    static int itemsInCart = 0;

    public ProductPage addProductToCart(){
        driver.findElement(addToCartButton).click();
        itemsInCart++;
        return this;
    }

    public ProductPage verifyItemsInCartIncreased(){
        //wait for element reloaded
        Assert.assertEquals(itemsInCart,Integer.parseInt(driver.findElement(itemsInCartIcon).getText()));
        return this;
    }

    public MainPage returnToHomePage(){
        waitForElementIsVisible(homeIcon);
        driver.findElement(homeIcon).click();
        return new MainPage(driver);
    }

}
