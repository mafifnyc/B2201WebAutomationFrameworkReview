package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AllEmployeePage {
    @FindBy (how = How.XPATH, using = "//*[@id=\"allEmployeeListTable_filter\"]/label/input")
    WebElement employeeSearchBox;
    @FindBy (how = How.XPATH, using = "//td[contains(text(),'No matching records found')]")
    WebElement textInsideEmployeeList;
    @FindBy (how = How.XPATH, using = "//*[@id=\"allEmployeeListTable\"]/tbody/tr/td[2]")
    WebElement nameInsideEmployeeList;

    public void searchForCurrentEmployee() {
        employeeSearchBox.sendKeys("Dwayne 'TheRock' Johnson");
    }
    public String assertEmployeeNotFound() {
        String employeeNotFound = textInsideEmployeeList.getText();
        return employeeNotFound;
    }
    public String assertEmployeeFound() {
        String employeeFound = nameInsideEmployeeList.getText();
        return employeeFound;
    }
}
