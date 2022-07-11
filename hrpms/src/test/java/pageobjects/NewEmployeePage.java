package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class NewEmployeePage {
    @FindBy (how = How.ID, using = "employeeCode")
    WebElement enterEmployeeIDBox;
    @FindBy (how = How.ID, using = "employeeType")
    WebElement enterEmployeeTypeBox;
    @FindBy (how = How.ID, using = "nameEnglish")
    WebElement enterEmployeeNameBox;
    @FindBy (how = How.ID, using = "motherNameEnglish")
    WebElement enterEmployeeMotherNameBox;
    @FindBy (how = How.ID, using = "fatherNameEnglish")
    WebElement enterEmployeeFatherNameBox;
    @FindBy (how = How.ID, using = "nationality")
    WebElement enterEmployeeNationalityBox;
    @FindBy (how = How.ID, using = "dateOfBirth")
    WebElement enterEmployeeDateOfBirthBox;
    @FindBy (how = How.XPATH, using = "//*[@id=\"ui-datepicker-div\"]/div/div/select[1]")
    WebElement dobMonthSelector;
    @FindBy (how = How.XPATH, using = "//*[@id=\"ui-datepicker-div\"]/div/div/select[2]")
    WebElement dobYearSelector;
    @FindBy (how = How.CSS, using = ".ui-state-default")
    public List<WebElement> dobDateSelector;
    @FindBy (how = How.ID, using = "birthPlace")
    WebElement enterEmployeePlaceOfBirthBox;
    @FindBy (how = How.ID, using = "religion")
    WebElement enterEmployeeReligionBox;
    @FindBy (how = How.ID, using = "emailAddress")
    WebElement enterEmployeeEmailOfficeBox;
    @FindBy (how = How.ID, using = "mobileNumberOffice")
    WebElement enterEmployeeMobileNumberOfficeBox;
    @FindBy (how = How.ID, using = "joiningDateGovtService")
    WebElement enterEmployeeDateOfJoiningBox;
    @FindBy (how = How.CSS, using = ".ui-state-default")
    public List<WebElement> joinDateSelector;
    @FindBy (how = How.ID, using = "gender")
    WebElement enterEmployeeGenderBox;
    @FindBy (how = How.ID, using = "emailAddressPersonal")
    WebElement enterEmployeeEmailPersonalBox;
    @FindBy (how = How.ID, using = "mobileNumberPersonal")
    WebElement enterEmployeeMobileNumberPersonalBox;
    @FindBy (how = How.XPATH, using = "//*[@id=\"infoCreateForm\"]/button")
    WebElement saveButton;
    @FindBy (how = How.XPATH, using = "//*[@id=\"content\"]/div/div[2]/div/div[1]/div[2]/h6")
    WebElement confirmAccountCreation;
    @FindBy (how = How.XPATH, using = "//*[@id=\"infoCreateForm\"]/div[1]/ul/li")
    WebElement duplicateAccountIDError;

    public void typeAllInfoInBox() {
        enterEmployeeIDBox.sendKeys("100001");
        enterEmployeeNameBox.sendKeys("Dwayne Johnson");
        enterEmployeeMotherNameBox.sendKeys("Ata Johnson");
        enterEmployeeFatherNameBox.sendKeys("Rocky Johnson");
        enterEmployeeEmailOfficeBox.sendKeys("dwaynetherockjohnson@rockmail.com");
        enterEmployeeEmailPersonalBox.sendKeys("dwaynejohnson@gmail.com");
        enterEmployeeMobileNumberOfficeBox.sendKeys("+12342345678");
        enterEmployeeMobileNumberPersonalBox.sendKeys("+17897891234");
    }
    public void selectAllDropdowns() {
        Select empType = new Select(enterEmployeeTypeBox);
        empType.selectByVisibleText("other");
        Select empNationality = new Select(enterEmployeeNationalityBox);
        empNationality.selectByVisibleText("Foreigner");
        Select empPlace = new Select(enterEmployeePlaceOfBirthBox);
        empPlace.selectByVisibleText("Dhaka");
        Select empReligion = new Select(enterEmployeeReligionBox);
        empReligion.selectByVisibleText("Christianity");
        Select empGender = new Select(enterEmployeeGenderBox);
        empGender.selectByVisibleText("Male");
    }
    public void selectAllDates() {
        enterEmployeeDateOfBirthBox.click();
        Select dobMonth = new Select(dobMonthSelector);
        dobMonth.selectByVisibleText("May");
        Select dobYear = new Select(dobYearSelector);
        dobYear.selectByVisibleText("1972");
        List<WebElement> dobDates = dobDateSelector;
        for(int i=0; i<dobDateSelector.size(); i++) {
            String date = dobDateSelector.get(i).getText();
            if(date.equalsIgnoreCase("2")) {
                dobDateSelector.get(i).click();
                break;
            }
        }
        enterEmployeeDateOfJoiningBox.click();
        List<WebElement> dateOfJoining = joinDateSelector;
        for(int i=0; i<joinDateSelector.size(); i++) {
            String joinDate = joinDateSelector.get(i).getText();
            if(joinDate.equalsIgnoreCase("20")) {
                joinDateSelector.get(i).click();
            }
        }
    }
    public void saveInfo() {
        saveButton.click();
    }
    public String assertCreationOfEmployee() {
        String accountCreationText = confirmAccountCreation.getText();
        return accountCreationText;
    }
    public String duplicateAccountMessage() {
        String duplicateText = duplicateAccountIDError.getText();
        return duplicateText;
    }

}
