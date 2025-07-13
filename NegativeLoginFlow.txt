package com.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class NegativeLoginFlow {
    public static void main(String[] args) {
        //Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //Set implicit wait and maximize browser window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        try {
            //Navigate to the SauceDemo login page
            driver.get("https://www.saucedemo.com");

            //Enter locked out user credentials
            driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            //Capture and verify the error message
            WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
            String errorText = errorMessage.getText();
            String expectedError = "Epic sadface: Sorry, this user has been locked out.";

            if (expectedError.equals(errorText)) {
                System.out.println("✅ Error message verified successfully.");
            } else {
                System.out.println("❌ Unexpected error message:");
                System.out.println("Expected: " + expectedError);
                System.out.println("Actual: " + errorText);
            }

        } catch (Exception e) {
            System.out.println("❌ Exception occurred during test execution:");
            e.printStackTrace();
        } finally {
            //Close the browser
            driver.quit();
        }
    }
}
