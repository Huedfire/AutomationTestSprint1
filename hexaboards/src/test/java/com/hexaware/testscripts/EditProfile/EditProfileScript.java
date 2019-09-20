package com.hexaware.testscripts.EditProfile;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.hexaware.frameworks.gui.GuiFramework;
import com.hexaware.frameworks.gui.pageobjects.EditProfile;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class EditProfileScript {
    ExtentReports extent = new ExtentReports();
    ExtentHtmlReporter reporter;
    ExtentTest logger;
    WebDriver driver;
    InputStream input;
    Properties prop = new Properties();
    WebElement element;
    //login
    ArrayList<String> usernameL;
    String usernameLo, passwordLo, filepath, URI, name, email, verifiedName,temp;
    boolean   verifiedEmail;
    //Edit profile
    ArrayList<String> nameEP;
    ArrayList<String> emailEP;
    ArrayList<String> passwordEP;
    String[] dataArray;

    GuiFramework fr = new GuiFramework();
    JavascriptExecutor je = null;


    // This code will run before executing any testcase
    @BeforeMethod(groups = {"functest"})
    public void setup() throws IOException {
        input = new FileInputStream("confs.txt");
        prop.load(input);
        reporter = new ExtentHtmlReporter(prop.getProperty("EPreport"));
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

    ////////////////////////////////////////Name's scenarios////////////////////////////////////////////////////////////////
    @Test(groups = {"functest"}, priority = 1)
    public void scenario1() throws IOException, InterruptedException {

        WebDriverWait varWat = new WebDriverWait(driver, 10);
        logger = extent.createTest("Scenario 1", "The user doesn’t fill the field name");

        dataArray = fr.turnArray(nameEP, 1);
        name = dataArray[0];
        usernameLo = dataArray[1];
        passwordLo = dataArray[2];

        fr.login(usernameLo, passwordLo, driver);

        EditProfile ep = new EditProfile(driver);

        //Profile Picture
        element = ep.getProfilePicture();
        varWat.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        temp = fr.getScreenshot(driver);
        logger.pass("Click Profile Picture Button", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());


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
        logger.pass("Click Save button", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

        Assert.assertTrue(ep.getBlankErrorName().isEnabled(), "You can't leave this blank");
    }

    @Test(groups = {"functest"}, priority = 2)
    public void scenario2() throws IOException, InterruptedException {

        WebDriverWait varWat = new WebDriverWait(driver, 10);
        logger = extent.createTest("Scenario 2", "The user fill the field name with a blank space");

        dataArray = fr.turnArray(nameEP, 2);
        name = dataArray[0];
        usernameLo = dataArray[1];
        passwordLo = dataArray[2];

        fr.login(usernameLo, passwordLo, driver);

        EditProfile ep = new EditProfile(driver);


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
        logger.pass("Click on Save button", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

        Assert.assertTrue(ep.getBlankErrorName().isEnabled(), "You can't leave this blank");

    }

    @Test(groups = {"functest"}, priority = 3)
    public void scenario3() throws IOException, InterruptedException {

        WebDriverWait varWat = new WebDriverWait(driver, 10);
        logger = extent.createTest("Scenario 3", "The user types a correct name");

        dataArray = fr.turnArray(nameEP, 3);
        name = dataArray[0];
        usernameLo = dataArray[1];
        passwordLo = dataArray[2];

        fr.login(usernameLo, passwordLo, driver);

        EditProfile ep = new EditProfile(driver);
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
        ep.getEditName().sendKeys(name);
        temp = fr.getScreenshot(driver);
        logger.pass("Write in the field of the name \n\r\tData: " + name, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        //Step 3
        element = ep.getSaveButton();
        varWat.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        temp = fr.getScreenshot(driver);
        logger.pass("Click on Save button", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

        //check alert
        driver.switchTo().alert().accept();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        varWat = new WebDriverWait(driver, 2);

        //Refresh page
        driver.navigate().refresh();


        varWat = new WebDriverWait(driver, 10);

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

        Assert.assertEquals(ep.getNameVerified2(),name,"Fail: Data match //");
    }


    @Test(groups = {"functest"}, priority = 4)
    public void scenario4() throws IOException, InterruptedException {

        WebDriverWait varWat = new WebDriverWait(driver, 10);
        logger = extent.createTest("Scenario 4", "The user types its name with more characters than allowed");

        dataArray = fr.turnArray(nameEP, 4);
        name = dataArray[0];
        usernameLo = dataArray[1];
        passwordLo = dataArray[2];

        fr.login(usernameLo, passwordLo, driver);

        EditProfile ep = new EditProfile(driver);

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
        ep.getEditName().sendKeys(name);
        temp = fr.getScreenshot(driver);
        logger.pass("Write in the field of the name \n\r\tData: " + name, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        //Step 3
        element = ep.getSaveButton();
        varWat.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        temp = fr.getScreenshot(driver);
        logger.pass("Click on Save button", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());


        //Refresh page
        driver.navigate().refresh();


        varWat = new WebDriverWait(driver, 10);

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
        logger.pass("Click unlock email", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

        Assert.assertNotEquals(ep.getNameVerified2(),name,"Fail: Data match //");

    }

    @Test(groups = {"functest"}, priority = 5)
    public void scenario5() throws IOException, InterruptedException {
        WebDriverWait varWat = new WebDriverWait(driver, 10);
        logger = extent.createTest("Scenario 5", "The user types its name with numbers");
        dataArray = fr.turnArray(nameEP, 5);
        name = dataArray[0];
        usernameLo = dataArray[1];
        passwordLo = dataArray[2];
        fr.login(usernameLo, passwordLo, driver);
        EditProfile ep = new EditProfile(driver);
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
        ep.getEditName().sendKeys(name);
        temp = fr.getScreenshot(driver);
        logger.pass("Write in the field of the name \n\r\tData: " + name, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        //Step 3
        element = ep.getSaveButton();
        varWat.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        temp = fr.getScreenshot(driver);
        logger.pass("Click on Save button", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

        //check alert
        driver.switchTo().alert().accept();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        varWat = new WebDriverWait(driver, 2);
        //Refresh page
        driver.navigate().refresh();

        varWat = new WebDriverWait(driver, 10);
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
        Assert.assertEquals(ep.getNameVerified2(),name,"Fail: Data not match //");
    }

    @Test(groups = {"functest"}, priority = 6)
    public void scenario6() throws IOException, InterruptedException {
        WebDriverWait varWat = new WebDriverWait(driver, 10);
        logger = extent.createTest("Scenario 6", "TThe user types its name with special characters");
        dataArray = fr.turnArray(nameEP, 6);
        name = dataArray[0];
        usernameLo = dataArray[1];
        passwordLo = dataArray[2];
        fr.login(usernameLo, passwordLo, driver);
        EditProfile ep = new EditProfile(driver);
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
        ep.getEditName().sendKeys(name);
        temp = fr.getScreenshot(driver);
        logger.pass("Write in the field of the name \n\r\tData: " + name, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        //Step 3
        element = ep.getSaveButton();
        varWat.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        temp = fr.getScreenshot(driver);
        logger.pass("Click on Save button", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

        //check alert
        driver.switchTo().alert().accept();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        varWat = new WebDriverWait(driver, 2);
        //Refresh page
        driver.navigate().refresh();

        varWat = new WebDriverWait(driver, 10);
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
        Assert.assertEquals(ep.getNameVerified2(),name,"Fail: Data match //");
    }

    @Test(groups = {"functest"}, priority = 7)
    public void scenario7() throws IOException, InterruptedException {
        WebDriverWait varWat = new WebDriverWait(driver, 10);
        logger = extent.createTest("Scenario 7", "The  user types its name with a number and a special character");
        dataArray = fr.turnArray(nameEP, 7);
        name = dataArray[0];
        usernameLo = dataArray[1];
        passwordLo = dataArray[2];
        fr.login(usernameLo, passwordLo, driver);
        EditProfile ep = new EditProfile(driver);
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
        ep.getEditName().sendKeys(name);
        temp = fr.getScreenshot(driver);
        logger.pass("Write in the field of the name \n\r\tData: " + name, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        //Step 3
        element = ep.getSaveButton();
        varWat.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        temp = fr.getScreenshot(driver);
        logger.pass("Click on Save button", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

        //check alert
        driver.switchTo().alert().accept();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        varWat = new WebDriverWait(driver, 2);
        //Refresh page
        driver.navigate().refresh();

        varWat = new WebDriverWait(driver, 10);
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
        Assert.assertEquals(ep.getNameVerified2(),name,"Fail: Data match //");
    }
/////////////////////// Email's scenarios////////////////////////////////////////////////////////////////////////////

    @Test(groups = {"functest"}, priority = 8)
    public void scenario8() throws IOException, InterruptedException {

        WebDriverWait varWat = new WebDriverWait(driver, 10);
        logger = extent.createTest("Scenario 8", "The user doesn’t fill the field email ");

        dataArray = fr.turnArray(emailEP, 1);
        email = dataArray[0];
        usernameLo = dataArray[1];
        passwordLo = dataArray[2];

        fr.login(usernameLo, passwordLo, driver);

        EditProfile ep = new EditProfile(driver);

        //Profile Picture
        element = ep.getProfilePicture();
        varWat.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        temp = fr.getScreenshot(driver);
        logger.pass("Click on Profile Picture Button", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());


        //Step 1
        element = ep.getUnlockEmail();
        varWat.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        temp = fr.getScreenshot(driver);
        logger.pass("Click unlock email", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

        //Step 2
        ep.getEditEmail().sendKeys(email);
        temp = fr.getScreenshot(driver);
        logger.pass("Write in the field of the email \n\r\tData: " + email, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        //Step 3
        element = ep.getSaveButton();
        varWat.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        temp = fr.getScreenshot(driver);
        logger.pass("Click on Save button", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

        Assert.assertTrue(ep.getBlankErrorEmail().isDisplayed(), "You can't leave this blank");
    }

    @Test(groups = {"functest"}, priority = 9)
    public void scenario9() throws IOException, InterruptedException {

        WebDriverWait varWat = new WebDriverWait(driver, 10);
        logger = extent.createTest("Scenario 9", "The user types its correct email");

        dataArray = fr.turnArray(emailEP, 2);
        email = dataArray[0];
        usernameLo = dataArray[1];
        passwordLo = dataArray[2];

        fr.login(usernameLo, passwordLo, driver);

        EditProfile ep = new EditProfile(driver);

        //Profile Picture
        element = ep.getProfilePicture();
        varWat.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        temp = fr.getScreenshot(driver);
        logger.pass("Click on Profile Picture Button", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());


        //Step 1
        element = ep.getUnlockEmail();
        varWat.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        temp = fr.getScreenshot(driver);
        logger.pass("Click unlock email", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

        //Step 2
        ep.getEditEmail().sendKeys(email);
        temp = fr.getScreenshot(driver);
        logger.pass("Write in the field of the email \n\r\tData: " + email, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        //Step 3
        element = ep.getSaveButton();
        varWat.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        temp = fr.getScreenshot(driver);
        logger.pass("Click on Save button", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());


        //check alert
        driver.switchTo().alert().accept();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        varWat = new WebDriverWait(driver, 2);

        //Refresh page
        driver.navigate().refresh();


        varWat = new WebDriverWait(driver, 10);

        //Profile Picture
        element = ep.getProfilePicture();
        varWat.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        temp = fr.getScreenshot(driver);
        logger.pass("Click on Profile Picture Button", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

        //Step 1
        element = ep.getUnlockEmail();
        varWat.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        temp = fr.getScreenshot(driver);
        logger.pass("Click unlock email", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());


        Assert.assertEquals(ep.getEmailVerified2(),email,"Fail: Data match //");

    }

    @Test(groups = {"functest"}, priority = 10)
    public void scenario10() throws IOException, InterruptedException {

        WebDriverWait varWat = new WebDriverWait(driver, 10);
        logger = extent.createTest("Scenario 10", "The user types its email in wrong format");

        dataArray = fr.turnArray(emailEP, 3);
        email = dataArray[0];
        usernameLo = dataArray[1];
        passwordLo = dataArray[2];

        fr.login(usernameLo, passwordLo, driver);

        EditProfile ep = new EditProfile(driver);

        //Profile Picture
        element = ep.getProfilePicture();
        varWat.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        temp = fr.getScreenshot(driver);
        logger.pass("Click on Profile Picture Button", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());


        //Step 1
        element = ep.getUnlockEmail();
        varWat.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        temp = fr.getScreenshot(driver);
        logger.pass("Click unlock email", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

        //Step 2
        ep.getEditEmail().sendKeys(email);
        temp = fr.getScreenshot(driver);
        logger.pass("Write in the field of the email \n\r\tData: " + email, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        //Step 3
        element = ep.getSaveButton();
        varWat.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        temp = fr.getScreenshot(driver);
        logger.pass("Click on Save button", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

        //check alert
        driver.switchTo().alert().accept();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        varWat = new WebDriverWait(driver, 2);

        //Refresh page
        driver.navigate().refresh();


        varWat = new WebDriverWait(driver, 10);

        //Profile Picture
        element = ep.getProfilePicture();
        varWat.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        temp = fr.getScreenshot(driver);
        logger.pass("Click on Profile Picture Button", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

        //Step 1
        element = ep.getUnlockEmail();
        varWat.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        temp = fr.getScreenshot(driver);
        logger.pass("Click unlock email", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

        Assert.assertNotEquals(ep.getEmailVerified2(),email,"Fail: Data match //");
    }


    @Test(groups = {"functest"}, priority = 11)
    public void scenario11() throws IOException, InterruptedException {

        WebDriverWait varWat = new WebDriverWait(driver, 10);
        logger = extent.createTest("Scenario 11", "The user types into the email field a blank space");

        dataArray = fr.turnArray(emailEP, 4);
        email = dataArray[0];
        usernameLo = dataArray[1];
        passwordLo = dataArray[2];

        fr.login(usernameLo, passwordLo, driver);

        EditProfile ep = new EditProfile(driver);

        //Profile Picture
        element = ep.getProfilePicture();
        varWat.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        temp = fr.getScreenshot(driver);
        logger.pass("Click on Profile Picture Button", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());


        //Step 1
        element = ep.getUnlockEmail();
        varWat.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        temp = fr.getScreenshot(driver);
        logger.pass("Click unlock email", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

        //Step 2
        ep.getEditEmail().sendKeys(email);
        temp = fr.getScreenshot(driver);
        logger.pass("Write in the field of the email \n\r\tData: " + email, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        //Step 3
        element = ep.getSaveButton();
        varWat.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        temp = fr.getScreenshot(driver);
        logger.pass("Click on Save button", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

        //Refresh page
        driver.navigate().refresh();

        //Profile Picture
        element = ep.getProfilePicture();
        varWat.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        temp = fr.getScreenshot(driver);
        logger.pass("Click on Profile Picture Button", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

        //Refresh page
        driver.navigate().refresh();


        varWat = new WebDriverWait(driver, 10);

        //Profile Picture
        element = ep.getProfilePicture();
        varWat.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        temp = fr.getScreenshot(driver);
        logger.pass("Click on Profile Picture Button", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

        //Step 1
        element = ep.getUnlockEmail();
        varWat.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        temp = fr.getScreenshot(driver);
        logger.pass("Click unlock email", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());


        Assert.assertNotEquals(ep.getEmailVerified2(),email,"Fail: Data match //");

    }

//////////////////////////////////////////SECOND WAY//////////////////////////////////////////////////////////////////

    @Test(groups = {"functest"}, priority = 12)
    public void scenario3SW() throws IOException, InterruptedException {

        WebDriverWait varWat = new WebDriverWait(driver, 10);
        logger = extent.createTest("Scenario 3 Second Way", "The user types a correct name");

        dataArray = fr.turnArray(nameEP, 3);
        name = dataArray[0];
        usernameLo = dataArray[1];
        passwordLo = dataArray[2];

        fr.login(usernameLo, passwordLo, driver);

        EditProfile ep = new EditProfile(driver);

        //Open the menu
        element = ep.getMenuButton();
        varWat.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        temp = fr.getScreenshot(driver);
        logger.pass("Open the menu", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

        //Profile Button
        element = ep.getProfileButton();
        varWat.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        temp = fr.getScreenshot(driver);
        logger.pass("Click on Profile Button", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());


        //Step 1
        element = ep.getUnlockName();
        varWat.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        temp = fr.getScreenshot(driver);
        logger.pass("Click unlock name", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

        //Step 2
        ep.getEditName().sendKeys(name);
        temp = fr.getScreenshot(driver);
        logger.pass("Write in the field of the name \n\r\tData: " + name, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        //Step 3
        element = ep.getSaveButton();
        varWat.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        temp = fr.getScreenshot(driver);
        logger.pass("Click on Save button", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

        //check alert
        driver.switchTo().alert().accept();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        varWat = new WebDriverWait(driver, 2);

        //Refresh page
        driver.navigate().refresh();


        varWat = new WebDriverWait(driver, 10);

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
        logger.pass("Click unlock email", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

        Assert.assertEquals(ep.getNameVerified2(),name,"Fail: Data match //");
    }

    @Test(groups = {"functest"}, priority = 13)
    public void scenario9SW() throws IOException, InterruptedException {

        WebDriverWait varWat = new WebDriverWait(driver, 10);
        logger = extent.createTest("Scenario 9 Second Way", "The user types its correct email");

        dataArray = fr.turnArray(emailEP, 2);
        email = dataArray[0];
        usernameLo = dataArray[1];
        passwordLo = dataArray[2];

        System.out.println(dataArray);

        fr.login(usernameLo, passwordLo, driver);

        EditProfile ep = new EditProfile(driver);

        //Open the menu
        element = ep.getMenuButton();
        varWat.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        temp = fr.getScreenshot(driver);
        logger.pass("Open the menu", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

        //Profile Button
        element = ep.getProfileButton();
        varWat.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        temp = fr.getScreenshot(driver);
        logger.pass("Click on Profile Button", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());


        //Step 1
        element = ep.getUnlockEmail();
        varWat.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        temp = fr.getScreenshot(driver);
        logger.pass("Click unlock email", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

        //Step 2
        ep.getEditEmail().sendKeys(email);
        temp = fr.getScreenshot(driver);
        logger.pass("Write in the field of the email \n\r\tData: " + email, MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        //Step 3
        element = ep.getSaveButton();
        varWat.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        temp = fr.getScreenshot(driver);
        logger.pass("Click on Save button", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

        //check alert
        driver.switchTo().alert().accept();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        varWat = new WebDriverWait(driver, 2);

        //Refresh page
        driver.navigate().refresh();


        varWat = new WebDriverWait(driver, 10);

        //Profile Picture
        element = ep.getProfilePicture();
        varWat.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        temp = fr.getScreenshot(driver);
        logger.pass("Click on Profile Picture Button", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());

        //Step 1
        element = ep.getUnlockEmail();
        varWat.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        temp = fr.getScreenshot(driver);
        logger.pass("Click unlock email", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());


        Assert.assertEquals(ep.getEmailVerified2(),email,"Fail: Data match //");

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
