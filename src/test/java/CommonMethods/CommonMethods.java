package CommonMethods;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.LinkedList;
import java.util.List;

public class CommonMethods {
    public static List<String> readXLSFile(String fileName) throws IOException, BiffException {
        //Reading the data from XLS
        FileInputStream fis = new FileInputStream(new File(fileName));
        Workbook wb = Workbook.getWorkbook(fis);
        Sheet sheet = wb.getSheet(0);
        int rows = sheet.getRows();
        List<String> sharePriceExcelValuesfromXLS = new LinkedList<>();
        for(int i = 0;i < rows; i++) {

            Cell cell = sheet.getCell(0,i);  // i - row , 0 - column
            String value = cell.getContents();
            System.out.print("Value :: " + value);
            sharePriceExcelValuesfromXLS.add(value);
            System.out.println();
        }
        return sharePriceExcelValuesfromXLS;
    }
}
