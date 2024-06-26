package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class E_Locators2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        //Enter the URL
        driver.get("https://demo.nopcommerce.com/");
        // Register as a new user
        // Click on registration link
        Thread.sleep(3000);
        driver.findElement(By.className("ico-register")).click();
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/form/div[1]/div[2]/div[1]/label"));
        // Select Female from Radio button
        Thread.sleep(3000);
        driver.findElement(By.id("gender-male")).click();
        Thread.sleep(3000);
        //Find & Click on First Name holder
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/form/div[1]/div[2]/div[2]/label"));
        driver.findElement(By.id("FirstName")).sendKeys("Tom");
        driver.findElement(By.id("LastName")).sendKeys("Harry");
        Thread.sleep(3000);
        //Find and select date of birth place holder
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/form/div[1]/div[2]/div[4]/div/select[1]"));
        //Enter date, month, year
        Thread.sleep(3000);
        driver.findElement(By.name("DateOfBirthDay")).sendKeys("18");
        Thread.sleep(3000);
        driver.findElement(By.name("DateOfBirthMonth")).sendKeys("July");
        driver.findElement(By.name("DateOfBirthYear")).sendKeys("1989");
        Thread.sleep(3000);
        //Enter email address
        driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys("Tomharry1234@gmail.com");
        //Enter company name
        Thread.sleep(3000);
        driver.findElement(By.id("Company")).sendKeys("Dunelm Group");
        //uncheck Newsletter box
        driver.findElement(By.id("Newsletter")).click();

        //Enter password
        Thread.sleep(3000);
        driver.findElement(By.id("Password")).sendKeys("Weirdpassword!!!");
        //Confirm password
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Weirdpassword!!!");

        //Click on Register button
        Thread.sleep(3000);
        driver.findElement(By.id("register-button")).click();

        boolean isErrorMessagePresent = false;
        //isErrorMessagePresent is set to true if the error message element is found and displayed;
        // otherwise, it remains false.
        //A try-catch block is used to check for the presence of the error message element
        // ie "The specified email already exists"
        //If isErrorMessagePresent is true, the script clicks on the login link to proceed with
        // the login process.
        //If isErrorMessagePresent is false, the script clicks on the logout link to
        // ensure the registration was successful and then test the login functionality.
        try {
            if (driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/form/div[1]/ul/li")).isDisplayed()) {
                isErrorMessagePresent = true;
            }
        } catch (NoSuchElementException e) {
            // No error message found
        }

        if (isErrorMessagePresent) {
            // Click on Login link
            driver.findElement(By.className("ico-login")).click();
        } else {
            // Click on Logout link
            driver.findElement(By.className("ico-logout")).click();
            driver.findElement(By.className("ico-login")).click();
        }

            //Enter the email address
            Thread.sleep(3000);
            driver.findElement(By.id("Email")).sendKeys("Tomharry1234@gmail.com");

            //Enter the email password
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("Weirdpassword!!!");
            Thread.sleep(3000);
            //Click on login button
            driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button")).click();
//        Close the browser
            driver.quit();
        }
    }


