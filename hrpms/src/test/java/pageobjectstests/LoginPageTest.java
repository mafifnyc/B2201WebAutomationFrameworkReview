package pageobjectstests;

import browserdriver.BrowserDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.LoginPage;

public class LoginPageTest extends BrowserDriver {
    LoginPage loginPage = null;
    @BeforeMethod
    public void initializeElements() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Test
    public void loginTest() {
        loginPage.enterCredsAndLogin();
        Assert.assertEquals(loginPage.getTitle(), "Izaan Human Resource Management System");
    }
}
