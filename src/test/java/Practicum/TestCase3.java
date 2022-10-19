package Practicum;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase3 {
    WebDriver driver;
    @Test
    public void  testCase3() throws InterruptedException {
        // Launch browser
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        // Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        // Verify that home page is visible successfully
        WebElement homepage;
        homepage=driver.findElement(By.xpath("//img[@alt=\"Website for automation practice\"]"));
        Assert.assertTrue(homepage.isDisplayed());
        System.out.println("home page is visible successfully");
        Thread.sleep(2000);
        // Click on 'Signup / Login' button
        WebElement SignUp=driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
        SignUp.click();
        Thread.sleep(2000);
        // Verify 'Login to your account' is visible
        WebElement VerifyLogin;
        VerifyLogin=driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertEquals(VerifyLogin.getText(), "Login to your account");
        System.out.println("Verify 'Login to your account' is visible");
        // Enter incorrect email address and password
        WebElement emailElement;
        emailElement=driver.findElement(By.name("email"));
        Actions actions=new Actions(driver);
        actions.click(emailElement)
                .sendKeys("edakarahan123@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                // Click 'login' button
                .sendKeys(Keys.ENTER)
                .perform();
        // Verify error 'Your email or password is incorrect!' is visible
        Thread.sleep(5000);
        WebElement IncorrectElement;
        IncorrectElement=driver.findElement(By.xpath("//p[text()='Your email or password is incorrect!']"));
        Assert.assertTrue(IncorrectElement.isDisplayed());
        System.out.println("Verify Error"+IncorrectElement.getText());

        driver.quit();




    }


}
