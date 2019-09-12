package com.hexaware.frameworks.gui.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectSetup {

    WebDriver driver;

    public ProjectSetup(WebDriver driver) {
        this.driver = driver;
    }


    By expansionPanel = By.xpath("//mat-expansion-panel-header[@style=\"height: 64px;\"]");

    public WebElement getExpansionPanel() {
        return driver.findElement(expansionPanel);
    }

    By openButton = By.xpath("//button[@class=\"openbutton mat-raised-button mat-primary\"]/span[@class=\"mat-button-wrapper\"]");

    public WebElement getOpenButton() {
        return driver.findElement(openButton);
    }

    By changePhoto = By.xpath("//div[@class=\"divchangepho\"]/mat-icon[@role=\"img\"]");

    public WebElement getChangePhoto() {
        return driver.findElement(changePhoto);
    }

    By editDescriptionTextArea = By.xpath(" //div[@class=\"mat-form-field-infix\"]/textarea[@name=\"inDesc\"]");

    public WebElement getEditDescriptionTextArea() {
        return driver.findElement(editDescriptionTextArea);
    }

    By editDescriptionButton = By.xpath("//button[@type=\"submit\"]/span[@class=\"mat-button-wrapper\"]");

    public WebElement getEditDescriptionButton() {
        return driver.findElement(editDescriptionButton);
    }


    By addSprintButton = By.xpath("//span[contains(text(), \"Add Sprint\")]");

    public WebElement getAddSprintButton() {
        return driver.findElement(addSprintButton);
    }

    By sprintNameTextArea = By.xpath("//input[@type=\"text\"]");

    public WebElement getSprintNameTextArea() {
        return driver.findElement(sprintNameTextArea);
    }


    By createButton = By.xpath("//span[contains(text(), \"Create\")]");

    public WebElement getCreateButton() {
        return driver.findElement(createButton);
    }


    By expansionPanelSprints = By.xpath("//div[@class=\"secondrow\"]/div/div[1]/div[1]");

    public WebElement getExpansionPanelSprints() {
        return driver.findElement(expansionPanelSprints);
    }

    By goToBoardButton = By.xpath("//span[contains (text(), \"Go to Board\")]");

    public WebElement getGoToBoardButton() {
        return driver.findElement(goToBoardButton);
    }

    By expansionPanelMembers = By.xpath("//div[@name=\"membersdiv\"]/div[@class=\"expan\"]");

    public WebElement getExpansionPanelMembers() {
        return driver.findElement(expansionPanelMembers);
    }

    By statsButton = By.xpath("//span[contains (text(), \"Stats\")]");

    public WebElement getStatsButton() {
        return driver.findElement(statsButton);
    }


    By editRoleButton = By.xpath("//span[contains (text(), \"Edit Role\")]");

    public WebElement getEditRoleButton() {
        return driver.findElement(editRoleButton);
    }

    By editRoleList = By.xpath("//select[@ng-reflect-form=\"[object Object]\"]");

    public WebElement getEditRoleList() {
        return driver.findElement(editRoleList);
    }

    By saveButtonEditRole = By.xpath("//span[contains (text(), \"Save\")]");

    public WebElement getSaveButtonEditRole() {
        return driver.findElement(saveButtonEditRole);
    }

    By deleteButtonMember = By.xpath("//span[contains (text(), \"Delete\")]");

    public WebElement getDeleteButtonMember() {
        return driver.findElement(deleteButtonMember);
    }

    By addMemberButton = By.xpath("//span[contains(text(), \"Add Member\")]");

    public WebElement getAddMemberButton() {
        return driver.findElement(addMemberButton);
    }
}
