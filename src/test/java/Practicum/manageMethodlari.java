package Practicum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class manageMethodlari {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.a101.com.tr");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Sayfa basligi donduruldu
        System.out.println("sayfa title:"+ driver.getTitle());
        //Sayfa url si donduruldu
        driver.getCurrentUrl();
        System.out.println("SAYFA URLSI;"+ driver.getCurrentUrl());
        //Navigate olusturuldu
        driver.navigate().to("https://www.youtube.com");
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
        //window ayarlari yapildi
        System.out.println("sayfa size:"+ driver.manage().window().getSize());
        System.out.println("sayfa Position :"+ driver.manage().window().getPosition());
        driver.manage().window().setSize(new Dimension(900,600));
        //miximaze,fullscreen,minimaze de denendi
        //Sayfa kapatildi
        driver.close();



    }
}
