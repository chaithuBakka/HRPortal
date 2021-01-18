package com.or.hr.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class EmployeePage extends BasePage {

   @FindBy(id = "employee-select-submit")
    WebElement employeeDetailsSearch;



    public EmployeePage(WebDriver driver) {
        super(driver);
    }

    public int getNumEmployees() {
        List rows = driver.findElements(By.xpath("//*[@id='employee-select-form']/table/tbody/tr"));
        int numRows = rows.size();
        return numRows - 1;
    }


    public List<String> getDepartments() {
        List<WebElement> departments = driver.findElements(By.xpath("//*[@id='employee-select-form']/table/tbody/tr/td[4]"));
        List<String> departmentNames = new ArrayList<>();
        for (WebElement department: departments) {
            String departmentName = department.getText();
            departmentNames.add(departmentName);
        }
        return departmentNames;
    }

    public List<String> getEmployeeNames() {
        List<WebElement> employees = driver.findElements(By.xpath("//*[@id='employee-select-form']/table/tbody/tr/td[3]"));
        List<String> employeeNames = new ArrayList<>();
        for (WebElement employee : employees) {
            String employeeName = employee.getText();
            employeeNames.add(employeeName);
        }
        return employeeNames;
    }

    public void selectEmployee(int index) {
        // XPath indexing starts with 1 and also skip header row
        int empXpathIndex = index + 1 + 1;
        WebElement radioBtn = driver.findElement(By.xpath("//*[@id='employee-select-form']/table/tbody/tr[" + empXpathIndex + "]/td[1]/input"));
        radioBtn.click();
    }


    public void clickEmployeeDetails(){
        employeeDetailsSearch.click();
    }
}
