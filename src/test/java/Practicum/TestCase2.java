package Practicum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.Duration;

public class TestCase2 {
    WebDriver driver;
    @Test public void Testcase2() throws InterruptedException{


        // Launch browser
        WebDriverManager.chromedriver().setup();
         driver= new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        // Verify that home page is visible successfully
        WebElement homepage;
        homepage=driver.findElement(By.xpath("//img[@alt=\"Website for automation practice\"]"));
        Assert.assertTrue(homepage.isDisplayed());
        System.out.println("home page is visible successfully");
        Thread.sleep(2000);
        //Click on 'Signup / Login' button
        WebElement SignUp=driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
        SignUp.click();
        Thread.sleep(2000);
        // Verify 'Login to your account' is visible
        WebElement VerifyLogin;
        VerifyLogin=driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        Assert.assertEquals(VerifyLogin.getText(), "Login to your account");
        System.out.println("Verify 'Login to your account' is visible");
        // Enter correct email address and password
        WebElement emailElement;
        emailElement=driver.findElement(By.name("email"));
        Actions actions=new Actions(driver);
        actions.click(emailElement)
                .sendKeys("edakarahan@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("1234")
                .sendKeys(Keys.TAB)
                // Click 'login' button
                .sendKeys(Keys.ENTER)
                .perform();

        // Verify that 'Logged in as username' is visible
        WebElement verifyLogged;
        verifyLogged=driver.findElement(By.xpath("//i[@class='fa fa-user']"));
        Assert.assertTrue(verifyLogged.isDisplayed());
        System.out.println(verifyLogged.getText()+"'Logged in as username' is visible");
       //Click 'Delete Account' button
        WebElement deleteAccount;
        deleteAccount=driver.findElement(By.xpath("//a[text()='Delete Account']"));
        deleteAccount.click();

       // Verify that 'ACCOUNT DELETED!' is visible
        WebElement verifyDeleted;
        verifyDeleted=driver.findElement(By.xpath("//h2[@data-qa='account-deleted']"));
        Assert.assertTrue(verifyDeleted.isDisplayed());
        System.out.println(verifyLogged.getText()+"ACCOUNT DELETED!");




    }


}
