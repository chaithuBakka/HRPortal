package com.or.hr.pages;

import io.cucumber.java.en.Then;
import javafx.concurrent.Task;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.Console;
import java.util.List;

public class SearchPage extends BasePage {

    @FindBy(xpath = "/html/body/h2")
    WebElement searchPageTitle;

    @FindBy(xpath = "/html/body/h3")
    WebElement searchPageHeader;

    @FindBy(name = "empname")
    WebElement employerName;

    @FindBy(className = "departments")
    WebElement department;

    @FindBy(xpath = "//input[@id='search-submit']")
    WebElement searchBtn;


    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void validateSearchPageElements(){
        searchPageTitle.isDisplayed();
        searchPageHeader.isDisplayed();
        employerName.isDisplayed();
        department.isDisplayed();
        searchBtn.isDisplayed();
    }

    public void enterEmployeeName(String empName){
        employerName.clear();
        employerName.sendKeys(empName);
    }

    public int getDepartmentsSize(){
        Select dropdown = new Select(department);
        return dropdown.getOptions().size();
    }

    public void setDepartment(String departmentId) {
        WebElement depDropDown = driver.findElement(By.id("departments-select"));
        Select dropDown = new Select(depDropDown);
        dropDown.selectByVisibleText(departmentId);
        String text = dropDown.getFirstSelectedOption().getText(); // its not advisable to right asserts in the page but as I dont want to do repation i am using here
        Assert.assertEquals(text,departmentId);
    }

    public void clickSearchBtn(){
        searchBtn.click();
    }


}
