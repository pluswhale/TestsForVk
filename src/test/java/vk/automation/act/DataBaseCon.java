package vk.automation.act;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.sql.*;

public class DataBaseCon {
    //Connection object
    static Connection con = null;
    //Statement object
    private static Statement stmt;
    //Constant for Database URL
    public static String DB_URL = "jdbc:postgresql://localhost:5432/egordultsev";
    //Constant for DB username
    public static String DB_USER = "postgres";
    public static String DB_PASSWORD = "123";


    public String[] getDBValues() throws ClassNotFoundException, SQLException {
        System.out.println("Testing connection...");

        String jdbcDriver = "org.postgresql.Driver";
        Class.forName(jdbcDriver);
        Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);


        String query = "SELECT * FROM expecteddata";
        ResultSet res = stmt.executeQuery(query);
        res.last();

        int rows = res.getRow();
        System.out.println("Number of rows " + rows);

        ResultSetMetaData rsmd = res.getMetaData();
        int cols = rsmd.getColumnCount();
        System.out.println("Number of cols: " + cols);

        String data[] = new String[rows];

        int i = 0;
        res.beforeFirst();
        while (res.next()) {
            for (int j = 0; j < cols; j++) {
                data[i] = res.getString(j + 1);
                System.out.println(data[i]);
            }
            i++;
        }
        return data;
    }

    @AfterSuite
    public void tearDown() throws Exception {
        //Close DB connection
        if (con != null) con.close();
    }
}
