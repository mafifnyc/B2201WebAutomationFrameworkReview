package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
    @FindBy (how = How.ID, using = "Setting_PIMS")
    WebElement pIMSDropdown;
    @FindBy (how = How.LINK_TEXT, using = "All Employee")
    WebElement allEmployeeList;
    @FindBy (how = How.XPATH, using = "//h6[contains(text(),\"Employee's Personal Information\")]") // //h6[contains(text(),"Employee's Personal Information")]
    WebElement allEmployeeHeader;
    @FindBy (how = How.LINK_TEXT, using = "New Employee")
    WebElement newEmployeeCreation;

    public void getAllEmployeeListFromPIMS() {
        pIMSDropdown.click();
        allEmployeeList.click();
    }
    public String assertAllEmployeeListHeader() {
        String employeeListHeader = allEmployeeHeader.getText();
        return employeeListHeader;
    }
    public void createNewEmployee() {
        pIMSDropdown.click();
        newEmployeeCreation.click();

    }
}
