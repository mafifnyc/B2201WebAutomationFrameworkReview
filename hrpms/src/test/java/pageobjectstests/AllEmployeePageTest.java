package pageobjectstests;

import browserdriver.BrowserDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.AllEmployeePage;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class AllEmployeePageTest extends BrowserDriver {
    LoginPage loginPage = null;
    HomePage homePage = null;
    AllEmployeePage allEmployeePage = null;

    @BeforeMethod
    public void initializeElements() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        homePage = PageFactory.initElements(driver, HomePage.class);
        allEmployeePage = PageFactory.initElements(driver, AllEmployeePage.class);
    }
    @Test
    public void findParticularEmployeeTest() {
        loginPage.enterCredsAndLogin();
        homePage.getAllEmployeeListFromPIMS();
        allEmployeePage.searchForCurrentEmployee();
        Assert.assertEquals(allEmployeePage.assertEmployeeNotFound(), "No matching records found");
    }
}
