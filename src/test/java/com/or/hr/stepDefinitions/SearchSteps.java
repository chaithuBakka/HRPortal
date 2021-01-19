package com.or.hr.stepDefinitions;

import com.or.hr.pages.SearchPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SearchSteps extends BaseSteps {
    SearchPage searchPage;

    public SearchSteps() {
        searchPage = new SearchPage(driver);
    }


    @Then("User enters employeeName as {string} and department Id as {string}")
    public void user_enters_employee_name_as_and_department_id_as(String empName, String DepartmentId) {
        Assert.assertNotNull(empName, "employeeName is empty");
        searchPage.enterEmployeeName(empName);
        Assert.assertNotNull(DepartmentId, "id is empty");
        searchPage.setDepartment(DepartmentId);
    }

    @And("Click on search btn")
    public void click_on_search_btn(){
        searchPage.clickSearchBtn();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleContains("HR Portal - Employees"));
        String empTitle = driver.getTitle();
        Assert.assertEquals("HR Portal - Employees", driver.getTitle());
    }

}
