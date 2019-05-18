package ru.isdev.mantisbt.appmanager;

import biz.futureware.mantis.rpc.soap.client.*;
import ru.isdev.mantisbt.model.Issue;
import ru.isdev.mantisbt.model.Project;

import javax.xml.rpc.ServiceException;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class SoapHelper {

    private ApplicationManager app;
    private String mc_login;
    private String mc_pass;

    public SoapHelper(ApplicationManager app) {
        this.app = app;
        this.mc_login = app.getProperty("web.adminLogin");
        this.mc_pass = app.getProperty("web.adminPass");
    }

    public Set<Project> getProjects() throws RemoteException, MalformedURLException, ServiceException {

        MantisConnectPortType mc = getMantisConnect();

        ProjectData[] projects = mc.mc_projects_get_user_accessible("admin", "secret");
        return Arrays.asList(projects).stream()
                .map(
                        (p) -> new Project()
                                .withId( p.getId().intValue() )
                                .withName( p.getName() )
                                .withDescription( p.getDescription() )
                ).collect(Collectors.toSet());
    }

    private MantisConnectPortType getMantisConnect() throws ServiceException, MalformedURLException {
        return new MantisConnectLocator().getMantisConnectPort(new URL(app.getProperty("web.baseUrl") + app.getProperty("web.soapAdd") + "/mantisconnect.php"));
    }

    public Issue addIssue(Issue issue) throws MalformedURLException, ServiceException, RemoteException {


        MantisConnectPortType mc = getMantisConnect();

        String[] categories = mc.mc_project_get_categories(mc_login, mc_pass, BigInteger.valueOf(issue.getProject().getId()));

        IssueData issueData = new IssueData();
        issueData.setSummary(issue.getSummary());
        issueData.setDescription(issue.getDescription());
        issueData.setProject(new ObjectRef(BigInteger.valueOf(issue.getProject().getId()), issue.getProject().getName()));
        issueData.setCategory(categories[0]);

        BigInteger issueId = mc.mc_issue_add(mc_login, mc_pass, issueData);
        IssueData createdIssueData = mc.mc_issue_get(mc_login, mc_pass, issueId);


        return new Issue()
                .withId(createdIssueData.getId().intValue())
                .withSummary(createdIssueData.getSummary())
                .withDescription(createdIssueData.getDescription())
                .withProject(
                        new Project()
                                .withId( createdIssueData.getProject().getId().intValue() )
                                .withName( createdIssueData.getProject().getName() )
                );
    }

    public String getIssueStatus(int issueId) throws MalformedURLException, ServiceException, RemoteException {
        MantisConnectPortType mc = getMantisConnect();
        return mc.mc_issue_get(mc_login, mc_pass, BigInteger.valueOf(issueId)).getStatus().getName();
    }
}
