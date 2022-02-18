package vk.automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.testng.Assert;

import java.text.DecimalFormat;
import java.util.List;

import static java.lang.Math.round;

public class MainPage {
    WebDriver driver;

    @FindBy (xpath = "//*/a[contains(@id, 'ui_rmenu')]/span")
    List<WebElement> listOfRightMenuAtFriends;

    @FindBy (xpath = "//*[contains(text(), '$Uah$')]")
    List<WebElement> checkMsg;

    @FindBy(xpath = " //*[contains(@class,'left_label inl_bl')]")  ////*/ol[@class='side_bar_ol']/li - prev xpath
    List<WebElement> listOfLi;

    @FindBy(xpath = "//*[@id='l_msg']")
    WebElement CheckerLeftPanelMsg;

    @FindBy(xpath = "//*[@id='send_post']")
    WebElement SendPostButton;

    @FindBy(xpath = "//*[@id='post_field']")
    WebElement PostField;

    @FindBy(xpath = "//*[@id='l_pr']")
    WebElement TransitLeftBarToMainPage;

    @FindBy(xpath = "//*[@class='author']")
    WebElement MyPostIsExist;

    @FindBy(xpath = "//*[@id='l_fr']")
    public WebElement TransitLeftBarToFriendPage;

    @FindBy(how = How.LINK_TEXT , using="Написать сообщение")
    WebElement ButtonWriteMsg;

    @FindBy(how = How.LINK_TEXT , using="Перейти к диалогу с Настей")
    WebElement TransitToChatWithSomeone;

    @FindBy(id = "im_editable197810667")
    WebElement PickInputChatField;

    @FindBy(className = "im-chat-input--send")
    WebElement PressSendBut;

    public void clickOnEveryElementOnLeftBat() throws InterruptedException {

        while (true) {
            for (int i = 0; i < 11; i++) {
                listOfLi.get(i).click();
                Thread.sleep(1000);
                driver.navigate().to("https://www.vk.com/");
                Thread.sleep(1000);
            }
            for (int i = 13; i < 15; i++) {
                listOfLi.get(i).click();
                Thread.sleep(1000);
                driver.navigate().to("https://www.vk.com/");
                Thread.sleep(1000);
            }
            for (int i = 16; i < listOfLi.size(); i++) {
                listOfLi.get(i).click();
                Thread.sleep(1000);
                driver.navigate().to("https://www.vk.com/");
                Thread.sleep(1000);
            }
            break;
        }
    }

    public List<WebElement> listOfELIment() throws InterruptedException {
        Thread.sleep(1500);
        System.out.println("Size of the actual element list is :: " + listOfLi.size());
        return listOfLi;
    }

    public List<WebElement> getListOfRightMenuAtFriends() {
        System.out.println("Size of the actual element list is :: " + listOfRightMenuAtFriends.size());
        return listOfRightMenuAtFriends;
    }

    public void writeToSomeFriend() throws InterruptedException {
        TransitLeftBarToFriendPage.click();
        Thread.sleep(2000);
        ButtonWriteMsg.click();
        Thread.sleep(2000);
        TransitToChatWithSomeone.click();
        Thread.sleep(2000);

        DecimalFormat df = new DecimalFormat("#.#####");
        double keyValue = Math.random();
        String keyValueFormatted = df.format(keyValue);
        String expectMessage = "Hello, Nasty. Have a good luck " + keyValueFormatted;

        driver.findElement(By.id("im_editable197810667")).clear();
        driver.findElement(By.id("im_editable197810667")).sendKeys(expectMessage); // add random msg at end. create var with random number.
        WebElement pressSendMsgButton = PressSendBut;
        pressSendMsgButton.click();
        Thread.sleep(3000);
        boolean actual = driver.findElement(By.xpath("//*/div[contains(text(), '"+ keyValueFormatted +"')]")).isDisplayed();
        boolean expected = true;
        Assert.assertEquals(actual, expected, "Msg don't send");
        TransitLeftBarToMainPage.click();
    }

    public void clickOnTestField() throws InterruptedException {
        DecimalFormat df = new DecimalFormat("#.#####");
        double keyValue = Math.random();
        String keyFormatted = df.format(keyValue);
        String expectedPost = "Selenium was here " + keyFormatted ;
        if(CheckerLeftPanelMsg.isEnabled())
            driver.findElement(By.xpath("//*[@id='post_field']")).click();
            driver.findElement(By.xpath("//*[@id='post_field']")).sendKeys(expectedPost);
            SendPostButton.click();
            TransitLeftBarToMainPage.click();
            boolean actual = driver.findElement(By.xpath("//*[contains(text(), '" + keyFormatted + "')]")).isDisplayed();
            boolean expected = true;
            Assert.assertEquals(actual, expected, "Post wasn't created");
            Thread.sleep(2000);
            driver.navigate().back();
    }

    public MainPage(WebDriver driverForPreviousClass) {
        this.driver = driverForPreviousClass;
        PageFactory.initElements(driverForPreviousClass, this);
    }
}
