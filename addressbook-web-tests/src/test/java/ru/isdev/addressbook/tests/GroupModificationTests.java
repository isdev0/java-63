package ru.isdev.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.isdev.addressbook.model.GroupData;

import java.util.Set;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().theGroupPage();
        app.group().checkGroupPresence();
    }

    @Test
    public void testGroupModification(){

        Set<GroupData> before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId())
                .withName("TestGroup1_Edit_name")
                .withHeader("TestGroup1_Edit_header")
                .withFooter("TestGroup1_Edit_footer");
        app.group().modify(group);

        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modifiedGroup);
        before.add(group);
        Assert.assertEquals(before, after);
    }

}
