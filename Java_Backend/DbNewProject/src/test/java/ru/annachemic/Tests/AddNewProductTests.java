package ru.annachemic.Tests;

import com.github.javafaker.Faker;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import ru.annachemic.db.dao.ProductsMapper;
import ru.annachemic.db.dto.Product;
import ru.annachemic.db.enums.CategoryType;
import ru.annachemic.db.enums.ProductType;
import ru.annachemic.db.service.CategoryService;
import ru.annachemic.db.service.ProductService;
import ru.annachemic.db.utils.DbUtils;
import ru.annachemic.db.utils.RetrofitUtils;

import java.io.IOException;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AddNewProductTests {
    static ProductsMapper productsMapper;
    static Retrofit client;
    static ProductService productService;
    static CategoryService categoryService;
    int productId;
    Faker faker = new Faker();
    Product product;

    @BeforeAll
    static void beforeAll() {
        client = RetrofitUtils.getRetrofit();
        productService = client.create(ProductService.class);
        productsMapper = DbUtils.getProductsMapper();
        client = RetrofitUtils.getRetrofit();
        productService = client.create(ProductService.class);
        categoryService = client.create(CategoryService.class);
        productsMapper = DbUtils.getProductsMapper();
    }

    @BeforeEach
    void newSetUp() {

        product = new Product()
                .withTitle(faker.animal().name())
                .withPrice((int) ((Math.random() + 1) * 100))
                .withCategoryTitle(CategoryType.FURNITURE.getTitle());
    }

    @Test
    void postNewProductTest() throws IOException {
        Response<Product> response = productService.createProduct(product).execute();
        assertThat(response.code(), equalTo(201));


    }

    @Test
    void getBonzoProduct() throws IOException {
        Integer id = ProductType.BONZO.getId();
        Response<Product> response = productService
                .getProduct(id).execute();
        assertThat(response.body().getTitle(), equalTo("Bones"));
    }

    @Test
    void geGoo0Product() throws IOException {
        Integer id = ProductType.GOOO.getId();
        Response<Product> response = productService
                .getProduct(id).execute();
        assertThat(response.body().getCategoryTitle(), equalTo("Food"));

    }
    @Test
    void geNutsWithLongTitleProduct() throws IOException {
        Integer id = ProductType.NUTS.getId();
        String title = ProductType.NUTS.getTitle();
        Response<Product> response = productService
                .getProduct(id).execute();
        assertThat(response.body().getId(), equalTo(id));
        assertThat(response.body().getTitle(), equalTo(title));
        assertThat(response.code(), equalTo(200));

    }


    @Test
    void getProductByIdTest() throws IOException {
        Integer id = ProductType.GOORT.getId();

        Response<Product> response = productService
                .getProduct(id)
                .execute();
        assertThat(response.body().getId(), equalTo(id));
        assertThat(response.body().getTitle(), equalTo("Bread"));
        assertThat(response.isSuccessful(), CoreMatchers.is(true));


    }

    @Test
    void getAllProductsTest() throws IOException {
        Response<ArrayList<Product>> response = productService
                .getProducts()
                .execute();
        assertThat(response.code(), equalTo(200));


    }

}
