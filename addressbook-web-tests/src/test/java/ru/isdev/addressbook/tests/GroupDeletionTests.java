package ru.isdev.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.isdev.addressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() throws Exception {

        app.getNavigationHelper().goToTheGroupPage();

        app.getGroupHelper().checkGroupPresence();

        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();

        app.getGroupHelper().returnToTheGroupPage();

    }

}
