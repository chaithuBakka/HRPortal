package com.or.hr.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.LocalDate;

public class EmployeeDetailsPage extends BasePage {

    public EmployeeDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//label[text()='Maria Anders']")
    WebElement employeeName;

    @FindBy(css = "input#employee-title")
    WebElement empTitle;

    @FindBy(name = "departments")
    WebElement depName;

    @FindBy(xpath = "//label[text()='12/10/2016']")
    WebElement empHireDate;

    @FindBy(xpath = "//label[text()='James Chadwik']")
    WebElement empManager;

    @FindBy(xpath = "//*[@id='employee-details-form']/input[2]")
    WebElement currentSalary;

    @FindBy(linkText = "Profile Link")
    WebElement empProfLink;

    @FindBy(xpath = "//input[3]")
    WebElement empSubmitBtn;

    @FindBy(css = "textarea#description-input")
    WebElement description;

    public void validateEmpDetailsPageElements() {
        employeeName.isDisplayed();
        empTitle.isDisplayed();
        depName.isDisplayed();
        empHireDate.isDisplayed();
        empManager.isDisplayed();
        currentSalary.isDisplayed();
        empProfLink.isDisplayed();
        empSubmitBtn.isDisplayed();
        description.isDisplayed();
    }

    public String getEmployeeName() {
        return employeeName.getText();
    }

    public String getJobTitle() {
        return empTitle.getAttribute("value");
    }

    public void enterNewTitle(String title) {
        empTitle.clear();
        empTitle.sendKeys(title);
    }

    public String getEmpCurrDep(){
        return depName.getText();
    }

    public void setEmpDeparName(String empDepartment){
        Select dropdown = new Select(depName);
        dropdown.selectByVisibleText(empDepartment);
        String text = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(text,empDepartment);
    }


    public LocalDate getHireDate(){
        return LocalDate.parse(empHireDate.getText());

    }

    public String getCurrentSalary() {
        return (currentSalary.getAttribute("value"));
    }

    public void setNewSalary(String sal) {
        currentSalary.clear();
        currentSalary.sendKeys(sal);
    }

    public void AddDescription(String des) {
        description.clear();
        description.sendKeys(des);
    }

    public void clickUpdateEmployeeBtn() {
        empSubmitBtn.click();
    }

}
