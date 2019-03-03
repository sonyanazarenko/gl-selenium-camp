package tests;

import org.junit.Test;
import pages.AdminPage;
import pages.MainPage;

public class AdminAddNewProductTest extends BaseTest {
    AdminPage adminPage;
    MainPage mainPage;
    String productName = "Total Purple Duck";

    @Test
    public void addNewProductTest() {
        adminPage = new AdminPage(driver);
        adminPage.logIntoAdmin()
                .addProduct(productName);
        mainPage = new MainPage(driver);
        mainPage.selectProductByName(productName)
                .addProductToCart()
                .verifyItemsInCartIncreased()
                .returnToHomePage();
        mainPage.selectProduct()
                .addProductToCart()
                .verifyItemsInCartIncreased()
                .checkout()
                .removeAllItemsFromCart();
    }
}
