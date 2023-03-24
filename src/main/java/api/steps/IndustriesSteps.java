package api.steps;

import api.dto.Article;
import api.dto.Roles;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;

public class IndustriesSteps {
    RequestSpecification requestSpecification = given()
            .baseUri("http://localhost:8089")
            .basePath("api/industries")
            .contentType(io.restassured.http.ContentType.JSON);


    public void getIndustries() {
        Response response = requestSpecification.when().get();
        Assert.assertTrue(response.statusCode()==200);
        
        String jsonData = response.asString();
        Gson gson = new Gson();

        JsonArray jsonArray = new JsonParser()
                .parse(jsonData)
                .getAsJsonArray();
        Roles[] roles = new Roles[jsonArray.size()];
        for (int i = 0; i < jsonArray.size(); i++) {
            roles[i] = gson.fromJson(jsonArray.get(i), Roles.class);
            System.out.println(roles[i]);
        }
        String[] names = new String[roles.length];
        for (int i = 0; i < names.length; i++) {
            names[i] = roles[i].getName();
        }

        Assert.assertEquals(names, new String[]{"BFSI", "Energy", "IT", "Ecommerce", "Entertainment&Media", "Public Service"});
    }

        

}
