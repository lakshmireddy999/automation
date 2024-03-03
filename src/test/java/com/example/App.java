package com.example;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class App {
    @Test
    public void main() {

        WebDriver driver = Driver.getDriver("chrome");
        driver.get("https://www.google.com");
        Driver.wait(driver, 2);
//        Driver.takeScreenshot(driver);
        driver.quit();
        Assert.assertTrue(true);
    }
}
