package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
    @FindBy (how = How.ID, using = "exampleInputEmail")
    WebElement emailInputLoginBox;
    @FindBy (how = How.ID, using = "exampleInputPassword")
    WebElement passwordInputLoginBox;
    @FindBy (how = How.XPATH, using = "//label[contains(text(),'Remember Me')]")
    WebElement rememeberMeCheckBox;
    @FindBy (how = How.XPATH, using = "//button[contains(text(),'Login')]")
    WebElement loginButton;
    @FindBy (how = How.XPATH, using = "/html/body/nav/span")
    WebElement hrpmsTitle;

    public void enterCredsAndLogin() {
        emailInputLoginBox.sendKeys("mafifnyc");
        passwordInputLoginBox.sendKeys("123456");
        rememeberMeCheckBox.click();
        loginButton.click();
    }
    public String getTitle() {
        String title = hrpmsTitle.getText();
        return title;
    }
}
