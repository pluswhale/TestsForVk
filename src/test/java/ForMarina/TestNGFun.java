package ForMarina;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGFun {
    public WebDriver driver;
    public String appUrl = "https://www.vk.com/";

    // initiate session
    @BeforeSuite
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(appUrl);
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS); //ImplicitWait - But it's deprecated
    }

    // close session after tests due to avoid NoSuchSessionException
    @AfterSuite
    public void closeConnection() {
        driver.quit();
    }

    @Test
    public void compareTitle() {
        try {
            String expectedTitle = "Welcome! | VK";
            String actualTitle = driver.getTitle();
            Assert.assertEquals(expectedTitle, actualTitle); //Assertion
        } catch (NoSuchElementException e) {
            System.out.println("title doesn't compare");
        }
        finally {
            //
        }
    }

    // main test
    @Test(priority = 1)
    public void checkIsDisplayedAndEnabled() throws InterruptedException {
        boolean searchButtonPresence = driver.findElement(By.id("index_email")).isDisplayed();
        boolean searchButtonEnabled = driver.findElement(By.id("index_pass")).isEnabled();
        boolean loginButtonDisplayed = driver.findElement(By.id("index_login_button")).isDisplayed();
        boolean loginButtonEnabled = driver.findElement(By.id("index_login_button")).isEnabled();

        if (searchButtonPresence == true && searchButtonEnabled == true) {
            //input email
            WebElement emailInput = driver.findElement(By.id("index_email"));
            emailInput.clear();
            emailInput.sendKeys("+375296548456");

            //input password
            WebElement passInput = driver.findElement(By.id("index_pass"));
            passInput.clear();
            passInput.sendKeys(("Qwerty123@"));

            // press login button
            if (loginButtonDisplayed == true && loginButtonEnabled == true) {
                WebElement pressLogginButton = driver.findElement(By.id("index_login_button"));
                pressLogginButton.click();
                Thread.sleep(5000);
            }
        }
        //Transition

        try {
            WebElement pressNewsBut = driver.findElement(By.id("l_msg"));
            pressNewsBut.click();
        } catch (StaleElementReferenceException e) {
            System.out.println("no element anymore");
        }

        Thread.sleep(5000);
        driver.navigate().back();

        WebElement pressFriendBut = driver.findElement(By.id("l_fr"));
        pressFriendBut.click();
        Thread.sleep(3000);

        // var for count of sec to wait to load
        int countOfWaitSec = 1000;

        // try to message to someone
        driver.findElement(By.linkText("Написать сообщение")).click();
        Thread.sleep(countOfWaitSec);
        driver.findElement(By.linkText("Перейти к диалогу с Настей")).click();
        Thread.sleep(countOfWaitSec);
        for (int i = 0; i <= 10; i++) {
            WebElement pickInputFieldForMsg = driver.findElement(By.id("im_editable197810667"));
            pickInputFieldForMsg.clear();
            pickInputFieldForMsg.sendKeys("Hellow,Nasty. Have a good luck");
            WebElement pressSendMsgButton = driver.findElement(By.className("im-chat-input--send"));
            pressSendMsgButton.click();
            Thread.sleep(countOfWaitSec);
        }

        //fun
        /*
        WebElement searchInput = driver.findElement(By.id("ts_input"));
        searchInput.clear();
        searchInput.sendKeys("Настя Кожемякина");
        WebElement searchLink = driver.findElement((By.id("ts_search_link")));
        searchLink.click();
        Thread.sleep(5000);
        WebElement pickPeople = driver.findElement(By.id("ui_rmenu_people"));
        pickPeople.click();
        WebElement InputValueCountry = driver.findElement((By.id("c[country]_custom")));
        InputValueCountry.sendKeys("Беларусь");
        */
    }
}
