package ru.isdev.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.isdev.addressbook.model.GroupData;
import ru.isdev.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().theGroupPage();
        if(app.db().groups().size() == 0) {
            app.group().create(new GroupData().withName("TestGroup1_name").withHeader("TestGroup1_header"));
        }
    }

    @Test
    public void testGroupDeletion() throws Exception {

        Groups before = app.db().groups();

        GroupData deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);

        Groups after = app.db().groups();

        assertEquals(after.size(), before.size() - 1);
        assertThat(after, equalTo( before.without(deletedGroup) ));
    }

}
