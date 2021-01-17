package com.or.hr.steps;

import com.or.hr.pages.LoginPage;

public class LoginSteps extends BaseSteps {
    LoginPage loginPage;

    public LoginSteps() {
        loginPage = new LoginPage(driver);
    }
}
