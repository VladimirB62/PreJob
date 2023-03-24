package api.steps;

import api.dto.Article;
import api.dto.Article;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ArticleSteps {

    RequestSpecification requestSpecification = given()
            .baseUri("http://localhost:8089")
            .basePath("api/articles")
            .contentType(ContentType.JSON);

    @Step
    public void getAllArticlesById(String id) {
        Response response = requestSpecification.queryParam("roleId",id).when().get();
        Assert.assertTrue(response.statusCode()==200);

        String jsonData = response.asString();
        Gson gson = new Gson();

        JsonArray jsonArray = new JsonParser()
                .parse(jsonData)
                .getAsJsonArray();
        Article[] article = new Article[jsonArray.size()];
        for (int i = 0; i < jsonArray.size(); i++) {
            article[i] = gson.fromJson(jsonArray.get(i), Article.class);
            System.out.println(article[i]);
        }
        for (int i = 0; i < article.length; i++) {
            Assert.assertTrue(article[i].getVideoUrl()!=null);
        }
    }
}
