package HW1;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class AccountTest extends BaseTest {

    @Test
    void getAccountInfoTest() {
        given()
                .header("Authorization", token)
                .log()
                .method()
                .log()
                .uri()
                .expect()
                .body("data.url", equalTo(username))
                .body("success", equalTo(true))
                .body("status", equalTo(200))
                .body("bio", equalTo(null))
                .contentType("application/json")
                .when()
                .get("https://api.imgur.com/3/account/{username}", username)
                .prettyPeek()
                .then()
                .statusCode(200);

    }
    @Test
    void accountAnotherTest(){
        Response response = given()
                .header("Authorization", token)
                .log()
                .method()
                .log()
                .uri()
                .when()
                .get("https://api.imgur.com/3/account/{username}", username)
                .prettyPeek();
        assertThat(response.jsonPath().get("data.user_follow.status"), equalTo(false));
    }
}
