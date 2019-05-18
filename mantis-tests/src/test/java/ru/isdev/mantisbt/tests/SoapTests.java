package ru.isdev.mantisbt.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.isdev.mantisbt.model.Issue;
import ru.isdev.mantisbt.model.Project;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class SoapTests extends TestBase {

    @Test
    public void testGetProjects() throws MalformedURLException, ServiceException, RemoteException {

        Set<Project> projects = app.soap().getProjects();
        System.out.println(projects.size());

        for(Project project: projects) {
            System.out.println(project.getName() + " - " + project.getDescription());

        }
    }

    @Test
    public void testCreateIssu() throws RemoteException, ServiceException, MalformedURLException {

        Set<Project> projects = app.soap().getProjects();

        Issue issue = new Issue()
                .withSummary("Test issue 1")
                .withDescription("Test issue 1 description")
                .withProject(projects.iterator().next());

        Issue created = app.soap().addIssue(issue);

        assertEquals(issue.getSummary(), created.getSummary());
    }

}
