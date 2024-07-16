import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class PostmanEchoTest {

    static {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void testGetMethod() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("headers", notNullValue())
                .body("url", notNullValue());
    }

    @Test
    public void testPostMethod() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("foo1", "bar1");
        requestBody.put("foo2", "bar2");

        given()
                .contentType("application/json")
                .body(requestBody.toString())
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data.foo1", equalTo("bar1"))
                .body("data.foo2", equalTo("bar2"))
                .body("headers", notNullValue())
                .body("url", notNullValue());
    }

    @Test
    public void testPutMethod() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("foo1", "bar1");
        requestBody.put("foo2", "bar2");

        given()
                .contentType("application/json")
                .body(requestBody.toString())
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("data.foo1", equalTo("bar1"))
                .body("data.foo2", equalTo("bar2"))
                .body("headers", notNullValue())
                .body("url", notNullValue());
    }

    @Test
    public void testPatchMethod() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("foo1", "bar1");
        requestBody.put("foo2", "bar2");

        given()
                .contentType("application/json")
                .body(requestBody.toString())
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("data.foo1", equalTo("bar1"))
                .body("data.foo2", equalTo("bar2"))
                .body("headers", notNullValue())
                .body("url", notNullValue());
    }

    @Test
    public void testDeleteMethod() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("headers", notNullValue())
                .body("url", notNullValue());
    }
}
