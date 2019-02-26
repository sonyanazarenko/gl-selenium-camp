package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.MainPage;
import pages.ProductPage;


public class AddProductTest extends BaseTest{
    MainPage mainPage;
    ProductPage productPage;

    @Test
    public void addProductToCartTest() {
        mainPage = new MainPage(driver);
        mainPage.selectProduct();
    }
}
