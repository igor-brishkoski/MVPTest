package dragon.com.mvptest.ui.repo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.net.NetworkInfo;
import android.util.Log;

import java.lang.reflect.Type;
import java.util.List;

import dragon.com.mvptest.ApiService;
import dragon.com.mvptest.App;
import dragon.com.mvptest.ui.api.PostApiService;
import dragon.com.mvptest.ui.models.Post;

/**
 * Created by ibrishkoski on 11/21/16.
 */

public class PostRepositoryImpl implements PostRepository {
    List<Post> posts;
    PostApiService apiService;
    NetworkInfo networkInfo;

    public PostRepositoryImpl(PostApiService apiService) {
        this.apiService = apiService;
    }

    public void setNetworkInfo(NetworkInfo networkInfo) {
        this.networkInfo = networkInfo;
    }

    @Override
    public void loadPosts(final RepositoryCallback<List<Post>> postRepositoryCallback) {
        if (posts != null) {
            postRepositoryCallback.onResponse(posts);
        } else {
            if (isConnected()) {
                Log.d("NETWORK", "It's connected :(");
                apiService.loadPosts(new ApiService.ApiServiceCallback<List<Post>>() {
                    @Override
                    public void onResponse(List<Post> data) {
                        posts = data;
                        App.getSharePreferences().edit().putString("posts", toJson(data)).apply();
                        postRepositoryCallback.onResponse(posts);
                    }

                    @Override
                    public void onError(Throwable e) {
                        postRepositoryCallback.onError(e);
                    }
                });
            } else {
                Log.d("NETWORK", "WE're not connected yo");
                if (App.getSharePreferences().contains("posts")) {
                    Log.d("NETWORK", "WE found cache");
                    fromJson();
                    postRepositoryCallback.onResponse(posts);
                } else {
                    Log.d("NETWORK", "there is no cache");
                }
            }
        }
    }

    private String toJson(List<Post> posts) {
        return new Gson().toJson(posts);
    }

    private void fromJson() {
        Type type = new TypeToken<List<Post>>() {
        }.getType();
        posts = new Gson().fromJson(App.getSharePreferences().getString("posts", "[]")
                , type);
    }

    private boolean isConnected() {
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }
}