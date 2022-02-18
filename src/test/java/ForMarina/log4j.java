package ForMarina;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class log4j {

    final String appUrl = "https://www.vk.com";
    public  WebDriver driver;

    @BeforeSuite
    public void setup() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        Properties p = new Properties();
        p.load(new FileInputStream(log4PropertyFile));
        PropertyConfigurator.configure(p);
    }


    final static Logger logger = Logger.getLogger(log4j.class);
    String log4PropertyFile = "/Users/egordultsev/IdeaProjects/MavenForSelenium/src/test/java/ForMarina/log4j.properties.txt";

    @Test
    public void Test() throws IOException {

        logger.info("I'm loading" + " ClassName : " + getClass());
        logger.debug("Debug this path for chrome path issue." + " ClassName : " + getClass());
        logger.info("Chrome driver is up and running" + " ClassName : " + getClass());
        driver.get(appUrl);
        logger.warn("Url is not loaded properly" + " ClassName : " + getClass());
        driver.findElement(By.id("index_email")).sendKeys("+375296548456");
        logger.fatal("Message not entered" + " ClassName : " + getClass());

    }
}
