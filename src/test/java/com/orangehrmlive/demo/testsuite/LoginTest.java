package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.excelutility.ExcelUtility;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;
import resources.testdata.TestDataLogin;

@Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {

    public static final String FILE_PATH = System.getProperty("user.dir") + "/src/test/java/resources/testdata/ExcelRead.xlsx";
    @BeforeClass
    public void getExcel(){
        try {


            //Tell the code about the location of the excel file
            ExcelUtility.setExcelFile(FILE_PATH, "LoginTest");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    @DataProvider(name = "dataFromExcel")
    public Object[][] getInvalidLoginDataFromExcel(){
        return ExcelUtility.getTestData("Invalid_Login");

    }

    com.orangehrmlive.demo.pages.LoginPage loginPage;
    com.orangehrmlive.demo.pages.HomePage homePage;
    com.orangehrmlive.demo.pages.AdminPage adminPage;
    com.orangehrmlive.demo.pages.ViewSystemUsersPage viewSystemUsersPage;
    com.orangehrmlive.demo.pages.AddUserPage addUserPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new com.orangehrmlive.demo.pages.LoginPage();
        adminPage = new com.orangehrmlive.demo.pages.AdminPage();
        homePage = new com.orangehrmlive.demo.pages.HomePage();
        viewSystemUsersPage = new com.orangehrmlive.demo.pages.ViewSystemUsersPage();
        addUserPage = new com.orangehrmlive.demo.pages.AddUserPage();

    }

    @Test(groups = {"smoke", "sanity", "regression"})
    public void verifyUserShouldLoginSuccessFully() {

        //Login to Application
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();

        //verify welcome message
        Assert.assertTrue(homePage.isLogoDisplayed(), "Dashboard message not displayed");

    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatTheLogoDisplayOnHomePage() {
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();

        Assert.assertTrue(homePage.isLogoDisplayed(), "Logo is not displayed on the Home Page.");
    }

    @Test(groups = {"smoke", "sanity", "regression"})
    public void verifyUserShouldLogOutSuccessFully() {
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();


        homePage.selectLogOutOption();

        Assert.assertTrue(loginPage.isLoginPanelDisplay(), "Login Panel text is not displayed after logout.");
    }

    @Test(dataProvider = "dataFromExcel", dataProviderClass = TestDataLogin.class, groups = {"smoke", "sanity", "regression"})
    public void verifyErrorMessageWithInvalidCredentials() {
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();

        String expectedText = "Invalid credentials";
        String actualText = loginPage.getErrorMessage();
        Assert.assertEquals(actualText, expectedText, "Invalid Login");
    }


}


