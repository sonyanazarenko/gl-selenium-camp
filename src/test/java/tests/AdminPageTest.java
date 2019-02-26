package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.AdminPage;

public class AdminPageTest extends BaseTest{
    AdminPage adminPage;

    @Test
    public void leftMenuNavigationTest() {
        adminPage = new AdminPage(driver);
        adminPage.logIntoAdmin();
        Assert.assertTrue(adminPage.headerIsPresent());
    }
}
