package ru.stqa.pft.addressbook.appmanger;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class NavigationHelper  {
    private WebDriver driver;

    public NavigationHelper(WebDriver driver) {
        //super(driver);
        this.driver = driver;
    }

    public void groupPage() {
        if (isElementPresent(By.tagName("h1"))
                && driver.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new"))) {
            return;
        }
        driver.findElement(By.linkText("groups")).click();
    }

    public void gotoHomepage() {
        if (isElementPresent(By.id("maintable"))){
            return;
        }
        driver.findElement(By.linkText("home")).click();
    }

    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
}
