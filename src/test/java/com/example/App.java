package com.example;


import org.testng.Assert;
import org.testng.annotations.Test;

public class App extends Driver {
    @Test
    public void main() {
        driver.get("https://www.google.com");
        wait(2);
        takeScreenshot();
        driver.quit();
        Assert.assertTrue(true);
    }
}
