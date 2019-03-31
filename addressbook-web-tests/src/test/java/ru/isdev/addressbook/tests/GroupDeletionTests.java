package ru.isdev.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.goToTheGroupPage();
    app.selectGroup();
    app.deleteSelectedGroups();
    app.returnToTheGroupPage();
  }

}
