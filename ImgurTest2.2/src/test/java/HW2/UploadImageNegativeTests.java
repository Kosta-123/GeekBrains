package HW2;


import dto.Delete.DeleteImageResponse;
import dto.Error.NegativeImageResponse;
import io.restassured.builder.MultiPartSpecBuilder;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.MultiPartSpecification;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UploadImageNegativeTests extends BaseTest {
    private final String PATH_TO_IMAGE = "src/test/resourses/bandicam 2021-11-12 15-12-20-004.jpg";
    private String imageId;
    private String deleteHash;

    private Response response;
    private MultiPartSpecification fileMultiPartSpec;
    private RequestSpecification requestSpecificationWithAuthWithFile;


    @BeforeEach
    void beforeTest() {



        fileMultiPartSpec = new MultiPartSpecBuilder(PATH_TO_IMAGE)
                .controlName("image")
                .build();
        requestSpecificationWithAuthWithFile = new RequestSpecBuilder()
                .addHeader("Authorization", token)
                .addMultiPart(fileMultiPartSpec)
                .build();
    }

    @Test
    void uploadEmptyImageTest() {
        NegativeImageResponse response =
        given()
                .headers("Authorization", token)
                .param("id", "Hello")
                .expect()
                .body("success", is(false))
                .body("data.error", is(notNullValue()))
                .body("data.method", is("POST"))
                .contentType("application/json")
                .when()
                .post("https://api.imgur.com/3/upload")
                .prettyPeek()
                .then()
                .extract()
                .response()
                .body()
                .as(NegativeImageResponse.class);
        assertThat(response.getStatus(), equalTo(400));
        assertThat(response.getData().getError(), equalTo("Bad Request"));
        assertThat(response.getData().getMethod(), equalTo("POST"));




    }

    @Test
    void uploadTextInsteadOfImage() {
        NegativeImageResponse response =
        given()
                .headers("Authorization", token)
                .multiPart("description", "Hello There")
                .when()
                .post("https://api.imgur.com/3/upload")
                .prettyPeek()
                .then()
                .extract()
                .response()
                .body()
                .as(NegativeImageResponse.class);
        assertThat(response.getStatus(), equalTo(400));
        assertThat(response.getData().getError(), is(notNullValue()));



    }

    @Test
    void uploadImageDescriptionEmptyTest() {
        NegativeImageResponse response =
        given()
                .headers("Authorization", token)
                .multiPart("description", "")
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
    }

    @Test
    void uploadJsonFileInsteadOfTitle() {
        NegativeImageResponse response =
                given()
                .headers("Authorization", token)
                .multiPart("title", new File("src/test/resourses/new_tab.json"))
                .when()
                .post("https://api.imgur.com/3/upload")
                .prettyPeek()
                .then()
                .extract()
                .response()
                .body()
                .as(NegativeImageResponse.class);
        assertThat(response.getStatus(),equalTo(400));
        assertThat(response.getData().getRequest(), equalTo("/3/upload"));
        assertThat(response.getData().getError(), equalTo("Bad Request"));

    }

    }






