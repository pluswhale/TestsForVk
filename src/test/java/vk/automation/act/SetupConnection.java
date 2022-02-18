package vk.automation.act;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetupConnection {
    public static WebDriver driver;
    final String appUrl = "https://www.vk.com/";
    final int timeOfWaitSec = 3000;

    public void setUpCon() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(appUrl);
        driver.manage().window().maximize();
    }
}
