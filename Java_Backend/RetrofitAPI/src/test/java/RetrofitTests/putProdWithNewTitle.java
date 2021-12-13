package RetrofitTests;

import Services.ProductService;
import Utils.RetrofitUtils;
import dto.Product;
import enums.ProductType;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class putProdWithNewTitle {
    static Retrofit client;
    static ProductService productService;
    Product product;

    @BeforeAll
    static void beforeAll() {
        client = RetrofitUtils.getRetrofit();
        productService = client.create(ProductService.class);
    }

    @BeforeEach
    void newSetUp2() {
        product = new Product()
                .withId(ProductType.GOORT.getId())
                .withTitle(ProductType.GOORT.getTitle());

    }

    @Test
    void postNewTitleProductTest() throws IOException {
        Response<Product> response = productService.putProduct(product)
                .execute();
    }

    @Test
    void getProductWithNewTitleTest1() throws IOException {
        Integer id = ProductType.GOORT.getId();

        Response<Product> response = productService
                .getProduct(id)
                .execute();

        assertThat(response.body().getTitle(), equalTo("Robotic"));

    }

//    @Test
//    void deleteProductByIdTest() throws IOException {
//        Integer id = ProductType.GOORT.getId();
//        Response<Product> response = productService
//                .deleteProduct(id)
//                .execute();
//    }
}