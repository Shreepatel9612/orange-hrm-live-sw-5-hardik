package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement usernameField;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//h5[normalize-space()='Login']")
    WebElement loginPanelText;

    @CacheLookup
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    WebElement errorMessage;


    public void enterUserName(String username) {
        sendTextToElement(usernameField, username);
        CustomListeners.test.log(Status.PASS,"Enter UserName " + username);
    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS,"Enter Password " + password);
    }

    public void clickLoginButton() {
        loginButton.click();
        CustomListeners.test.log(Status.PASS,"Click on LoginButton");
    }

   public boolean isLoginPanelDisplay(){
       CustomListeners.test.log(Status.PASS, "Logo is displayed");
        return loginPanelText.isDisplayed();

   }
   public String getErrorMessage(){
       CustomListeners.test.log(Status.PASS, "Get errorMessage");
        return getTextFromElement(errorMessage);


   }
}
