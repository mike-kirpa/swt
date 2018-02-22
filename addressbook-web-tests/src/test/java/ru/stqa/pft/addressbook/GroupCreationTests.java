package ru.stqa.pft.addressbook;


        import org.testng.annotations.*;


public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreation() throws Exception {
        goToGroups();
        createNewGroup();
        fillGroupForm(new GroupData("test1", "test2", "test3"));
        goToGroups();
    }

}
