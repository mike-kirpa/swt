package ru.stqa.pft.addressbook.appmanger;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

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

    public void selectGroup(int index) {

        driver.findElements(By.name("selected[]")).get(index).click();
    }

    public void initGroupModification() {
        driver.findElement(By.name("edit")).click();
    }

    public void submitGroupModyfication() {
        driver.findElement(By.name("update")).click();
    }

    public void createGroup(GroupData group) {
        createNewGroup();
        fillGroupForm(group);
        submitGroupCreation();
        driver.findElement(By.linkText("groups")).click();
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isThereAgroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getGroupCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public List<GroupData> getGroupList() {
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            GroupData group = new GroupData(id, name, null, null);
            groups.add(group);
        }
        return groups;
    }
}
