package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]/span[1]" )
    WebElement clickOnAdmin;

    @CacheLookup
    @FindBy(xpath = "(//h5[normalize-space()='System Users'])[1]")
    WebElement verifySystemUserText;

    @CacheLookup
    @FindBy(xpath = "(//input[@class='oxd-input oxd-input--active'])[2]")
    WebElement userName1;

    @CacheLookup
    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]")
    WebElement userRole;

    @CacheLookup
    @FindBy(xpath = "(//input[@placeholder='Type for hints...'])[1]")
    WebElement employeeName;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-select-text oxd-select-text--active']//div[@class='oxd-select-text-input'][normalize-space()='-- Select --']")
    WebElement status;

    @CacheLookup
    @FindBy(xpath = "(//button[normalize-space()='Search'])[1]")
    WebElement searchButton;

    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Cheeku123')]")
    WebElement verifyTheResult;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-table-card-cell-checkbox']//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']")
    WebElement tickOnCheckbox;

    @CacheLookup
    @FindBy(xpath = "//i[@class='oxd-icon bi-trash']")
    WebElement clickOnDeleteButton;

    @CacheLookup
    @FindBy(xpath = ("(//div[@role='document'])[1]"))
    WebElement popUpWindow;

    @CacheLookup
    @FindBy(xpath = ("//button[normalize-space()='Yes, Delete']"))
    WebElement yesButton;

    public void clickOnAdmin(){
        clickOnElement(clickOnAdmin);
    }

    public String getSystemUserText(){
        String message = getTextFromElement(verifySystemUserText);
        CustomListeners.test.log(Status.PASS, "verify system user text");
        return message;
    }

    public void enterUserName1(String value){
        sendTextToElement(userName1, value);
    }

    public void selectUserRole(String value){
        selectByVisibleTextFromDropDown(userRole, value);
    }

    public void enterEmployeeName(String value){
        sendTextToElement(employeeName, value);
    }

    public void selectStatus(String value){
        selectByVisibleTextFromDropDown(status, value);
    }
    public void clickOnSearchButton(){
        clickOnElement(searchButton);
    }
    public String setVerifyTheResult() {
        return getTextFromElement(verifyTheResult);
    }
    public void setTickOnCheckbox(){
        clickOnElement(tickOnCheckbox);
    }
    public void setClickOnDeleteButton(){
        clickOnElement(clickOnDeleteButton);
    }
    public void verifyThePopUpWindowIsDisplayed() {
        verifyThatElementIsDisplayed(popUpWindow);
    }

    public void clickOnYesButton() {
        clickOnElement(yesButton);
    }

    public void addDetails(String username, String userRole, String employeeName, String Status){
        enterUserName1(username);
        selectUserRole(userRole);
        enterEmployeeName(employeeName);
        selectStatus(Status);
    }


}
