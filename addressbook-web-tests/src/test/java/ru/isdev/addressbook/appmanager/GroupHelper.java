package ru.isdev.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.isdev.addressbook.model.GroupData;
import ru.isdev.addressbook.model.Groups;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void selectById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void deleteSelectedGroups() {
        click(By.name("delete"));
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void returnToTheGroupPage() {
        click(By.linkText("group page"));
    }

    public void create(GroupData group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToTheGroupPage();
    }

    public void modify(GroupData group) {
        selectById(group.getId());
        initGroupModification();
        fillGroupForm(group);
        submitGroupModification();
        returnToTheGroupPage();
    }

    public void delete(GroupData group) {
        selectById(group.getId());
        deleteSelectedGroups();
        returnToTheGroupPage();
    }

    public void checkGroupPresence() {
        if(all().size() == 0){
            create(new GroupData().withName("TestGroup1_name").withHeader("TestGroup1_header"));
        }
    }

    public Groups all() {
        Groups groups = new Groups();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for(WebElement element: elements){
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("Value"));
            String name = element.getText();
            groups.add(new GroupData().withId(id).withName(name));
        }
        return groups;
    }

}
