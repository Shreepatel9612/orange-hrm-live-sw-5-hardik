package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.excelutility.ExcelUtility;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class UserTest extends BaseTest {
    public static final String FILE_PATH = System.getProperty("user.dir") + "/src/test/java/resources/testdata/ExcelRead.xlsx";
    @BeforeClass
    public void getExcel(){
        try {


            //Tell the code about the location of the excel file
            ExcelUtility.setExcelFile(FILE_PATH, "UserTest");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    @DataProvider(name = "dataFromExcel")
    public Object[][] getData(){
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


    @Test(groups = "smoke")

    public void adminShouldAddUserSuccessFully() {


        //Login to Application
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();


        // Navigate to Admin and add a user
        homePage.clickAdminTab();
        Assert.assertEquals(viewSystemUsersPage.getSystemUsersText(), "System Users");

        //click On "Add" button
        viewSystemUsersPage.clickAddButton();

        // Verify "Add User" Text
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.titleContains("Add User"));
//        Assert.assertTrue(Objects.requireNonNull(driver.getTitle()).contains("Add User"));
        Assert.assertEquals(addUserPage.getAddUserText(), "Add User");

        WebElement dropdown = driver.findElement(By.xpath("//div[@class='dropdown']"));
        dropdown.click();
        addUserPage.enterEmployeeName("Ananya Dash");
        addUserPage.enterUsername("AnanyaD123");
        addUserPage.selectStatus("Disable");
        addUserPage.enterPassword("Test@123");
        addUserPage.enterConfirmPassword("Test@123");
        addUserPage.clickOnSaveButton();

        // Verify success message


        //pending

    }

    @Test(groups = {"smoke", "sanity", "regression"})
    public void searchTheUserCreatedAndVerifyIt(String username, String userRole, String employeeName, String status) {

        //Login to Application
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();
        //click On "Admin" Tab
        homePage.clickAdminTab();
        //Verify "System Users" Text
        Assert.assertEquals(viewSystemUsersPage.getSystemUsersText(), "System Users");

        viewSystemUsersPage.enterUsername(username);
        viewSystemUsersPage.selectUserRole(userRole);
        viewSystemUsersPage.selectStatus(status);
        viewSystemUsersPage.clickSearchButton();

        // Verify the user is in the result list
        Assert.assertTrue(driver.getPageSource().contains(username));
    }

    @Test(groups = { "sanity", "regression"})
    public void verifyThatAdminShouldDeleteTheUserSuccessfully() {

        //Login to Application
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();

        //click On "Admin" Tab
        homePage.clickAdminTab();
        //Verify "System Users" Text
        Assert.assertEquals(viewSystemUsersPage.getSystemUsersText(), "System Users");

        // Use username of the user created above
        viewSystemUsersPage.enterUsername("AnanyaD123");
        viewSystemUsersPage.selectUserRole("Admin");
        viewSystemUsersPage.selectStatus("Disable");
        viewSystemUsersPage.clickSearchButton();

        // Verify the user is in the result list
        Assert.assertTrue(driver.getPageSource().contains("AnanyaD123"));

        viewSystemUsersPage.clickCheckBox("AnanyaD123");
        viewSystemUsersPage.clickDeleteButton();
        viewSystemUsersPage.clickOkButtonInPopup();

        //verify message "Successfully Deleted"


    }
    @Test(dataProvider = "dataFromExcel" , dataProviderClass = TestData.class ,groups = { "smoke","sanity", "regression"})
    public void searchTheUserAndVerifyTheMessageRecordFound(String username, String userRole, String employeeName, String status){

        //Login to Application
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();

        //click On "Admin" Tab
        homePage.clickAdminTab();
        //Verify "System Users" Text
        Assert.assertEquals(viewSystemUsersPage.getSystemUsersText(), "System Users");

        viewSystemUsersPage.enterUsername(username);
        viewSystemUsersPage.selectUserRole(userRole);
        viewSystemUsersPage.enterEmployeeName(employeeName);
        viewSystemUsersPage.selectStatus(status);
        viewSystemUsersPage.clickSearchButton();
        Assert.assertEquals(viewSystemUsersPage.getRecordText(),"(1) Record Found");
        Assert.assertTrue(driver.getPageSource().contains(username));

        viewSystemUsersPage.clickResetButton();



    }


}






















