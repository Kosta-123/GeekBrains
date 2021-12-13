package Services;

import dto.Product;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.ArrayList;

public interface  ProductService {

    @GET("products")
    Call<ArrayList<Product>> getProducts();

    @GET("products/{id}")
    Call<Product> getProduct(@Path("id") Integer id);


    @PUT("products")
    Call<Product> putProduct(@Body Product product);


    @POST("products")
    Call<Product> createProduct(@Body Product product);

    @DELETE("products/{id}")
    Call<Product> deleteProduct(@Path("id") int id);

}
