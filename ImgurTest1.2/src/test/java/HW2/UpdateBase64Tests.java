package HW2;


import dto.Endpoints;
import dto.PostImageResponse;
import io.restassured.builder.MultiPartSpecBuilder;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.MultiPartSpecification;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Base64;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UpdateBase64Tests extends BaseTest {
    private final String PATH_TO_IMAGE = "src/test/resourses/bandicam 2021-11-12 15-12-20-004.jpg";
    private String encodedFile;
    private String imageId;
    private String deleteHash;
    private Response response;
    private MultiPartSpecification base64MultiPartSpec;
    private RequestSpecification requestSpecificationWithAuthWithBase64;

    @BeforeEach
    void beforeNewTest() {
        byte[] byteArray = getFileContent(PATH_TO_IMAGE);
        encodedFile = Base64.getEncoder().encodeToString(byteArray);

        base64MultiPartSpec = new MultiPartSpecBuilder(encodedFile)
                .controlName("image")
                .build();
        requestSpecificationWithAuthWithBase64 = new RequestSpecBuilder()
                .addHeader("Authorization", token)
                .addMultiPart(base64MultiPartSpec)
                .build();

        response = given(requestSpecificationWithAuthWithBase64, positiveResponseSpecification)
                .post(Endpoints.UPLOAD_IMAGE)
                .prettyPeek()
                .then()
                .extract()
                .response();

        imageId = response.jsonPath().getString("data.id");
        deleteHash = response.jsonPath().getString("data.deletehash");
    }

    @Test
    void updateFileTest() {
        given()
                .header("Authorization", token)
                .param("title", "Fuzzy snail")
                .param("description", "Robotic Head")
                .expect()
                .statusCode(200)
                .when()
                .put("https://api.imgur.com/3/image/{imageHash}", imageId)
                .prettyPeek()
                .then()
                .statusCode(200)
                .extract()
                .response();

        String title = given()
                .headers("Authorization", token)
                .expect()
                .statusCode(200)
                .when()
                .get("https://api.imgur.com/3/image/{imageHash}", imageId)
                .prettyPeek()
                .then()
                .extract()
                .response()
                .body()
                .as(PostImageResponse.class)
                .getData().getTitle();
        assertThat("Title", title, equalTo("Fuzzy snail"));

    }



}
