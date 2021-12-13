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

public class AddNewProductTests {
    static Retrofit client;
    static ProductService productService;
    Product product;

    @BeforeAll
    static void beforeAll() {
        client = RetrofitUtils.getRetrofit();
        productService = client.create(ProductService.class);
    }

    @BeforeEach
    void newSetUp() {
        product = new Product()
                .withId(ProductType.GOORT.getId())
                .withTitle(ProductType.GOORT.getTitle())
                .withPrice(ProductType.GOORT.getPrice())
                .withCategoryTitle(ProductType.GOORT.getCategoryTitle());

    }

    @Test
    void postProductTest() throws IOException {
        Response<Product> response = productService.createProduct(product)
                .execute();

    }

    @Test
    void getProductByIdTest() throws IOException {
        Integer id = ProductType.GOORT.getId();

        Response<Product> response = productService
                .getProduct(id)
                .execute();

        assertThat(response.body().getTitle(), equalTo("Goort"));
        assertThat(response.body().getId(), equalTo(id));
        assertThat(response.isSuccessful(), CoreMatchers.is(true));


        }

    }









