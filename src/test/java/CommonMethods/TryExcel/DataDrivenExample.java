package CommonMethods.TryExcel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;

public class DataDrivenExample {

    /*
    @this is some locators
     */
    /*
    @this is some locators
     */

    private WebDriver driver;
    final String appUrl = "https://the-internet.herokuapp.com/";
    final String FilePathToExcel = "/Users/egordultsev/IdeaProjects/MavenForSelenium/src/test/java/TryExcel/FormAuthentication.xls";

    @BeforeSuite
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(appUrl);
    }

    @DataProvider(name="SimpleExcelData")
    public Object[][] simpleDataProvider() throws Exception {
        DataDrivenExample objdde = new DataDrivenExample();
        return objdde.getExcelData(FilePathToExcel, "Login");
    }


    @Test(dataProvider = "SimpleExcelData")
    public void logginToForm(String username, String userpass) throws InterruptedException {
        //click to form
        driver.findElement(By.linkText("Form Authentication")).click();

        //login page
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(userpass);
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(3000);

    }

    @AfterSuite
    public void close() {
        driver.quit();
    }

    //connect excel to app
    public Object[][] getExcelData(String filePath, String sheetName) throws Exception {

        FileInputStream fis = null;
        XSSFWorkbook workbook = null;
        XSSFSheet sheet = null;
        XSSFRow row = null;
        XSSFCell cell = null;
        Object[][] ExcelData = null;

        fis = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);

        int rows = sheet.getLastRowNum();
        int columns = sheet.getRow(0).getLastCellNum();
        ExcelData = new Object[rows][columns];
        for(int i=1; i<=rows; i++) {
            for(int j=0; j<columns;j++) {
                System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
                ExcelData[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
            }
        }
        workbook.close();
        fis.close();
        return ExcelData;
    }
}
