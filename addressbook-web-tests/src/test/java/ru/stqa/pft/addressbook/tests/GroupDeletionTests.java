package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() {
      app.goToGroups();
      app.selectGroup();
      app.deleteSelectedGroups();
      app.goToGroups();
  }

}
