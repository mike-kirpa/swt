package ru.stqa.pft.sandbox.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.sandbox.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase{
    @Test
    public void testGroupModification(){
        app.getNavigationHelper().goToGroups();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("test3", "test1", "test2"));
        app.getGroupHelper().submitGroupModyfication();
        app.getNavigationHelper().goToGroups();
    }
}
