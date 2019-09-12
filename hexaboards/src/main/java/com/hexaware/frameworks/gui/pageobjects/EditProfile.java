package com.hexaware.frameworks.gui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditProfile {
    WebDriver driver;

    public EditProfile(WebDriver driver) {
        this.driver = driver;
    }
    //Unlock and lock name field into  my profile
    By unlockName = By.xpath("//span[contains(text(),\"Unlock/lock name\")]");
    public WebElement getUnlockName() {
        return driver.findElement(unlockName);
    }

    //Unlock and lock email field into my profile
    By unlockEmail = By.xpath("//Span[contains(text(),\"Unlock/lock e-mail\")]");
    public WebElement getUnlockEmail() {
        return driver.findElement(unlockEmail);
    }

    //field the name
    By editName = By.xpath("//input[@name=\"inName\"]");
    public WebElement getEditName() {
        return driver.findElement(editName);
    }

    //field the e-mail
    By editEmail = By.xpath("//input[@name=\"inMail\"]");
    public WebElement getEditEmail() {
        return driver.findElement(editEmail);
    }

    // Username in the top
    By username = By.id("id=\"usernameh4\"");
    public WebElement getUsername(){
        return driver.findElement(username);
    }

    //Save button into my profile
    By buttonSave = By.xpath("//*[@id=\"fulldialog\"]/form/div[4]/button/span");
    public WebElement getSaveButton() {
        return driver.findElement(buttonSave);
    }

    //Button change photo into my profile
    By photo = By.id("changephoto");
    public WebElement getChangePhoto() {
        return driver.findElement(photo);
    }

    // "X" button close my profile
    By close = By.xpath("//*[@id=\"title-div\"]/div/button");
    public WebElement getCloseEdit()
    {
        return driver.findElement(close);
    }

    //Unlock/lock e-mail into my profile
    By password = By.xpath("//*[@id=\"fulldialog\"]/form/div[3]/div/div[2]/button[2]");
    public WebElement getPassword()
    {
        return driver.findElement(password);
    }

    //Error
    By blankError = By.xpath("//div[@class=\"ng-tns-c14-39 ng-trigger ng-trigger-transitionMessages ng-star-inserted\"]/mat-error");
    public WebElement getBlankError()
    {
        return driver.findElement(blankError);
    }
}
