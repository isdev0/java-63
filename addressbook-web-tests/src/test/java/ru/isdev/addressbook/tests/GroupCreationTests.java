package ru.isdev.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.isdev.addressbook.model.GroupData;

import java.util.Set;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {

        int maxIndex;

        app.goTo().theGroupPage();
        Set<GroupData> before = app.group().all();

        GroupData group = new GroupData().withName("TetGroup1_name").withHeader("TestGroup1_header");

        app.group().create(group);
        Set<GroupData> after = app.group().all();

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
        //maxIndex = after.stream().max(Comparator.comparingInt(GroupData::getId)).get().getId();
        maxIndex = after.stream().mapToInt(GroupData::getId).max().getAsInt();

        group.withId(maxIndex);
        before.add(group);

        Assert.assertEquals(before, after);
    }

}
