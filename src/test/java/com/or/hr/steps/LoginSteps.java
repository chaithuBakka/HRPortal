package com.or.hr.steps;

import com.or.hr.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.testng.Assert;

import java.util.List;

public class LoginSteps extends BaseSteps {
    LoginPage loginPage;

    public LoginSteps() {
        loginPage = new LoginPage(driver);
    }


    @Given("User Opens HRPortal in the browser {string}")
    public void user_opens_hr_portal_in_the_browser(String url) {
        String site = propMgr.getUrl(url);
        driver.get(site);
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

    @Then("Login should succeed")
    public void login_should_succeed() {
        Assert.assertEquals("HR Portal - Search", driver.getTitle() );
    }


}
