package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

public class AdminPage extends BasePage {
    int oldItemsQuantity;
    int newItemsQuantity;

    private By loginField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.name("login");
    private By catalogTab = By.xpath("//span[contains(text(),'Catalog')]");
    private By addNewProductButton = By.xpath("//a[contains(text(),'Add New Product')]");
    private By generalTab = By.xpath("//a[contains(text(),'General')]");
    private By nameField = By.xpath("//input[@name='name[en]']");
    private By rubberDucksCheckbox = By.xpath("//input[@data-name='Rubber Ducks']");
    private By category = By.xpath("//select[@name='default_category_id']");
    private By quantity = By.xpath("//input[@name='quantity']");
    private By uploadImage = By.xpath("//input[@name='new_images[]']");
    private By informationTab = By.xpath("//a[contains(text(),'Information')]");
    private By pricesTab = By.xpath("//a[contains(text(),'Prices')]");
    private By productManufacturer = By.xpath("//select[@name='manufacturer_id']");
    private By purchasePrice = By.xpath("//input[@name='purchase_price']");
    private By save = By.xpath("//button[@name='save']");
    private By items = By.xpath("//input[starts-with(@name,'products')]");
    private By enable = By.xpath("//button[@name='enable']");

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public AdminPage logIntoAdmin() {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(loginField).sendKeys("admin");
        driver.findElement(passwordField).sendKeys("admin");
        driver.findElement(loginButton).click();
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

    public AdminPage addProduct(String productName){
        driver.findElement(catalogTab).click();
        oldItemsQuantity = driver.findElements(items).size();
        driver.findElement(addNewProductButton).click();
        driver.findElement(generalTab).click();
        driver.findElement(nameField).sendKeys(productName);
        driver.findElement(rubberDucksCheckbox).click();
        Select dropdown = new Select(driver.findElement(category));
        dropdown.selectByVisibleText("Rubber Ducks");
        driver.findElement(quantity).sendKeys("10");
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("productPicture/ducky.png").getFile());
        driver.findElement(uploadImage).sendKeys(file.getAbsolutePath());
        driver.findElement(informationTab).click();
        Select manufacturer = new Select(driver.findElement(productManufacturer));
        manufacturer.selectByIndex(1);
        driver.findElement(pricesTab).click();
        driver.findElement(purchasePrice).sendKeys("13");
        driver.findElement(save).click();
        List<WebElement> newProducts = driver.findElements(items);
        newItemsQuantity = newProducts.size();
        for(WebElement e: newProducts) {
            e.click();
        }
        driver.findElement(enable).click();
        Assert.assertTrue(newItemsQuantity==oldItemsQuantity+1);
        return this;
    }
}
