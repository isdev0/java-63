package ru.isdev.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.isdev.addressbook.model.GroupData;
import ru.isdev.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validGroups(){

        List<Object[]> list = new ArrayList<Object[]>();

        list.add(new Object[] {
                new GroupData()
                        .withName("TetGroup1_name")
                        .withHeader("TestGroup1_header")
        });

        list.add(new Object[] {
                new GroupData()
                        .withName("TetGroup2_name")
                        .withHeader("TestGroup2_header")
        });

        return list.iterator();
    }

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().theGroupPage();
    }

    @Test(dataProvider = "validGroups")
    public void testGroupCreation(GroupData group) throws Exception {

        Groups before = app.group().all();
        app.group().create(group);
        Groups after = app.group().all();

        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo(
                before.withAdded(
                        group.withId(
                                after.stream().mapToInt(GroupData::getId).max().getAsInt()
                        )
                )
            )
        );
    }

}
