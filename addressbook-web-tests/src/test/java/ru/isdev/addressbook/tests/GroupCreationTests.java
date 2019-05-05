package ru.isdev.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.isdev.addressbook.model.GroupData;
import ru.isdev.addressbook.model.Groups;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validGroups_CSV() throws IOException {

        List<Object[]> list = new ArrayList<>();

        try(
            BufferedReader reader = new BufferedReader(
                    new FileReader(
                            new File("src/test/resources/groups.csv")
                    )
            )
        ) {
            String line = reader.readLine();

            while (line != null) {
                String[] splited = line.split(";");

                list.add(new Object[]{
                        new GroupData()
                                .withName(splited[0])
                                .withHeader(splited[1])
                                .withFooter(splited[2])
                });

                line = reader.readLine();
            }
        }

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> validGroups_XML() throws IOException {

        try(
            BufferedReader reader = new BufferedReader(
                new FileReader(
                        new File("src/test/resources/groups.xml")
                )
            )
        ){
            String line = reader.readLine();
            String xml = "";

            while (line != null) {
                xml += line;
                line = reader.readLine();
            }

            XStream xstream = new XStream();
            xstream.alias("group",GroupData.class);
            xstream.omitField(GroupData.class,"id");

            List<GroupData> groups = (List<GroupData>) xstream.fromXML(xml);


            return groups.stream()
                    .map( (g) -> new Object[]{g} )
                    .collect(Collectors.toList())
                    .iterator();
        }
    }

    @DataProvider
    public Iterator<Object[]> validGroups_JSON() throws IOException {

        try(
            BufferedReader reader = new BufferedReader(
                    new FileReader(
                            new File("src/test/resources/groups.json")
                    )
            )
        ){

            String line = reader.readLine();
            String json = "";

            while (line != null) {
                json += line;
                line = reader.readLine();
            }

            Gson gson = new Gson();
            List<GroupData> groups = gson.fromJson(json, new TypeToken<List<GroupData>>() {
            }.getType());

            return groups.stream()
                    .map((g) -> new Object[]{g})
                    .collect(Collectors.toList())
                    .iterator();
        }
    }

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().theGroupPage();
    }

    @Test(dataProvider = "validGroups_JSON")
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
