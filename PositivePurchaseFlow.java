package com.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class PositivePurchaseFlow {
    public static void main(String[] args) {
        // Automatically manage the ChromeDriver binary
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        try {
            //Open SauceDemo
            driver.get("https://www.saucedemo.com");

            //Login
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            //Add a product
            driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

            //Open the cart
            driver.findElement(By.className("shopping_cart_link")).click();

            //Proceed to checkout
            driver.findElement(By.id("checkout")).click();

            //Enter customer info
            driver.findElement(By.id("first-name")).sendKeys("John");
            driver.findElement(By.id("last-name")).sendKeys("Doe");
            driver.findElement(By.id("postal-code")).sendKeys("12345");
            driver.findElement(By.id("continue")).click();

            // Step 7: Finish the purchase
            driver.findElement(By.id("finish")).click();

            //Verify confirmation message
            WebElement confirmation = driver.findElement(By.className("complete-header"));
            String confirmationText = confirmation.getText();

            if ("Thank you for your order!".equals(confirmationText)) {
                System.out.println("✅ Purchase order completed successfully.");
            } else {
                System.out.println("❌ Purchase confirmation message not found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
