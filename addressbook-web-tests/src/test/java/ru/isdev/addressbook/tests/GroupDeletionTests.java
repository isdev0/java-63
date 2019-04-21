package ru.isdev.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.isdev.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() throws Exception {

        app.getNavigationHelper().goToTheGroupPage();

        app.getGroupHelper().checkGroupPresence();

        List<GroupData> before = app.getGroupHelper().getGroupList();

        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToTheGroupPage();

        List<GroupData> after = app.getGroupHelper().getGroupList();

        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }

}
