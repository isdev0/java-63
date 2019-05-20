package ru.isdev.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.jayway.restassured.RestAssured;
import org.apache.http.client.fluent.Executor;
import org.testng.SkipException;

import java.io.IOException;
import java.util.Set;

public class TestBase {

    protected Set<Issue> getIssues() throws IOException {

        String json = RestAssured.get("http://bugify.stqa.ru/api/issues.json?limit=500").asString();

        JsonElement parsed = new JsonParser().parse(json);
        JsonElement issues = parsed.getAsJsonObject().get("issues");

        return new Gson().fromJson(issues, new TypeToken<Set<Issue>>() {}.getType());
    }

    protected int createIssue(Issue newIssue) throws IOException {

        String json = RestAssured.given()
                .params("subject", newIssue.getSubject())
                .params("description", newIssue.getDescription())
                .post("http://bugify.stqa.ru/api/issues.json").asString();

        JsonElement parsed = new JsonParser().parse(json);

        return parsed.getAsJsonObject().get("issue_id").getAsInt();
    }

    public boolean isIssueOpen(int issueId) throws IOException {

        String json = RestAssured.get(String.format("http://bugify.stqa.ru/api/issues/%s.json", issueId)).asString();

        JsonElement parsed = new JsonParser().parse(json);
        JsonElement issue = parsed.getAsJsonObject().getAsJsonArray("issues").get(0);

        return issue.getAsJsonObject().get("state").toString().equals("0");
    }

    public void skipIfNotFixed(int issueId) throws IOException {
        if (isIssueOpen(issueId)) {
            throw new SkipException("Ignored because of issue " + issueId);
        }
    }

    protected Executor getExecutor() {
        return Executor.newInstance().auth("288f44776e7bec4bf44fdfeb1e646490", "");
    }
}
