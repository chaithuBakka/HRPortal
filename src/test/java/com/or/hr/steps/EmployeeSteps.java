package com.or.hr.steps;

import com.or.hr.pages.EmployeePage;
import io.cucumber.java.en.*;
import org.testng.Assert;

import java.util.List;

public class EmployeeSteps extends BaseSteps {

    EmployeePage employeePage;

    public  EmployeeSteps(){
        employeePage = new EmployeePage(driver);
    }

    @Then("employees table should not be empty")
    public void employees_table_should_not_be_empty() {
        int tableSize = employeePage.getNumEmployees();
        Assert.assertTrue(tableSize > 0, "Employee table should not be empty");
    }

    @Then("employee names should match search value {string}")
    public void employee_names_should_match_search_value(String searchValue) {
        // Compare names in after converting them to lowercase
        String searchValueLC = searchValue.toLowerCase();
        List<String> empNames = employeePage.getEmployeeNames();
        boolean match = true;
        for (String empName: empNames) {
            String empNameLC = empName.toLowerCase();
            if (!empNameLC.contains(searchValueLC)) {
                match = false;
            }
        }
        Assert.assertTrue(match, "Employee names in result table should match search value");
    }

    @Then("Select the radio button of the given employee {string}")
    public void select_the_radio_button_of_the_given_employee(String empName) {
        List<String> empNames = employeePage.getEmployeeNames();
        int empIndex = empNames.indexOf(empName);
        employeePage.selectEmployee(empIndex);
    }

    @Then("Click employee details")
    public void click_employee_details() {
        employeePage.clickEmployeeDetails();
        Assert.assertEquals("HR Portal - Employee", driver.getTitle());
    }
}
