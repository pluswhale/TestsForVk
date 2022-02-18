package CommonMethods.TryExcel.TryApachePOI;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ReadXSLX {
    static String pathToExcel = "/Users/egordultsev/IdeaProjects/MavenForSelenium/src/test/java/TryExcel/TryApachePOI/TestCaseData.xlsx";
    static HashMap<String, String> listOFTestCases = new HashMap<>();

    public static void main(String[] args) throws IOException {
      listOFTestCases = readExcelFile(pathToExcel);
        System.out.println(listOFTestCases.size());
    }

    public static HashMap<String, String> readExcelFile(String filename) throws IOException {
        File f = new File(filename);
        FileInputStream fis = new FileInputStream(f);
        XSSFWorkbook excelWorkbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = excelWorkbook.getSheetAt(0);
        int rows = sheet.getPhysicalNumberOfRows();//3
        HashMap<String,String> data = new HashMap<>();
        XSSFCell cell = null;

        for(int i = 0; i < rows; i++) {

            cell = sheet.getRow(i).getCell(0);
            String key = cell.getStringCellValue();

            cell = sheet.getRow(i).getCell(1);
            String value = cell.getStringCellValue();
            System.out.println("Key :: " + key);
            System.out.println("Value ::" + value);
            data.put(key, value);
        }
        return data;
    }
}
