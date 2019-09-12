package com.hexaware.frameworks.gui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BoardPage {
    WebDriver driver;

    public BoardPage(WebDriver driver) {
        this.driver = driver;
    }
    ////////////////////////////Page Objects/////////////////////////////////////////////

    //Settings icon
    By settingsIcon = By.xpath("//mat-icon[@id=\"settings-icon\"]");
    public WebElement getSettingsIcon() {
        return driver.findElement(settingsIcon);
    }

    //my profile option
    By myProfile = By.xpath("//img[@alt=\"user-photo\"]");
    public WebElement getMyProfile() {
        return driver.findElement(myProfile);
    }


    // Options of the burger button when the user click
    //Burger button
    By burgerOptions = By.xpath("//button[@mattooltip='Open the menu.']");
    public WebElement getOptionIcon() {
        return driver.findElement(burgerOptions);
    }

    //Options of the burger button
    By options = By.xpath("//mat-sidenav[@tabindex=\"-1\"]/div");
    public WebElement getMyOptions() {
        return driver.findElement(options);
    }

    //my profile option
    By profiles = By.xpath("//mat-nav-list[@role=\"navigation\"]/a[1]");
    public WebElement getMyProfiles() {
        return driver.findElement(profiles);
    }

    //my projects option
    By myProjects = By.xpath("//mat-nav-list[@role=\"navigation\"]/a[2]");
    public WebElement getMyProject() {
        return driver.findElement(myProjects);
    }

    //settings option
    By settings = By.xpath("//mat-nav-list[@role=\"navigation\"]/a[3]");
    public WebElement getSettings() {
        return driver.findElement(settings);
    }

    //sign out option
    By signOut = By.xpath("//mat-nav-list[@role=\"navigation\"]/a[4]");
    public WebElement getSignOut() {
        return driver.findElement(signOut);
    }

    //newproject button option
    By newProjectButton = By.xpath("//button[@class=\"btnproject mat-raised-button mat-primary\"]");
    public WebElement getNewProjectBar() {
        return driver.findElement(newProjectButton);
    }

    //////////////////////////Board Objects///////////////////////////////////////////////////////////////

    //Logo Backlog
    By backlogLogo = By.xpath("//*[contains(text(),\"Backlog\")]");
    public WebElement getBacklog() {
        return driver.findElement(backlogLogo);
    }

    //Logo TO Do
    By toDo = By.xpath("//*[contains(text(),\"To Do\")]");
    public WebElement getToDo() {
        return driver.findElement(toDo);
    }

    //Logo In Progress
    By progress = By.xpath("//*[contains(text(),\"In Progress\")]");
    public WebElement getProgress() {
        return driver.findElement(progress);
    }

    //Logo Test
    By test = By.xpath("//*[contains(text(),\"Test\")]");
    public WebElement getTest() {
        return driver.findElement(test);
    }


    //Logo Review
    By review = By.xpath("//*[contains(text(),\"Review\")]");
    public WebElement getReviewLogo() {
        return driver.findElement(review);
    }

    //Logo Done
    By done = By.xpath("//*[contains(text(),\"Done\")]");
    public WebElement getDoneLogo() {
        return driver.findElement(done);
    }

    //Button Add Story
    By story = By.xpath("//*[contains(text(),\"Add Story\")]");
    public WebElement getAddStoryButton() {
        return driver.findElement(story);
    }

    //Button End Sprint
    By sprint = By.xpath("//*[contains(text(),\"End Sprint\")]");
    public WebElement getEndSprintButton() {
        return driver.findElement(sprint);
    }

    //Backlog field
    By backlogField = By.xpath("//*[@ng-reflect-id=\"cdk-drop-list-0\"]");
    public WebElement getBacklogField() {
        return driver.findElement(backlogField);
    }

    //To Do field
    By toDoField = By.xpath("//*[@ng-reflect-id=\"cdk-drop-list-1\"]");
    public WebElement getToDoField() {
        return driver.findElement(toDoField);
    }

    //In Progress field
    By inProgressField = By.xpath("//*[@ng-reflect-id=\"cdk-drop-list-2\"]");
    public WebElement getInProgressField() {
        return driver.findElement(inProgressField);
    }

    //Test field
    By testField = By.xpath("//*[@ng-reflect-id=\"cdk-drop-list-3\"]");
    public WebElement getTestField() {
        return driver.findElement(testField);
    }

    //Review field
    By reviewField = By.xpath("//*[@ng-reflect-id=\"cdk-drop-list-4\"]");
    public WebElement getReviewField() {
        return driver.findElement(reviewField);
    }

    //Done field
    By doneField = By.xpath("//*[@ng-reflect-id=\"cdk-drop-list-5\"]");
    public WebElement getDoneField() {
        return driver.findElement(doneField);
    }

}
