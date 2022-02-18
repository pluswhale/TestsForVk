package CommonMethods.validateTitle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.*;

public class validateTitle {
    public static String pathToFile = "/Users/egordultsev/IdeaProjects/MavenForSelenium/src/test/java/validateTitle/WebsiteTitle.txt";

    @Test
    public void validateTextFromWebPage() throws FileNotFoundException {
        String appUrl = "http://total-qa.com/";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(appUrl);
        driver.manage().window().maximize();
        String actual = driver.findElement(By.xpath("//h1[@class='entry-title page-title']")).getText();
        String expected = readFileWithTitle(pathToFile);
        Assert.assertEquals(actual,expected);
    }

    public static String readFileWithTitle(String filename) throws FileNotFoundException {
        File file = new File(filename);
        FileReader fr = null;
        BufferedReader br = null;
        String text = null;
        try {
            fr = new FileReader(file.getAbsolutePath());
            br = new BufferedReader(fr);
            String str = null;
            str = br.readLine();
            text = str;
            System.out.println("File Contents : " + text);

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try{
                fr.close();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return text;
    }
}
