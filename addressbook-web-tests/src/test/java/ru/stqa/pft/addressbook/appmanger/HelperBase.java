package ru.stqa.pft.addressbook.appmanger;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class HelperBase {
    protected WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    protected void clickOn(By locator) {
        driver.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        clickOn(locator);
        if (text != null) {
            String existingText = driver.findElement(locator).getAttribute("value");
            if(! text.equals(existingText)) {
                driver.findElement(locator).click();
                driver.findElement(locator).sendKeys(text);
            }
        }
    }


    protected void atach(By locator, File file) {

        if (file != null) {
                driver.findElement(locator).sendKeys(file.getAbsolutePath());
            }
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
