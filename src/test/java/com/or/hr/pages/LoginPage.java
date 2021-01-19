package com.or.hr.pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "/html/body/h2")
    WebElement pageTitle;

    @FindBy(xpath = "/html/body/h3")
    WebElement pageHeader;

    @FindBy(name = "username")
    WebElement userName;

    @FindBy(xpath = "//input[@id='password-input' and @name='password']") // more than one element needed for identification
    WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement loginBtn;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void validatePageElements(){
        pageTitle.isDisplayed();
        pageHeader.isDisplayed();
        userName.isDisplayed();
        password.isDisplayed();
        loginBtn.isDisplayed();
    }

    public void enterUserName(String name){
        userName.clear();
        userName.sendKeys(name);
        userName.sendKeys(Keys.TAB);
    }

    public String getUserName(){
        String text = userName.getAttribute("value");
        return text;
    }

    public void enterPassword(String pwd){
        password.clear();
        password.sendKeys(pwd);
    }

    public void clickLoginBtn(){
        loginBtn.isEnabled();
        loginBtn.click();
    }






}
