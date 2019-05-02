package ru.isdev.addressbook.tests;

import org.testng.annotations.*;
import ru.isdev.addressbook.model.GroupData;
import ru.isdev.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().theGroupPage();
    }

    @Test
    public void testGroupCreation() throws Exception {

        Groups before = app.group().all();

        GroupData group = new GroupData()
                .withName("TetGroup1_name")
                .withHeader("TestGroup1_header");
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
