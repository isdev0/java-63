package ru.isdev.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.isdev.addressbook.model.GroupData;
import ru.isdev.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().theGroupPage();
        app.group().checkGroupPresence();
    }

    @Test
    public void testGroupModification(){

        Groups before = app.group().all();

        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId())
                .withName("TestGroup1_Edit_name")
                .withHeader("TestGroup1_Edit_header")
                .withFooter("TestGroup1_Edit_footer");
        app.group().modify(group);

        Groups after = app.group().all();

        assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before
                .without(modifiedGroup)
                .withAdded(group)
                )
        );
    }

}
