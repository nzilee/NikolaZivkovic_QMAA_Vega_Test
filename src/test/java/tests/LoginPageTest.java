package tests;

import Base.BaseTest;
import Constants.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test (priority = 100)
    public void validLoginTest() {
        loginPage.performLogin(Constants.USERNAME, Constants.PASSWORD);

        String currentURL = page.url();
        Assert.assertTrue(currentURL.contains("inventory.html"), "Login failed!");
    }

    @Test (priority = 200)
    public void lockedOutLoginTest() {
        page.navigate(Constants.URL);
        loginPage.performLogin(Constants.LOCKED_OUT_USERNAME, Constants.PASSWORD);
        Assert.assertTrue(loginPage.isErrorContains("user has been locked out."));
    }


}
