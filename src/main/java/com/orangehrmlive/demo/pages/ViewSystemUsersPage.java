package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ViewSystemUsersPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h5[normalize-space()='System Users']")
    WebElement systemUsersText;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='(1) Record Found']")
    WebElement recordText;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
    WebElement userNameField;

    @CacheLookup
    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]")
    WebElement userRoleDropdown;


    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeNameField;

    @CacheLookup
    @FindBy(xpath ="//body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div")
    WebElement statusRole;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Search']")
    WebElement searchButton;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Reset']")
    WebElement resetButton;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement addButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-toast-content oxd-toast-content--success']")
    WebElement successMessage;

    @CacheLookup
    @FindBy(xpath = "(//input[@type = 'checkbox'])[4]")
    WebElement checkBox;

    @CacheLookup
    @FindBy(xpath = " (//i[@class='oxd-icon bi-trash'])[4]")
    WebElement deleteButton;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Yes, Delete']")
    WebElement okButtonInPopup;

    @CacheLookup
    @FindBy(xpath = "//div[@id = 'oxd-text.oxd-text--p.oxd-text--toast-message.oxd-toast-content-text']")
    WebElement deleteMessage;

    public String getSystemUsersText(){
        return systemUsersText.getText();
    }

    public String getRecordText(){
        return recordText.getText();
    }

    public void enterUsername(String username){
        userNameField.sendKeys(username);
    }

    public void selectUserRole(String role) {
        selectByVisibleTextFromDropDown(userRoleDropdown,role);

    }

    public void enterEmployeeName(String employeeName) {
        employeeNameField.sendKeys(employeeName);
    }

    public void selectStatus(String status) {
        selectByVisibleTextFromDropDown(statusRole,status);

    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickResetButton() {
        resetButton.click();
    }

    public void clickAddButton() {
        addButton.click();
    }

    public void clickCheckBox(String username) {
        sendTextToElement(checkBox,username);

    }

    public void clickDeleteButton() {
        deleteButton.click();
    }

    public void clickOkButtonInPopup(){
        okButtonInPopup.click();
    }

    public String verifySuccessfullySavedMessage(){
        return getTextFromElement(successMessage);
    }


}
