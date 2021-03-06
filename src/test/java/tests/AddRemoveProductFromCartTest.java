package tests;

import org.junit.Test;
import pages.MainPage;

public class AddRemoveProductFromCartTest extends BaseTest {
    MainPage mainPage;
    int numberOfItemsToAdd = 3;

    @Test
    public void addProductToCartTest() {
        mainPage = new MainPage(driver);
        for (int i = 0; i < numberOfItemsToAdd; i++) {
            mainPage.selectProduct()
                    .addProductToCart()
                    .verifyItemsInCartIncreased()
                    .returnToHomePage();
        }
        mainPage.selectProduct()
                .addProductToCart()
                .verifyItemsInCartIncreased()
                .checkout()
                .removeAllItemsFromCart();
    }
}
