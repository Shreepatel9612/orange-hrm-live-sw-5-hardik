package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AddUserPage extends Utility {

    @FindBy(xpath = "//h6[normalize-space()='Add User']")
    WebElement addUserText;


    // User Role Dropdown
    @CacheLookup
    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]")
    WebElement userRoleDropdown;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeNameField;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-form-row']//div[@class='oxd-grid-2 orangehrm-full-width-grid']//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
    WebElement enterUserName;

    // Status Dropdown
    @CacheLookup
    @FindBy(xpath ="//body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div" )
    WebElement statusRole;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
    WebElement passwordFields;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
    WebElement confirmPasswordField;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement saveButton;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    WebElement cancelButton;

    public String getAddUserText(){
        return addUserText.getText();
    }


    public void selectRoleAdmin(String key){


    }

    public void enterEmployeeName(String employeeName) {
        employeeNameField.sendKeys(employeeName);
    }

    public void enterUsername(String username) {
        enterUserName.sendKeys(username);
    }

    public void selectStatus(String status) {
        selectByVisibleTextFromDropDown(statusRole,status);

        // Add logic to select from dropdown based on text
    }

    public void enterPassword(String password) {
        passwordFields.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword){
        confirmPasswordField.sendKeys(confirmPassword);

    }

    public void clickOnSaveButton(){
        clickOnElement(saveButton);
    }

    public void clickOnCancelButton(){
        clickOnElement(cancelButton);
    }










}
