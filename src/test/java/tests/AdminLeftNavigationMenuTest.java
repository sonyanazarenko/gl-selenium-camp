package tests;

import org.junit.Test;
import pages.AdminPage;

public class AdminLeftNavigationMenuTest extends BaseTest{
    AdminPage adminPage;

    @Test
    public void leftMenuNavigationTest() {
        adminPage = new AdminPage(driver);
        adminPage.logIntoAdmin().headerIsPresent();
    }
}
