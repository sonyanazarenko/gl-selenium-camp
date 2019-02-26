package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage extends BasePage {
    private By LoginField = By.name("username");
    private By PasswordField = By.name("password");
    private By LoginButton = By.name("login");

    private By AppearenceTab = By.xpath("//span[@class='name'][text()='Appearence']");
    private By CatalogTab = By.xpath("//span[@class='name'][text()='Catalog']");
    private By CountriesTab = By.xpath("//span[@class='name'][text()='Countries']");
    private By CurrenciesTab = By.xpath("//span[@class='name'][text()='Currencies']");
    private By CustomersTab = By.xpath("//span[@class='name'][text()='Customers']");
    private By GeoZonesTab = By.xpath("//span[@class='name'][text()='GeoZones']");
    private By LanguagesTab = By.xpath("//span[@class='name'][text()='Languages']");
    private By ModulesTab = By.xpath("//span[@class='name'][text()='Modules']");
    private By OrdersTab = By.xpath("//span[@class='name'][text()='Orders']");
    private By PagesTab = By.xpath("//span[@class='name'][text()='Pages']");
    private By ReportsTab = By.xpath("//span[@class='name'][text()='Reports']");
    private By SettingsTab = By.xpath("//span[@class='name'][text()='Settings']");
    private By SlidesTab = By.xpath("//span[@class='name'][text()='Slides']");
    private By TaxTab = By.xpath("//span[@class='name'][text()='Tax']");
    private By TranslationsTab = By.xpath("//span[@class='name'][text()='Translations']");
    private By UsersTab = By.xpath("//span[@class='name'][text()='Users']");
    private By vQmodsTab = By.xpath("//span[@class='name'][text()='vQmods']");

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    public AdminPage logIntoAdmin(){
        AdminPage adminPage = new AdminPage(driver);
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(LoginField).sendKeys("admin");
        driver.findElement(PasswordField).sendKeys("admin");
        driver.findElement(LoginButton).click();
        return adminPage;
    }

    public boolean headerIsPresent(){
        waitForElementIsVisible(AppearenceTab);
        driver.findElement(AppearenceTab).click();
        return driver.findElement(By.xpath("//h1")).isDisplayed();
    }
}
