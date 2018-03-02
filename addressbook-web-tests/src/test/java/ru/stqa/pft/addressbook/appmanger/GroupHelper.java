package ru.stqa.pft.addressbook.appmanger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupHelper {
    private WebDriver driver;

    public GroupHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getGroupName());
        type(By.name("group_header"), groupData.getHeaderName());
        type(By.name("group_footer"), groupData.getFooterName());
    }

    protected void type(By locator, String text) {
        if (text != null) {
            if (!driver.findElement(locator).getAttribute("value").equals(text)){
                driver.findElement(locator).click();
                driver.findElement(locator).clear();
                driver.findElement(locator).sendKeys(text);
            }
        }
    }

    public void submitGroupCreation() {
        driver.findElement(By.name("submit")).click();
    }

    public void createNewGroup() {
        driver.findElement(By.name("new")).click();
    }

    public void deleteSelectedGroups() {
        driver.findElement(By.name("delete")).click();
    }

    public void selectGroup() {
        driver.findElement(By.name("selected[]")).click();
    }

    public void initGroupModification() {
        driver.findElement(By.name("edit")).click();
    }

    public void submitGroupModyfication() {
        driver.findElement(By.name("update")).click();
    }
}
