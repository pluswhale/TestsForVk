package vk.automation.test;

import jxl.read.biff.BiffException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import vk.automation.act.Login;
import vk.automation.act.ReadFromExcel;
import vk.automation.act.SetupConnection;
import vk.automation.logger.LoggerForVk;
import vk.automation.page.MainPage;

import java.io.IOException;
import java.util.List;

import static vk.automation.act.SetupConnection.driver;

public class CheckDataFromExcel {
    public static List<String> shareListOfElementsFromExcel;
    public static List<WebElement> shareListOfElementsfromWebLeftBar;
    private final String pathToExcel = "/Users/egordultsev/IdeaProjects/MavenForSelenium/src/test/java/CommonMethods/ListOfElement.xlsx";
    final static Logger logger = Logger.getLogger(CheckDataFromExcel.class);
    int timeOfWaitSec = 1500;

    @BeforeSuite
    public void setupConn() throws IOException {

        SetupConnection setup = new SetupConnection();
        setup.setUpCon();
        LoggerForVk logger = new LoggerForVk();
        logger.configureLogger();
    }

    @AfterSuite
    public void closeConn() throws InterruptedException {
        Thread.sleep(timeOfWaitSec);
        driver.quit();
    }

    @Test
    public void loginTest() throws InterruptedException {

        Login login = new Login(driver);
        login.login("-", "-");
        Thread.sleep(timeOfWaitSec);
        logger.info("I'm loading" + " ClassName : " + getClass());

    }

    @Test(priority = 1)
    public  void getElementsFromWeb() throws InterruptedException {

        MainPage mp = new MainPage(driver);
        shareListOfElementsfromWebLeftBar = mp.listOfELIment();
        for(int i = 0; i < shareListOfElementsfromWebLeftBar.size(); i++) {
            System.out.println("Value of actual element :: " + i + " - " + shareListOfElementsfromWebLeftBar.get(i).getText().trim());
            System.out.println();
        }
        System.out.println("________");
        logger.warn("Check it after execution. It may be not full list" + " ClassName : " + getClass());
    }

    @Test(priority = 2)
    public void getElementFromExcel() throws BiffException, IOException {

        ReadFromExcel readFile = new ReadFromExcel();
        shareListOfElementsFromExcel = readFile.readExcelFile(pathToExcel);
        System.out.println("Size of exception list is : " + shareListOfElementsFromExcel.size());
        for(int i = 0; i < shareListOfElementsFromExcel.size(); i++) {
            System.out.println("Vallue of exception element :: "  + shareListOfElementsFromExcel.get(i).trim());
            System.out.println();
        }
        System.out.println("________");
        logger.warn("Check it after execution. It may be not full list" + " ClassName : " + getClass());
    }
}
