package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanger.ApplicationManager;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

public class TestBase {

    protected static ApplicationManager app;
    //������� �����
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

    //���������� ���� ������ ������ ����� �� �� � ��
    public void verifyGroupListInUI() {
        if (Boolean.getBoolean("verifyUI")){
            Groups dbGroups = app.db().groups();
            Groups uiGroups = app.group().all();
            MatcherAssert.assertThat(uiGroups, CoreMatchers.equalTo(dbGroups.stream().map((g)->new GroupData().withId(g.getId()).withGroupName(g.getGroupName())).collect(Collectors.toSet())));
        }

    }

}
