package com.or.hr.stepDefinitions;
import io.cucumber.java.After;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonSteps extends BaseSteps {

    static {
        driver = new ChromeDriver();
    }

    @After
    public void close_browser() {
       //driver.close();
       //driver.quit();
    }

}
