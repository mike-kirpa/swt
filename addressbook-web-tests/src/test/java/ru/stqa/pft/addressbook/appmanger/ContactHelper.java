package ru.stqa.pft.addressbook.appmanger;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper {
    private WebDriver driver;

    public ContactHelper(WebDriver driver) {
        //super(driver);
        this.driver = driver;
    }

    public void initContactCreation() {
        driver.findElement(By.linkText("add new")).click();
    }

    public void fillContactForm(ContactData contactData) {
        driver.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
        driver.findElement(By.name("lastname")).sendKeys(contactData.getLastname());

        if (isElementPresent(By.name("new_group"))) {
            new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());    
        }
    }

    private boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public void submitContactCreation() {
        driver.findElement(By.name("submit"));
    }

    public void initContactModification() {
        driver.findElement(By.cssSelector("img[alt='Edit']"));
    }

    public void submitContactModification() {
        driver.findElement(By.name("update"));
    }

}
