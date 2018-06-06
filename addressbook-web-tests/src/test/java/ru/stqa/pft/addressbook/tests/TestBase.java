package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanger.ApplicationManager;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

    protected static ApplicationManager app;
    //создаем логер
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    static {
        try {
            app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws IOException {app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown()  {
        app.stop();
    }

    @BeforeMethod
    public void logTestStart(Method m, Object[] p){
        logger.info("Start test" + m.getName() + "with parameters" + Arrays.asList(p));

    }

    @AfterMethod(alwaysRun = true)
    public void losTestStop(Method m, Object[] p){
        logger.info("Stop test" + m.getName() + "with parameters" + Arrays.asList(p));
    }

}
