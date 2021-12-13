package Services;
import dto.Category;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface CategoryService {

    @GET("products/{id}")
    Call<Category> getCategory (@Path("id") Integer id);

    @GET("products/{id}")
    Call<Category> getCategory (@Path("title") String title);

}
