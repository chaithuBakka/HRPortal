package com.or.hr.stepDefinitions;

import com.or.hr.pages.EmployeeDetailsPage;
import io.cucumber.java.en.*;
import org.testng.Assert;


public class EmployeeDetailsSteps extends BaseSteps {
    EmployeeDetailsPage employeeDetailsPage;

    public EmployeeDetailsSteps() {
        employeeDetailsPage = new EmployeeDetailsPage(driver);
    }

    @Then("validate the selected employee details on employeeDetails page {string} {string}")
    public void validate_the_selected_employee_details_on_employee_details_page(String empName,String jobTitle) {
        employeeDetailsPage.validateEmpDetailsPageElements();
        String employeeName = employeeDetailsPage.getEmployeeName();
        Assert.assertEquals(employeeName, empName, "employer name is not matching");
        String aJobTitle = employeeDetailsPage.getJobTitle();
        Assert.assertEquals(aJobTitle, jobTitle, "Jobtitle is not matching");
    }

    @Then("Update the Salary of the employee {string}")
    public void update_the_salary_of_the_employee(String updateSalary) {
        employeeDetailsPage.setNewSalary(updateSalary);
        String actualSalary = employeeDetailsPage.getCurrentSalary();
        Assert.assertEquals(actualSalary,updateSalary,"New updated salary is not updated in field");
    }

    @Then("Update the department name of employee to {string} and {string}")
    public void update_the_department_name_of_employee_to_and(String departmentId, String description) {
        employeeDetailsPage.setEmpDeparName(departmentId);
        employeeDetailsPage.AddDescription(description);
    }

    @Then("Click updateEmployee")
    public void click_update_employee() {
        employeeDetailsPage.clickUpdateEmployeeBtn();
    }

}
