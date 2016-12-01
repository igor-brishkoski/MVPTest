package dragon.com.mvptest.ui.api;

import java.util.List;

import dragon.com.mvptest.ui.models.Post;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ibrishkoski on 11/21/16.
 */

public interface Restapi {

    @GET("/posts")
    Call<List<Post>> getPosts();
}
