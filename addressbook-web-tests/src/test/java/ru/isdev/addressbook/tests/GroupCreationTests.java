package ru.isdev.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
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
    public Iterator<Object[]> validGroups() throws IOException {

        String format="json";

        List<Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(
                new FileReader(
                        new File("src/test/resources/groups." + format)
                )
        );

        String line = reader.readLine();

        if(format.equals("csv")){

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

        }else if(format.equals("xml")) {

            String xml = "";

            while (line != null) {
                xml += line;
                line = reader.readLine();
            }

            XStream xstream = new XStream();
            xstream.alias("group",GroupData.class);
            xstream.omitField(GroupData.class,"id");

            List<GroupData> groups = (List<GroupData>) xstream.fromXML(xml);
            list = groups.stream()
                    .map( (g) -> new Object[]{g} )
                    .collect(Collectors.toList());

        }else if(format.equals("json")) {

            String json = "";

            while (line != null) {
                json += line;
                line = reader.readLine();
            }

            Gson gson = new Gson();
            List<GroupData> groups = gson.fromJson(json, new TypeToken<List<GroupData>>(){}.getType());
            list = groups.stream()
                    .map( (g) -> new Object[]{g} )
                    .collect(Collectors.toList());
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
