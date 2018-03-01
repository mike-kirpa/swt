package ru.stqa.pft.sandbox.addressbook.tests;


        import org.testng.annotations.*;
        import ru.stqa.pft.sandbox.addressbook.model.GroupData;


public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreation() throws Exception {
        app.getNavigationHelper().goToGroups();
        app.getGroupHelper().createNewGroup();
        app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
        app.getNavigationHelper().goToGroups();
        app.getGroupHelper().submitGroupCreation();
    }

}
