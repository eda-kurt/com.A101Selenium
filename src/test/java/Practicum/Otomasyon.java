package Practicum;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Otomasyon {
    public static void main(String[] args) {
        // chrome tanimlanir
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //url ye gidilir
        driver.get("https://www.a101.com.tr");
        //
    }
}
