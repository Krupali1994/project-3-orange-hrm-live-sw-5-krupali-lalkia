package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestDate;

@Listeners(CustomListeners.class)
public class UsersTest extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;
    DashboardPage dashboardPage;
    ViewSystemUsersPage viewSystemUsersPage;
    AddUserPage addUsersPage;
    AdminPage adminPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
        homePage = new HomePage();
        dashboardPage = new DashboardPage();
        viewSystemUsersPage = new ViewSystemUsersPage();
        addUsersPage = new AddUserPage();
        adminPage = new AdminPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void adminShouldAddUserSuccessFully() {

        loginPage.loginToTheApplication("Admin", "admin123");
        homePage.clickOnAdminLink();
        String expectedSystemUsersMessage = "System Users";
        String actualSystemUsersMessage = viewSystemUsersPage.getSystemUsersText();
        Assert.assertEquals(actualSystemUsersMessage, expectedSystemUsersMessage);

        viewSystemUsersPage.clickOnAddButton();
        String expectedAddUsersMessage = "Add User";
        String actualAddUserMessage = addUsersPage.verifyAddUserText();
        Assert.assertEquals(actualAddUserMessage, expectedAddUsersMessage);

        addUsersPage.mouseHoverAndClickOnUserRoleDropDownInAddUser();
        addUsersPage.mouseHoverAndCLickOnAdminOptionInUserRoleDropDownInAddUser();
        addUsersPage.sendDataToEmployeeNameFieldInAddUser(" David Taylor");
        addUsersPage.sendDataToUserNameFieldInAddUser("Prime007");
        addUsersPage.clickOnStatusDropDownMenuInAddUser();
        addUsersPage.mouseHoverAndClickOnDisabledOptionInAddUser();
        addUsersPage.sendDataToPasswordFieldInAddUser("Prime123");
        addUsersPage.sendDataToConfirmPasswordFieldInAddUser("Prime123");
        addUsersPage.clickOnSaveButtonInAddUser();

        String expectedUserName = "Prime78";
        String actualUserName = viewSystemUsersPage.getDataFromUserNameInRecord();
        Assert.assertEquals(actualUserName, expectedUserName);

    }

    @Test(groups = {"smoke", "regression"})
    public void searchTheUserCreatedAndVerifyIt() {

        loginPage.loginToTheApplication("Admin", "admin123");
        homePage.clickOnAdminLink();

        String expectedSystemUsersMessage = "System Users";
        String actualSystemUsersMessage = viewSystemUsersPage.getSystemUsersText();
        Assert.assertEquals(actualSystemUsersMessage, expectedSystemUsersMessage);

        viewSystemUsersPage.sendDataToUserNameFieldInSystemUsers("Prime007");
        viewSystemUsersPage.clickOnUserRoleDropDownInSystemUsers();
        viewSystemUsersPage.mouseHoverAndClickOnAdminOptionInUserRoleDropDownInSystemUsers();
        viewSystemUsersPage.clickOnStatusDropDownInSystemUsers();
        viewSystemUsersPage.mouseHoverAndCLickOndDisableStatusOptionInSystemUsers();
        viewSystemUsersPage.clickOnSearchButtonInSystemUsers();

        String expectedUserName = "Prime007";
        String actualUserName = viewSystemUsersPage.getDataFromUserNameInRecord();
        Assert.assertEquals(actualUserName, expectedUserName);

    }


    @Test(dataProvider = "userDetails", dataProviderClass = TestDate.class, groups = {"regression"})
    public void verifyThatAdminShouldDeleteTheUserSuccessFully(String userName, String userRole, String eName, String status) {

        loginPage.loginToTheApplication("Admin", "admin123");
        homePage.clickOnAdminLink();

        String expectedSystemUsersMessage = "System Users";
        String actualSystemUsersMessage = viewSystemUsersPage.getSystemUsersText();
        Assert.assertEquals(actualSystemUsersMessage, expectedSystemUsersMessage);
        viewSystemUsersPage.searchUserDetails(userName, userRole, eName, status);

    }

    @Test(groups = {"regression"})
    public void searchTheUserAndVerifyTheMessageRecordFound() {

        loginPage.loginToTheApplication("Admin", "admin123");
        homePage.clickOnAdminLink();

        String actualText = adminPage.getSystemUserText();
        Assert.assertEquals(actualText, "System Users");

    }

}
