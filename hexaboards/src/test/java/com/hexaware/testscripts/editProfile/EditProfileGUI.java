package com.hexaware.testscripts.editProfile;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.hexaware.frameworks.gui.GuiFramework;
import com.hexaware.frameworks.gui.pageobjects.*;
import com.hexaware.testscripts.Login.LoginTestNG;
import org.apache.xmlbeans.impl.jam.JElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.datatransfer.StringSelection;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class EditProfileGUI {
    ExtentReports extent = new ExtentReports();
    ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/EditProfileReportAUTC1.html");
    ExtentTest logger;
    WebDriver driver;
    InputStream input;
    Properties prop = new Properties();
    WebElement element;
    String filepath;
    String URI;
    //login
    String[] dataArrayL;
    ArrayList<String> usernameL;
    String usernameLo;
    String passwordLo;
    //Edit profile
    ArrayList<String> nameEP;
    ArrayList<String> emailEP;
    ArrayList<String> passwordEP;
    String[] dataArray;
    String name;
    String email;
    String password;
    String temp;
    GuiFramework fr = new GuiFramework();
    JavascriptExecutor je = null;


    // This code will run before executing any testcase
    @BeforeMethod(groups = {"functest"})
    public void setup() throws IOException {
        input = new FileInputStream("confs.txt");
        prop.load(input);
        filepath = prop.getProperty("DataFile");
        URI = prop.getProperty("URI");
        //Login
        usernameL = fr.readExcel(filepath, 0);
        //Edit profile
        nameEP = fr.readExcel(filepath, 3);
        emailEP = fr.readExcel(filepath, 4);
        passwordEP = fr.readExcel(filepath, 5);
        driver = fr.initDriver(prop);
        extent.attachReporter(reporter);
        driver.navigate().to(URI);
    }


    //////////////////////////////////////////FIRST WAY//////////////////////////////////////////////////////////////////////////
///////////////////////////////Scenario 1////////////////////////////////////////////
    @Test(groups = {"functest"})
    public void scenario0() throws IOException, InterruptedException {

        WebDriverWait varWat = new WebDriverWait(driver, 10);
        logger = extent.createTest("Scenario 1", "The user doesn’t fill the field name");

        dataArray = fr.turnArray(nameEP, 1);
        name = dataArray[0];
        usernameLo = dataArray[1];
        passwordLo = dataArray[2];

        fr.login(usernameLo, passwordLo, driver);

        EditProfile ep = new EditProfile(driver);
        ProfileInformation pi = new ProfileInformation(driver);

        //Profile Picture
        element = ep.getProfilePicture();
        varWat.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        temp = fr.getScreenshot(driver);
        logger.pass("Click on Profile Picture Button", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());


        //Step 1
        element = ep.getUnlockName();
        varWat.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        temp = fr.getScreenshot(driver);
        logger.pass("Click unlock name", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

        //Step 2
        element = ep.getSaveButton();
        varWat.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        temp = fr.getScreenshot(driver);
        logger.pass("Click unlock name", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

        Assert.assertTrue(ep.getBlankErrorName().isEnabled(), "You can't leave this blank");
    }

    @AfterMethod(groups = {"functest"})
    public void tearDown(ITestResult result) throws IOException {
        temp = fr.getScreenshot(driver);
        if (result.getStatus() == 1) {
            logger.pass("Success test", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
        } else {
            logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
        }
        extent.flush();
        driver.close();
    }


}
