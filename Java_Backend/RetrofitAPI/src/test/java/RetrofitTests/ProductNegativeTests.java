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
import enums.NegativeData;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ProductNegativeTests {
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
                .withId(NegativeData.NUTS.getId());


    }

    @Test
    void postProductTest() throws IOException {
        Response<Product> response = productService.createProduct(product)
                .execute();



    }

    @Test
    void getProductWithEmptyTitleTest() throws IOException {
        Integer id = NegativeData.NUTS.getId();

        Response<Product> response = productService
                .getProduct(id)
                .execute();

        assertThat(response.body().getTitle(), equalTo(null));
        assertThat(response.body().getId(), equalTo(id));
        assertThat(response.isSuccessful(), CoreMatchers.is(true));


    }

//    @Test
//    void deleteProductByIdTest() throws IOException {
//        Integer id = NegativeData.NUTS.getId();
//        Response<Product> response = productService
//                .deleteProduct(id)
//                .execute();
//    }

}

