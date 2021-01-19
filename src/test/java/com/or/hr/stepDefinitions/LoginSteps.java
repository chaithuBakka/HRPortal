package com.or.hr.stepDefinitions;

import com.or.hr.pages.LoginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginSteps extends BaseSteps {
    LoginPage loginPage;

    public LoginSteps() {
        loginPage = new LoginPage(driver);
    }


    @Given("User Opens HRPortal in the browser {string}")
    public void user_opens_hr_portal_in_the_browser(String url) {
        String site = propMgr.getUrl(url);
        driver.get(site);
        System.out.println("Current Url is:"+ driver.getCurrentUrl());
        Assert.assertEquals("HR Portal - Login page", driver.getTitle());
    }

    @When("User enters username as {string} and password as {string}")
    public void user_enters_username_as_and_password_as(String uname, String pwd) {
        loginPage.validatePageElements();
        Assert.assertNotNull(uname, "userName value is empty"); //ensuring userName is not coming as empty
        loginPage.enterUserName(uname);
        String actual = loginPage.getUserName();
        Assert.assertEquals(actual,uname);
        Assert.assertNotNull(pwd,"password value is empty");
        loginPage.enterPassword(pwd);
    }


    @When("User clicks Login button")
    public void user_clicks_login_button() {
        loginPage.clickLoginBtn();
    }

    //wait condition and also get title
    @Then("Login should succeed")
    public void login_should_succeed() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleContains("HR Portal - Search"));
        String searchPageTitle = driver.getTitle();
        Assert.assertEquals("HR Portal - Search", searchPageTitle );
    }

    @When("User should be displayed with error message")
    public void user_should_be_displayed_with_error_message() {
        System.out.println("Invalid password");
    }

}
