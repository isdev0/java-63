package ru.isdev.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.isdev.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {

        app.getNavigationHelper().goToTheGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();

        GroupData group = new GroupData("TestGroup1_name", "TestGroup1_header", null);

        app.getGroupHelper().createGroup(group);
        List<GroupData> after = app.getGroupHelper().getGroupList();

        Assert.assertEquals(after.size(), before.size() + 1);

        int maxIndex = 0;
        for(GroupData g: after){
            if(g.getId() > maxIndex){
                maxIndex = g.getId();
            }
        }

        group.setId(maxIndex);
        before.add(group);

        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }

}
