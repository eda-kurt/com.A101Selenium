package Practicum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class actionClassAlistirma {

    @Test

    public void test001(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Facebooka git
        driver.get("https://www.facebook.com");
        //yeni uyelik sayfasini ac
        WebElement yeniuyelik=driver.findElement(By.xpath("//a[text()='Yeni Hesap Oluştur']"));
        yeniuyelik.click();
        //Action class ile formu doldur
        Actions actions=new Actions(driver);
        WebElement isim=driver.findElement(By.xpath("//input[@name='firstname']"));
        actions.click(isim)
                .sendKeys("Eda")
                .sendKeys(Keys.TAB)
                .sendKeys("Kurt")
                .perform();






    }



}
