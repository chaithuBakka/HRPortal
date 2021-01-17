package com.or.hr.steps;

import com.or.hr.utils.PropMgr;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseSteps {
    static PropMgr propMgr;
    static WebDriver driver;

    static {
        propMgr= new PropMgr();
        System.setProperty("webdriver.chrome.driver",propMgr.getDriverPath());
        driver = new ChromeDriver();
    }
}
