package activities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Activity2 {

    String base_URI = "https://petstore.swagger.io/v2/user";

    @Test
    public void getUserFromFile() throws IOException {
        FileInputStream inputJson = new FileInputStream("src/test/java/activities/userInfo.txt");
        String reqBody = new String(inputJson.readAllBytes());

        Response response = given().contentType(ContentType.JSON)
                .body(reqBody).when().post(base_URI);

        inputJson.close();

        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("123"));
    }

    @Test(priority = 1)
    public void getJsonInfo() {

        File outputJson = new File("src/test/java/activities/response.txt");

        Response response = given().contentType(ContentType.JSON)
                .pathParam("username","ramyatest")
                .when().get(base_URI + "/{username}");

        String resBoby = response.getBody().asPrettyString();

        try {
            outputJson.createNewFile();
            FileWriter writer  = new FileWriter(outputJson.getPath());
            writer.write(resBoby);
            writer.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
        response.then().body("id", equalTo(123));
        response.then().body("username", equalTo("ramyatest"));
        response.then().body("firstName", equalTo("Ramya"));
        response.then().body("lastName", equalTo("Test"));
        response.then().body("email", equalTo("RamyaTest@mail.com"));
        response.then().body("password", equalTo("123pwd"));
        response.then().body("phone", equalTo("9876543212"));
    }

    @Test(priority = 2)
    public void deleteUser() throws IOException {
        Response response = given().contentType(ContentType.JSON)
                .pathParam("username" ,"ramyatest")
                .when().delete(base_URI + "/{username}");

        response.then().body("code", equalTo(200));
        response.then().body("message" ,equalTo("ramyatest"));
    }
}
