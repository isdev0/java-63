package ru.isdev.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.isdev.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().theGroupPage();
        app.group().checkGroupPresence();
    }

    @Test
    public void testGroupModification(){

        List<GroupData> before = app.group().list();
        int index  = before.size() - 1;
        GroupData group = new GroupData(before.get(index).getId(), "TestGroup1_Edit_name", "TestGroup1_Edit_header", "TestGroup1_Edit_footer");

        app.group().modify(index, group);

        List<GroupData> after = app.group().list();

        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }

}
