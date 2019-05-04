package ru.isdev.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.isdev.addressbook.model.GroupData;
import ru.isdev.addressbook.model.Groups;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validGroups() throws IOException {

        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(
                new FileReader(
                        new File("src/test/resources/groups.csv")
                )
        );

        String line = reader.readLine();

        while(line != null){
            String[] splited = line.split(";");

            list.add(new Object[]{
                    new GroupData()
                            .withName(splited[0])
                            .withHeader(splited[1])
                            .withFooter(splited[2])
            });

            line = reader.readLine();
        }

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
