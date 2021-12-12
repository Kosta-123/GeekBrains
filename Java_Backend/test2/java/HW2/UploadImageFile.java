package HW2;

import dto.PostImageResponse;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UploadImageFile extends BaseTest {

    private RequestSpecification requestSpecificationWithAuthWithFile;

    @BeforeEach
    void beforeNewerTest() {

        requestSpecificationWithAuthWithFile = new RequestSpecBuilder()
                .addHeader("Authorization", token)
                .build();
    }

    @Test
    void uploadImageFileTest() {
        PostImageResponse response =

        given()
                .header("Authorization", token)
                .multiPart("image", new File("src/test/resourses/bandicam 2021-11-12 15-12-20-004.jpg"))
                .multiPart("title", "Hello")
                .multiPart("description", "Super cool dog")
                .when()
                .post("https://api.imgur.com/3/upload")
                .prettyPeek()
                .then()
                .extract()
                .body()
                .as(PostImageResponse.class);
        assertThat(response.getStatus(), equalTo(200));
        assertThat(response.getSuccess(), equalTo(true));
        assertThat(response.getData().getDescription(), equalTo("Super cool dog"));
        assertThat(response.getData().getTitle(), equalTo("Hello"));
        assertThat(response.getData().getLink(),containsString("https://i.imgur"));
        assertThat(response.getData().getId(), is(notNullValue()));

    }
}

