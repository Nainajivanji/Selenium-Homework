package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class F_Implicitwait {
    public static void main(String[] args) {
        /*demonstrates the use of implicit waits in Selenium WebDriver. Implicit waits are
        used to instruct the WebDriver to wait for a certain amount of time before throwing
         a NoSuchElementException if it cannot find an element immediately; improving the robustness
          of tests without the need for frequent Thread.sleep() calls.
         There's no need to reset the implicit wait later in the script unless you need a different wait
          time for specific scenarios.
 */
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Enter the URL
        driver.get("https://demo.nopcommerce.com/");

        // Register as user
        driver.findElement(By.className("ico-register")).click();

        // Select Female from Radio button
        driver.findElement(By.id("gender-female")).click();

        // Enter First Name
        driver.findElement(By.id("FirstName")).sendKeys("Joe");

        // Enter Last Name
        driver.findElement(By.id("LastName")).sendKeys("Bloggs");

        // Enter Date of Birth
        driver.findElement(By.name("DateOfBirthDay")).sendKeys("8");
        driver.findElement(By.name("DateOfBirthMonth")).sendKeys("November");
        driver.findElement(By.name("DateOfBirthYear")).sendKeys("1986");

        // Enter Email address
        driver.findElement(By.id("Email")).sendKeys("Joebloggs@gmail.com");

        // Enter Company name
        driver.findElement(By.id("Company")).sendKeys("Barrat Developments");

        // Uncheck Newsletter box
        driver.findElement(By.id("Newsletter")).click();

        // Enter Password
        driver.findElement(By.id("Password")).sendKeys("Mypasswordissilly!");

        // Confirm Password
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Mypasswordissilly!");

        // Click on Register button
        driver.findElement(By.id("register-button")).click();

        boolean isErrorMessagePresent = false;
        try {
            isErrorMessagePresent = driver.findElement(By.xpath("//*[@id='main']/div/div/div/div[2]/form/div[1]/ul/li")).isDisplayed();
        } catch (NoSuchElementException e) {
            // No error message found
        }

        if (isErrorMessagePresent) {
            // Click on Login link
            driver.findElement(By.className("ico-login")).click();
        } else {
            // Click on Logout link
            driver.findElement(By.className("ico-logout")).click();
        }

        // Enter the email address for login
        driver.findElement(By.id("Email")).sendKeys("Joebloggs@gmail.com");

        // Enter the email password for login
        driver.findElement(By.id("Password")).sendKeys("Mypasswordissilly!");

        // Click on login button
        driver.findElement(By.cssSelector("button.login-button")).click();

        // Close the browser
        driver.quit();
    }
}

