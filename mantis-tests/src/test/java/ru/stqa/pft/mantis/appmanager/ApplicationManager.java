package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ApplicationManager {
    private final Properties properties;
    WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();
    private String browser;


    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();

    }

    public void init() throws IOException {
        //получаем значение target или подставляем дефолтное
        String target = System.getProperty("target", "local");
        //из файла с названием с учетом значения из target, читаем ключи и значения в систем пропертис
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));


        System.setProperty(
                "webdriver.chrome.driver",
                getResource("/chromedriver.exe"));
        System.setProperty(
                "webdriver.gecko.driver",
                getResource("/geckodriver.exe"));
        if (browser.equals(BrowserType.CHROME)) {
            driver = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)) {
            driver = new FirefoxDriver();
        } else if (browser.equals(BrowserType.IE)) {
            driver = new InternetExplorerDriver();
        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(properties.getProperty("web.baseURL"));

    }

    public String getResource(String resourceName) {
        try {
            return Paths.get(ApplicationManager.class.getResource(resourceName).toURI()).toFile().getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return resourceName;
    }

    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}
