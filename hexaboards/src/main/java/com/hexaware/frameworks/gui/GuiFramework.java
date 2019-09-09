package com.hexaware.frameworks.gui;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class GuiFramework {


    public String[] turnArray(ArrayList<String> list, int index) {
        String[] array = list.get(index).split(",");
        for (int i=0; i<array.length;i++){
            array[i]=array[i].substring(1);
        }
        return array;
    }


    //method to get data from a Excel in a list
    public ArrayList<String> readExcel(String filepath, int sheet) throws IOException {
        Workbook workbook = WorkbookFactory.create(new File(filepath));
        ArrayList<String> list = new ArrayList();
        ArrayList<String> list2 = new ArrayList();

        Sheet sheets = workbook.getSheetAt(sheet);
        // Create a DataFormatter to format and get each cell's value as String
        DataFormatter dataFormatter = new DataFormatter();

        // 1. You can obtain a rowIterator and columnIterator and iterate over them
        // System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
        Iterator<Row> rowIterator = sheets.rowIterator();


        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            // Now let's iterate over the columns of the current row
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();

                String cellValue = dataFormatter.formatCellValue(cell);
                //System.out.print(cellValue + "\t");

                list.add(cellValue);


            }
            String str = list.toString();
            list2.add(str.substring(0, str.length() - 1));


            list.clear();


        }


        return list2;
    }


    // Method to define a webdriver
    public WebDriver initDriver(Properties props) throws IOException {
        WebDriver drivers = null;
        props = new Properties();
        InputStream inputs = new FileInputStream("C:\\Users\\Training\\Desktop\\confs.txt");
        props.load(inputs);
        String browser = props.getProperty("browser");
        String driver = props.getProperty("driver");
        String path = props.getProperty("path");
        int waittime = Integer.parseInt(props.getProperty("implicitWaitTime"));

        if (browser.equals("chrome")) {
            System.setProperty(driver, path);
            drivers = (WebDriver) new ChromeDriver();
        } else if (browser.equals("firefox")) {
            System.setProperty(driver, path);
            drivers = (WebDriver) new FirefoxDriver();
        } else if (browser.equals("ie")) {
            System.setProperty(driver, path);
            drivers = (WebDriver) new InternetExplorerDriver();
        }
        drivers.manage().timeouts().implicitlyWait(waittime, TimeUnit.SECONDS);
        return drivers;
    }


    //method to make and get screenshots
    public static String getScreenshot(WebDriver driver) {
        TakesScreenshot ts = (TakesScreenshot) driver;

        File src = ts.getScreenshotAs(OutputType.FILE);

        String path = System.getProperty("user.dir") + "\\Screenshot\\" + System.currentTimeMillis() + ".png";

        File destination = new File(path);

        try {
            FileHandler.copy(src, destination);
            FileUtils.copyFile(src, destination);
        } catch (IOException e) {
            System.out.println("Capture Failed " + e.getMessage());
        }

        return path;
    }


}
