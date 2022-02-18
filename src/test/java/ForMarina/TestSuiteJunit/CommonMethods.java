package ForMarina.TestSuiteJunit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonMethods {
    static WebDriver driver;

    //@FindBy(xpath = "//input[@id='index_email']")
    //private WebElement Email;
    WebElement Email = driver.findElement(By.xpath("//input[@id='index_email']"));

    //@FindBy(xpath = "//input[@id='index_pass']")
    //private WebElement Password;
    WebElement Password = driver.findElement(By.xpath("//input[@id='index_pass']"));

    //@FindBy(xpath = "//button[@id='index_login_button']")
    //private WebElement SignInButton;
    WebElement SignInButton = driver.findElement(By.xpath("//button[@id='index_login_button'"));

    /*
    public void typeEmail(String emailid) {
        Email.sendKeys(emailid);
    }

    public void typePassword(String passwordSend) {
        Password.sendKeys(passwordSend);
    }

    public void clickSignIn() {
        SignInButton.click();
    }

     */
    public void login(String emailId, String passwordId) {
        Email.sendKeys(emailId);
        Password.sendKeys(passwordId);
        SignInButton.click();

    }
    public CommonMethods(WebDriver driver) {
        this.driver = driver;
    }
}
