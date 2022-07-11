package pageobjectstests;

import browserdriver.BrowserDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.NewEmployeePage;

public class NewEmployeePageTest extends BrowserDriver {
    LoginPage loginPage = null;
    HomePage homePage = null;
    NewEmployeePage newEmployeePage = null;

    @BeforeMethod
    public void initializeElements() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        homePage = PageFactory.initElements(driver, HomePage.class);
        newEmployeePage = PageFactory.initElements(driver, NewEmployeePage.class);
    }
    @Test
    public void newEmployeeCreationTest() {
        loginPage.enterCredsAndLogin();
        homePage.createNewEmployee();
        newEmployeePage.typeAllInfoInBox();
        newEmployeePage.selectAllDropdowns();
        newEmployeePage.selectAllDates();
        newEmployeePage.saveInfo();
        Assert.assertEquals(newEmployeePage.duplicateAccountMessage(), "This Code Already Taken");
    }
}
// //*[@id="infoCreateForm"]/div[1]/ul/li