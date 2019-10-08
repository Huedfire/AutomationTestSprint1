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

    /////////////////////extra objects//////////

    //expansion panel, all projects
    By expansionPanel = By.xpath("//mat-expansion-panel-header[@tabindex=\"0\"]");
    public WebElement getExpansionPanel() {
        return driver.findElement(expansionPanel);
    }
    //open button
    By openButton = By.xpath("//button[@class=\"openbutton mat-raised-button mat-primary\"]/span[@class=\"mat-button-wrapper\"]");
    public WebElement getOpenButton() {
        return driver.findElement(openButton);
    }
    //click on sprint1
    By sprint1 = By.xpath("//*[contains(text(), \"Sprint 1\")]");
    public WebElement getSprint1(){ return driver.findElement(sprint1);  }

    //Go to board button
    By GoToBtn = By.xpath("//div[@id=\"cdk-accordion-child-1\"]/div/div/button/span");
    public WebElement getGoToBtn(){ return driver.findElement(GoToBtn); }

    //First task backlog
    By firstBacklog = By.xpath("//*[@id=\"cdk-drop-list-0\"]/div[1]");
    public WebElement getFirstBacklog(){ return driver.findElement(firstBacklog); }

    //first task todo
    By firstToDo = By.xpath("//*[@id=\"cdk-drop-list-1\"]/div");
    public WebElement getFirstToDo() { return driver.findElement(firstToDo); }

    //objects to check sprint 2
    //click on sprint 2
    By sprint2 = By.xpath("//mat-expansion-panel-header[@aria-controls=\"cdk-accordion-child-2\"]");
    public WebElement getSprint2(){ return driver.findElement(sprint2);  }
    //Go to board button
    By GoToBtn2 = By.xpath("//div[@id=\"cdk-accordion-child-2\"]/div/div/button/span");
    public WebElement getGoToBtn2(){ return driver.findElement(GoToBtn2); }

    /////////Button end Sprint/////////////
    By EndSprint = By.xpath("//button/span[contains(text(),\"End Sprint\")]");
    public WebElement getEndSprint(){return driver.findElement(EndSprint);}

    //////Label Done on End Sprint///////
    By Done = By.xpath("//div/h2[contains(text(),\"Done\")]");
    public WebElement getDone(){return driver.findElement(Done);}

    //Inprogress div
    By InProgDiv = By.xpath("//*[@id=\"cdk-drop-list-2\"]");
    public WebElement getInProgDiv(){ return driver.findElement(InProgDiv); }

}
