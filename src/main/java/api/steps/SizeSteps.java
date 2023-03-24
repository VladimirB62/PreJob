package api.steps;

import api.dto.Roles;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class SizeSteps {
    RequestSpecification requestSpecification = given()
            .baseUri("http://localhost:8089")
            .basePath("api/size")
            .contentType(io.restassured.http.ContentType.JSON);
    public void getSizes() {
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

        Assert.assertEquals(names, new String[]{"Small Co", "Medium Co", "Large Co"});
    }
}
