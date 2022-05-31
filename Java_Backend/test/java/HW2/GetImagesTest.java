package HW2;

import dto.GetImmage.GetImageResponse;
import dto.PostImageResponse;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.IsEqual.equalTo;

public class GetImagesTest extends BaseTest {
    @Test
    void getUpdatedImageTest() {
        GetImageResponse response =
        given()
                .header("Authorization", token)
                .log()
                .method()
                .log()
                .uri()
                .expect()
                .contentType("application/json")
                .when()
                .get("https://api.imgur.com/3/image/{imageHash}", "R48gtrq")
                .prettyPeek()
                .then()
                .extract()
                .body()
                .as(GetImageResponse.class);
        assertThat(response.getStatus(), equalTo(200));
        assertThat(response.getSuccess(), equalTo(true));
        assertThat(response.getData().getTitle(), equalTo("Fury snail"));
        assertThat(response.getData().getDescription(), equalTo("Tasty muffins"));
        assertThat(response.getData().getType(), equalTo("image/jpeg"));

    }


    @Test
    void getImageDownloadSpeedLessThan3secTest() {
        GetImageResponse response =
        given()
                .header("Authorization", token)
                .log()
                .method()
                .log()
                .uri()
                .expect()
                .contentType("application/json")
                .when()
                .get("https://api.imgur.com/3/image/{imageHash}", "R48gtrq")
                .prettyPeek()
                .then()
                .time(lessThan(3000L))
                .extract()
                .body()
                .as(GetImageResponse.class);
        assertThat(response.getStatus(), equalTo(200));
        assertThat(response.getData().getTitle(), equalTo("Fury snail"));

    }
}
