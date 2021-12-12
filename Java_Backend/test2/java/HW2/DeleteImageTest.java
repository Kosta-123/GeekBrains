package HW2;

import dto.Delete.DeleteImageResponse;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DeleteImageTest extends BaseTest {
    private RequestSpecification requestSpecificationWithAuthWithFile;

    @BeforeEach
    void beforeNewerTest() {

        requestSpecificationWithAuthWithFile = new RequestSpecBuilder()
                .addHeader("Authorization", token)
                .build();
    }
    @Test
    void deleteImageTest() {
        DeleteImageResponse response =
        given()
                .header("Authorization", token)
                .when()
                .delete("https://api.imgur.com/3/image/{imageHash}", "OYbir60")
                .prettyPeek()
                .then()
                .extract()
                .response()
                .body()
                .as(DeleteImageResponse.class);
        assertThat(response.getStatus(), equalTo(200));
        assertThat(response.getData(), equalTo("true"));
        assertThat(response.getSuccess(), is(notNullValue()));

    }


}
