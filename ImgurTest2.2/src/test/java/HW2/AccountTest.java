package HW2;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class AccountTest extends BaseTest {

   @Test
   void getAccountNewTest(){
       given(requestWithAuth, positiveResponseSpecification)
               .get(site, username);

   }

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
                .get(site, username)
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
