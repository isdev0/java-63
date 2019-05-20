package ru.isdev.rest;

import com.jayway.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class RestTests extends TestBase{

    @BeforeClass
    public void init() {
        RestAssured.authentication = RestAssured.basic("288f44776e7bec4bf44fdfeb1e646490", "");
    }
    @Test
    public void testCreatreIssue() throws IOException {

        long now = System.currentTimeMillis();

        skipIfNotFixed(1);

        Set<Issue> oldIssues = getIssues();
        Issue newIssue = new Issue()
                .withSubject( String.format("Subject of issue #%s", now))
                .withDescription( String.format("Description of issue #", now));

        int issueId = createIssue(newIssue);

        Set<Issue> newIssues = getIssues();
        oldIssues.add(newIssue.withId(issueId));

        assertEquals(newIssues, oldIssues);
    }

}
