package com.example;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Driver {
    public static WebDriver driver;

    public static WebDriver getDriver(String browser) {

        System.setProperty("webdriver.http.factory", "jdk-http-client");

        if (browser.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origin=*");

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        } else if (browser.equals("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--remote-allow-origin=*");

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(options);
        } else if (browser.equals("edge")) {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--remote-allow-origin=*");

            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver(options);
        }

//        System.setProperty("webdriver.chrome.driver", "D://Education//FSD//chromedriver-win32//chromedriver.exe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    public static void wait(WebDriver driver, int n) {
        try {
            Thread.sleep(n * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void takeScreenshot(WebDriver driver) {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(file, new File("D:/Education/FSD/Screenshots/screenshot1.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void explicitWait(WebDriver driver, String element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(5));
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
        System.out.println(element + "can be clickable");
    }
}
