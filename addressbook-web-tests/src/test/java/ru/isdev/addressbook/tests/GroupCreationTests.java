package ru.isdev.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.isdev.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {

        int maxIndex;

        app.goTo().theGroupPage();
        List<GroupData> before = app.group().list();

        GroupData group = new GroupData("TestGroup1_name", "TestGroup1_header", null);

        app.group().create(group);
        List<GroupData> after = app.group().list();

        Assert.assertEquals(after.size(), before.size() + 1);

        // Java 6 compatible code
        /*
        maxIndex = 0;
        for(GroupData g: after){
            if(g.getId() > maxIndex){
                maxIndex = g.getId();
            }
        }
        */

        // Java 8 compatible code
        maxIndex = after.stream().max(Comparator.comparingInt(GroupData::getId)).get().getId();

        group.setId(maxIndex);
        before.add(group);

        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }

}
