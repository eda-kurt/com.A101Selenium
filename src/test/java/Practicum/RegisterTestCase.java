package Practicum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class RegisterTestCase {
    WebDriver driver;
    @Test
    public void test01() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Launch browser
        //  Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        // Verify that home page is visible successfully
         String HomePage=driver.getCurrentUrl();
        Assert.assertEquals(HomePage, "https://automationexercise.com/");
        System.out.println("home page is visible successfully");
        // Click on 'Signup / Login' button
        WebElement SignUp=driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
        SignUp.click();
        // Verify 'New User Signup!' is visible
        WebElement newUserYazisi=driver.findElement(By.xpath("//div[@class='signup-form']"));
        String NewUserYazisi=newUserYazisi.getText();
        Assert.assertTrue(newUserYazisi.isDisplayed());
        System.out.println("'New User Signup!' is visible");
        // Enter name and email address
        WebElement name=driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        Actions actions = new Actions(driver);
        actions.click(name)
                .sendKeys("Eda Kurt")
                .sendKeys(Keys.TAB)
                .sendKeys("edakurt123@gmail.com")
                .sendKeys(Keys.TAB)
                // Click 'Signup' button
                .sendKeys(Keys.ENTER)
                .perform();
        // Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement accountInformation=driver.findElement(By.xpath("//b[text()='Enter Account Information']"));
        Assert.assertTrue(accountInformation.isDisplayed());
        // Fill details: Title, Name, Email, Password, Date of birth
        WebElement Title=driver.findElement(By.xpath("//input[@id='id_gender2']"));
        Actions actions1 = new Actions(driver);
        // Select checkbox 'Receive special offers from our partners!'
        // Select checkbox 'Sign up for our newsletter!'
        // Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        // Click 'Create Account button'
        actions1.click(Title)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("1234")
                .sendKeys(Keys.TAB)
                .sendKeys("5")
                .sendKeys(Keys.TAB)
                .sendKeys("March")
                .sendKeys(Keys.TAB)
                .sendKeys("1995")
                .perform();
        WebElement checkbox1;
        checkbox1= driver.findElement(By.xpath("//input[@name='newsletter']"));
        Thread.sleep(5000);
        checkbox1.click();

        WebElement checkbox2;
        checkbox2= driver.findElement(By.xpath("//input[@value='1']"));
        Thread.sleep(5000);
        checkbox2.click();


        Actions actions2 = new Actions(driver);
        WebElement firstName= driver.findElement(By.xpath("//input[@name='first_name']"));
        actions2.click(firstName)
                .sendKeys("Eda")
                .sendKeys(Keys.TAB)
                .sendKeys("Kurt")
                .sendKeys(Keys.TAB)
                .sendKeys("Patikadev")
                .sendKeys(Keys.TAB)
                .sendKeys("Maltepe")
                .sendKeys(Keys.TAB)
                .sendKeys("Istanbul")
                .sendKeys(Keys.TAB)
                .sendKeys("Canada")
                .sendKeys(Keys.TAB)
                .sendKeys("btr")
                .sendKeys(Keys.TAB)
                .sendKeys("toronto")
                .sendKeys(Keys.TAB)
                .sendKeys("12345")
                .sendKeys(Keys.TAB)
                .sendKeys("1234573490")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

    }
}
