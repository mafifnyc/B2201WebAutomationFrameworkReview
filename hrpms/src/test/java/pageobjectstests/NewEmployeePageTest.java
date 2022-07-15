package pageobjectstests;

import browserdriver.BrowserDriver;
import excelreader.MyDataReader;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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
    @DataProvider
    public Object[][] dataProvider() throws Exception {
        MyDataReader myDataReader = new MyDataReader();
        String filePath = "C:\\Users\\QAAEB2201\\IdeaProjects\\B2201WebAutomationFrameworkReview\\hrpms\\testData\\empData.xlsx";
        myDataReader.setExcelFile(filePath);
        Object[][] data = myDataReader.getExcelSheetData("Sheet1");
        return data;
    }
    @Test (dataProvider = "dataProvider")
    public void newEmployeeCreationTest(String empID, String empName, String motherName, String fatherName, String emailOffice, String emailPersonal, String mobileNumberOffice, String mobileNumberPersonal) {
        loginPage.enterCredsAndLogin();
        homePage.createNewEmployee();
        newEmployeePage.typeAllInfoInBox(empID, empName, motherName, fatherName, emailOffice, emailPersonal, mobileNumberOffice, mobileNumberPersonal);
        newEmployeePage.selectAllDropdowns();
        newEmployeePage.selectAllDates();
        newEmployeePage.saveInfo();
        Assert.assertEquals(newEmployeePage.duplicateAccountMessage(), "This Code Already Taken");
    }
}
// //*[@id="infoCreateForm"]/div[1]/ul/li