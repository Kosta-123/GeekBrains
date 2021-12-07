package HW1;

import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class ImgurImageTests extends BaseTest {
    public final String PATH_TO_IMAGE = "src/test/resourses/bandicam 2021-11-12 15-12-20-004.jpg";
    static String encodedFile;
    String uploadImageId;

    @BeforeEach
    void beforeTest() {
        byte[] byteArray = getFileContent();
        encodedFile = Base64.getEncoder().encodeToString(byteArray);
    }

    @Test
    void uploadFileBase64() {
        uploadImageId = given()
                .headers("Authorization", token)
                .multiPart("image", encodedFile)
                .expect()
                .body("success", is(true))
                .body("data.id", is(notNullValue()))
                .when()
                .post("https://api.imgur.com/3/image")
                .prettyPeek()
                .then()
                .extract()
                .response()
                .jsonPath()
                .getString("data.deletehash");

    }

    @Test
    void uploadImageTest() {
        uploadImageId = given()
                .header("Authorization", token)
                .multiPart("image", new File("src/test/resourses/bandicam 2021-11-12 15-12-20-004.jpg"))
                .multiPart("title", "Hello")
                .multiPart("description", "Super cool dog")
                .expect()
                .body("success", is(true))
                .body("data.id", is(notNullValue()))
                .body("data.link", containsString("https://i.imgur"))
                .contentType("application/json")
                .when()
                .post("https://api.imgur.com/3/upload")
                .prettyPeek()
                .then()
                .extract()
                .response()
                .jsonPath()
                .getString("data.deletehash");

    }

    @Test
    void updateTitleAndDescription() {
        given()
                .header("Authorization", token)
                .multiPart("title", "Fury snail")
                .multiPart("description", "Tasty muffins")
                .expect()
                .body("success", is(true))
                .contentType("application/json")
                .when()
                .post("https://api.imgur.com/3/image/{imageHash}", "Ubju4na")
                .prettyPeek();


    }


    @Test
    void getUpdatedImageTest() {
        given()
                .header("Authorization", token)
                .log()
                .method()
                .log()
                .uri()
                .expect()
                .body("success", equalTo(true))
                .body("status", equalTo(200))
                .body("data.title", is("Fury snail"))
                .body("data.description", Matchers.equalTo("Tasty muffins"))
                .contentType("application/json")
                .when()
                .get("https://api.imgur.com/3/image/{imageHash}", "Ubju4na")
                .prettyPeek()
                .then()
                .statusCode(200);
    }


    @Test
     void getImageDownloadSpeedLessThan3secTest() {
        given()
                .header("Authorization", token)
                .log()
                .method()
                .log()
                .uri()
                .expect()
                .body("success", equalTo(true))
                .body("status", equalTo(200))
                .contentType("application/json")
                .when()
                .get("https://api.imgur.com/3/image/{imageHash}", "P8FL3b9")
                .prettyPeek()
                .then()
                .time(lessThan(3000L))
                .statusCode(200);
    }


    @Test
    void uploadEmptyImageTest() {
        uploadImageId = given()
                .headers("Authorization", token)
                .multiPart("image", "")
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
                .jsonPath()
                .getString("data.deletehash");
    }

    @Test
    void uploadTextInsteadOfImage() {
        uploadImageId = given()
                .headers("Authorization", token)
                .multiPart("description", "Hello There")
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
                .jsonPath()
                .getString("data.deletehash");


    }

    @Test
    void uploadImageDescriptionEmptyTest() {
        uploadImageId = given()
                .headers("Authorization", token)
                .multiPart("description", "")
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
                .jsonPath()
                .getString("data.deletehash");
    }

    @Test
    void uploadJsonFileInsteadOfTitle() {

        uploadImageId = given()
                .headers("Authorization", token)
                .multiPart("title", new File("src/test/resourses/new_tab.json"))
                .expect()
                .statusCode(400)
                .body("success", is(false))
                .body("data.error", is("Bad Request"))
                .when()
                .post("https://api.imgur.com/3/upload")
                .prettyPeek()
                .then()
                .extract()
                .response()
                .jsonPath()
                .getString("data.deletehash");

    }

    @Test
    void uploadVideoAsJpegTest() {

        uploadImageId = given()
                .headers("Authorization", token)
                .multiPart("video", new File("src/test/resourses/bandicam 2021-11-12 15-12-20-004.jpg"))
                .expect()
                .statusCode(400)
                .body("success", is(false))
                .body("data.error", is("Unable to determine file duration"))
                .when()
                .post("https://api.imgur.com/3/upload")
                .prettyPeek()
                .then()
                .extract()
                .response()
                .jsonPath()
                .getString("data.deletehash");

    }

    @Test
    void deleteImageTest() {
        given()
                .header("Authorization", token)
                .expect()
                .statusCode(200)
                .body("data", is(true))
                .body("success", is(notNullValue()))
                .body("status", is(200))
                .contentType("application/json")
                .when()
                .delete("https://api.imgur.com/3/image/{imageHash}", "OYbir60")
                .prettyPeek();
    }


//    @AfterEach
//    void tearDown() {
//        given()
//                .headers("Authorization", token)
//                .when()
//                .delete("https://api.imgur.com/3/account/{username}/image/{deleteHash}", token, uploadImageId)
//                .prettyPeek()
//                .then()
//                .statusCode(200);
//    }

    private byte[] getFileContent() {
        byte[] byteArray = new byte[0];
        try {
            byteArray = FileUtils.readFileToByteArray(new File(PATH_TO_IMAGE));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArray;
    }


}
