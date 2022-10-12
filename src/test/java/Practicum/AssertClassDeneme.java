package Practicum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AssertClassDeneme {
    @Test
    public void Test001(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Albessa.com a git
        driver.get("https://albessa.com/");
        //Anasayfada  oldugunu dogrula
        WebElement anasayfaLogo = driver.findElement(By.xpath("//a[@class='dib']"));
        Assert.assertTrue(anasayfaLogo.isDisplayed());
        //cikis yap
        driver.quit();


    }
}
