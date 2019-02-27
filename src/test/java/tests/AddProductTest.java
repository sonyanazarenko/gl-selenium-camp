package tests;

import org.junit.Test;
import pages.MainPage;


public class AddProductTest extends BaseTest {
    MainPage mainPage;

    @Test
    public void addProductToCartTest() {
        mainPage = new MainPage(driver);
        mainPage.selectProduct()
                .addProductToCart()
                .verifyItemsInCartIncreased()
                .returnToHomePage();
    }
}
