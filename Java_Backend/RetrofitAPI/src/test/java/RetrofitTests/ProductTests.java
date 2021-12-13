package RetrofitTests;

import Services.CategoryService;
import Services.ProductService;
import com.github.javafaker.Faker;
import dto.Category;
import dto.Product;
import enums.CategoryType;
import enums.ProductType;
import io.restassured.response.ResponseBody;
import lombok.SneakyThrows;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import Utils.RetrofitUtils;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ProductTests {

    static Retrofit client;
    static ProductService productService;
    static CategoryService categoryService;
    Faker faker = new Faker();
    Product product;

    @BeforeAll
    static void beforeAll(){
        client = RetrofitUtils.getRetrofit();
        productService = client.create(ProductService.class);
        categoryService = client.create(CategoryService.class);
    }
    @BeforeEach
    void setUp(){
        product = new Product()
                .withTitle(faker.beer().name())
                .withPrice((int) ((Math.random() + 1)*100))
                .withCategoryTitle(CategoryType.FOOD.getTitle());
    }

    @Test
    void postProductTest() throws IOException{
        Response<Product> response = productService.createProduct(product).execute();

        assertThat(response.body().getTitle(), equalTo(product.getTitle()));
        assertThat(response.body().getPrice(), equalTo(product.getPrice()));
    }

    @Test
    void getCategoryByIdTest() throws IOException {
        Integer id = CategoryType.ELECTRONIC.getId();

        Response<Category> response = categoryService
                .getCategory(id)
                .execute();

    }

    @Test

    void createProductInFoodCategoryTest() throws IOException {
        Response<Product> response = productService.createProduct(product)
                .execute();
        Integer id =  response.body().getId();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.body().getCategoryTitle(), equalTo("Food"));
    }


//    @Test
//    void tearDown () throws IOException {
//        Integer id = ProductType.BANANA.getId();
//        Response<Product> response = productService
//                .deleteProduct(id)
//                .execute();
//        assertThat(response.isSuccessful(), CoreMatchers.is(true));
//    }




}
