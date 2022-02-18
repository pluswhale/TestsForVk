package vk.automation.act;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class Login {
    WebDriver driver;

    @FindBy(xpath = "//input[@id='index_email']")
    private WebElement Email;

    @FindBy(xpath = "//input[@id='index_pass']")
    private WebElement Password;

    @FindBy(xpath = "//button[@id='index_login_button']")
    private WebElement SignInButton;

    public void login(String emailID, String password) {
        Email.sendKeys(emailID);
        Password.sendKeys(password);
        SignInButton.click();
    }

    public Login(WebDriver driverForPreviousClass) {
        this.driver = driverForPreviousClass;
        PageFactory.initElements(driverForPreviousClass, this);
    }
}
