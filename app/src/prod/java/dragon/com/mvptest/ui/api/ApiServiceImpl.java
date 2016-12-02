package dragon.com.mvptest.ui.api;

import android.util.Log;

import java.util.List;

import dragon.com.mvptest.ApiService;
import dragon.com.mvptest.ui.models.Post;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by ibrishkoski on 11/21/16.
 */

public class ApiServiceImpl implements ApiService {
    Retrofit retrofit;

    public ApiServiceImpl(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    @Override
    public void loadPosts(final ApiServiceCallback<List<Post>> postRepositoryCallback) {
        Call<List<Post>> posts = retrofit.create(Restapi.class).getPosts();
        Log.d("API", "make call");
        posts.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                Log.d("API", response.body().toString());
                postRepositoryCallback.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                postRepositoryCallback.onError(t);
            }
        });
    }
}
