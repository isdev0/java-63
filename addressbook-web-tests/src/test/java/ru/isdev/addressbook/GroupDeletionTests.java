package ru.isdev.addressbook;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    goToTheGroupPage();
    selectGroup();
    deleteSelectedGroups();
    returnToTheGroupPage();
  }

}
