package vk.automation.act;

import jxl.read.biff.BiffException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public class ReadFromExcel {
    public List<String> readExcelFile(String fileName) throws IOException, BiffException {
        //Reading the data from XLS
        FileInputStream fis = new FileInputStream(new File(fileName));
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        int rows = sheet.getPhysicalNumberOfRows();
        List<String> sharePriceExcelValuesfromXLS = new LinkedList<>();
        XSSFCell cell;
        for(int i = 0; i < rows; i++) {

            cell = sheet.getRow(i).getCell(0);
            String contet = cell.getStringCellValue();
            sharePriceExcelValuesfromXLS.add(contet);

        }
        return sharePriceExcelValuesfromXLS;
    }
}

/**
 *
 * @param ReadFromExcel
 * @return
 * @throws IOException
 * @throws BiffException
 * Initialize connection to excel through - JXL framework
 */
