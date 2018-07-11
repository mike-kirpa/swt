package ru.stqa.pft.addressbook.appmanger;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper {
    protected WebDriver driver;

    public ContactHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void initContactCreation() {
        clickOn(By.linkText("add new"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        atach(By.name("photo"), contactData.getPhoto().getAbsoluteFile());
        if (creation) {
            if(contactData.getGroups().size() > 0){
                Assert.assertTrue(contactData.getGroups().size() == 1);
                new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroups().iterator().next().getGroupName());
            }
        } else {
           Assert.assertFalse(isElementPresent(By.name("new_group")));
        }


    }

    public Set<ContactData> all() {
        Set<ContactData> contacts = new HashSet<ContactData>();
        List<WebElement> rows = driver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String lastname = cells.get(1).getText();
            String firstname =cells.get(2).getText();
            String AllPhones =cells.get(5).getText();
            contacts.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname).withAllPhones(AllPhones));
        }
        return contacts;
    }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = driver.findElement(By.name("firstname")).getAttribute("value");
        String lastname = driver.findElement(By.name("lastname")).getAttribute("value");
        String home = driver.findElement(By.name("home")).getAttribute("value");
        String mobile = driver.findElement(By.name("mobile")).getAttribute("value");
        String work = driver.findElement(By.name("work")).getAttribute("value");
        driver.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
                .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
    }

    public void submitContactCreation() {
        driver.findElement(By.name("submit")).click();
    }

    public void initContactModification() {
        driver.findElement(By.cssSelector("img[alt='Edit']"));
    }

    public void initContactModificationById(int id) {
        WebElement checkbox = driver.findElement(By.cssSelector(String.format("input[value='%s']", id)));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();

        //driver.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
    }

    protected void clickOn(By locator) {
        driver.findElement(locator).click();
    }

    public void submitContactModification() {
        driver.findElement(By.name("update"));
    }

    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
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

}
