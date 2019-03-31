package ru.isdev.addressbook;

import org.testng.annotations.*;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        goToTheGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("TestGroup1_name", "TestGroup1_header", "TestGroup1_footer"));
        submitGroupCreation();
        returnToTheGroupPage();
    }


}
