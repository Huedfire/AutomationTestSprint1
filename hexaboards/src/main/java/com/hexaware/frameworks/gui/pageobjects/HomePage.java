package com.hexaware.frameworks.gui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    ////////////////////////////////////////////////////////////////////////////////////
    //Logo
    By logos = By.id("logo");
    public WebElement getLogo() {
        return driver.findElement(logos);
    }
    //Button home
    By home = By.xpath("//a[contains(text(),'Home')]");
    public WebElement getHomeValue() {
        return driver.findElement(home);
    }
    //Button about
    By About = By.xpath("//a[contains(text(),'About')]");
    public WebElement getAboutValue() {
        return driver.findElement(About);
    }
    //Button getting started
    By getStart = By.xpath("//span[contains(text(),'Getting Started')]");
    public WebElement getStartedValue() {
        return driver.findElement(getStart);
    }
    //Login into getting started
    By getLogin = By.xpath("//*[@id=\"cdk-overlay-0\"]/div/div/button[1]");
    public WebElement getLogin() {
        return driver.findElement(getLogin);
    }
    //Register into getting started
    By getRegister = By.xpath("//*[@id=\"cdk-overlay-0\"]/div/div/button[2]");
    public WebElement getRegister() {
        return driver.findElement(getRegister);
    }
    //Docs into getting started
    By getDocs = By.xpath("//*[@id=\"cdk-overlay-0\"]/div/div/button[3]");
    public WebElement getDocs() {
        return driver.findElement(getDocs);
    }
    //Big Logo
    By bigLogo = By.id("home-logo");
    public WebElement getBigLogo() {
        return driver.findElement(bigLogo);
    }
    //Grapth logo
    By Graph = By.id("graph");
    public WebElement getGraphlogo() {
        return driver.findElement(Graph);
    }
    //This is a web page
    By PageDesc = By.xpath("//h1[contains(text(),'This is a web page,' )]");
    public WebElement getDescriptionPage() {
        return driver.findElement(PageDesc);
    }
    //Get started button to the bottom
    By GetStartedButton = By.xpath("//span[contains(text(),'Get Started')]");
    public WebElement getStartedButton() {
        return driver.findElement(GetStartedButton);
    }

    //Button login into get started
    By login = By.xpath("//a[contains(text(),\"Log In\")]");
    public WebElement getLogins() {
        return driver.findElement(login);
    }
}
