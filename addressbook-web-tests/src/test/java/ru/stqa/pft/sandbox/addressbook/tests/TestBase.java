package ru.stqa.pft.sandbox.addressbook.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.stqa.pft.sandbox.addressbook.appmanger.ApplicationManager;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager();

    @BeforeClass(alwaysRun = true)
    public void setUp()  {
        app.init();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown()  {
        app.stop();
    }

}
