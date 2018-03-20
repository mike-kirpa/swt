package ru.stqa.pft.addressbook.tests;


        import org.testng.annotations.*;
        import ru.stqa.pft.addressbook.model.GroupData;


public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreation(){
        app.getNavigationHelper().goToGroups();
        app.getGroupHelper().createNewGroup();
        app.getGroupHelper().fillGroupForm(new GroupData("test1", null, null));
        app.getGroupHelper().submitGroupCreation();
        app.getNavigationHelper().goToGroups();
    }

}