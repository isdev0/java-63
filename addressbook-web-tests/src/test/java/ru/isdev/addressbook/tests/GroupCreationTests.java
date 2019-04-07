package ru.isdev.addressbook.tests;

import org.testng.annotations.*;
import ru.isdev.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.getNavigationHelper().goToTheGroupPage();
        app.getGroupHelper().createGroup(new GroupData("TestGroup1_name", "TestGroup1_header", null));
    }

}
