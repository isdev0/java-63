package ru.isdev.addressbook.tests;

import org.testng.annotations.*;
import ru.isdev.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.getGroupHelper().goToTheGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("TestGroup1_name", "TestGroup1_header", "TestGroup1_footer"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToTheGroupPage();
    }


}
