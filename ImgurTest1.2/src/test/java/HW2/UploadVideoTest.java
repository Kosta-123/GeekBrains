package HW2;

import dto.Delete.DeleteImageResponse;
import dto.Error.NegativeImageResponse;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UploadVideoTest extends BaseTest {
    public final String PATH_TO_IMAGE = "src/test/resourses/bandicam 2021-11-12 15-12-20-004.jpg";
    RequestSpecification requestVideoSpecification = null;


    @BeforeEach
    void beforeTest() {

        requestVideoSpecification = new RequestSpecBuilder()
                .addHeader("Authorization", token)
                .setAccept(ContentType.JSON)
                .build();

    }

    @Test
    void uploadVideoAsJpegTest() {
        NegativeImageResponse response =
                given()
                        .headers("Authorization", token)
                        .multiPart("video", new File("src/test/resourses/bandicam 2021-11-12 15-12-20-004.jpg"))
                        .expect()
                        .when()
                        .post("https://api.imgur.com/3/upload")
                        .prettyPeek()
                        .then()
                        .extract()
                        .response()
                        .body()
                        .as(NegativeImageResponse.class);
        assertThat(response.getSuccess(), equalTo(false));
        assertThat(response.getStatus(), equalTo(400));
        assertThat(response.getData().getError(), equalTo("Unable to determine file duration"));

    }
}
