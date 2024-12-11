package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='User Management']")
    WebElement userManagementTab;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Job']")
    WebElement jobTab;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Organization']")
    WebElement organizationTab;

    public void clickOnUserManagementTab(){
        userManagementTab.click();
    }

    public void clickOnJobTab(){
        jobTab.click();
    }

    public void clickOnOrganizationTab(){
       organizationTab.click();
    }



}
