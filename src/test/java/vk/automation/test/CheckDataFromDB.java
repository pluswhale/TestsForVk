package vk.automation.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import vk.automation.act.DataBaseCon;

public class CheckDataFromDB {

    @Test(priority = 10)
    public void dbConAndCompare() throws Exception {
        // взят обычный массив с данными, потому что на сайте вк элементы прописаны на РУССКОМ
        String [] dataFromWeb = {"My Friends", "Invite to Friends", "Search Friends" };

        DataBaseCon db = new DataBaseCon();
        String [] dataFromDatabase = db.getDBValues();
        System.out.println(dataFromDatabase);
        db.tearDown();

        for (int i = 0; i < dataFromDatabase.length ; i++) {
            String actual = dataFromWeb[i];
            String expected = dataFromDatabase[i];
            Assert.assertEquals(actual, expected, "data not matched");
        }
    }
}
