package Practicum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class webElement_Facebook {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");

        // cookies cikarsa kabul et butonuna basin
        // e-posta kutusuna rastgele bir mail girin
        WebElement emailText=driver.findElement(By.xpath("//input[@id=\"email\"]"));
        emailText.sendKeys("sadsafdhgcfb");
        // sifre kismina rastgele bir sifre girin
        WebElement sifreText = driver.findElement(By.xpath("//input[@id=\"pass\"]"));
        sifreText.sendKeys("sdsfgdsg");

        // giris yap butonuna basin
        driver.findElement(By.xpath("//button[@name=\"login\"]")).submit();

        // uyari olarak "The email or mobile number you entered isn’t connected to an account. Find your account and log in."
        //  mesajinin ciktigini test edin

        WebElement uyariyazisi = driver.findElement(By.xpath("//div [@class=\"_9ay5\"]"));

        String expectedResult ="The email or mobile number you entered isn’t connected to an account. Find your account and log in.";
        String actualResult = uyariyazisi.getText();
        if (expectedResult.equals(actualResult)){
            System.out.println("Passed");} else {
                System.out.println("Fail");}


        // sayfayi kapatin
        driver.close();

    }





}
