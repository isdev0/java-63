package ru.isdev.addressbook.tests;

import org.testng.annotations.Test;
import ru.isdev.addressbook.model.GroupData;

public class GroupModifictionTests extends TestBase {

    @Test
    public void testGroupModification(){

        app.getNavigationHelper().goToTheGroupPage();

        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("TestGroup1_Edit_name", "TestGroup1_Edit_header", "TestGroup1_Edit_footer"));
        app.getGroupHelper().submitGroupModification();

        app.getNavigationHelper().returnToTheGroupPage();

    }
}