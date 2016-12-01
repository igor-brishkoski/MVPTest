package dragon.com.mvptest.ui.repo;

import java.util.List;

import dragon.com.mvptest.dagger.ApiService;
import dragon.com.mvptest.ui.models.Post;

/**
 * Created by ibrishkoski on 11/21/16.
 */

public class PostRepositoryImpl implements PostRepository {
    List<Post> posts;
    ApiService apiService;

    public PostRepositoryImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void loadPosts(final RepositoryCallback<List<Post>> postRepositoryCallback) {
        if (posts != null) {
            postRepositoryCallback.onResponse(posts);
        } else {
            apiService.loadPosts(new ApiService.ApiServiceCallback<List<Post>>() {
                @Override
                public void onResponse(List<Post> data) {
                    posts = data;
                    postRepositoryCallback.onResponse(posts);
                }

                @Override
                public void onError(Throwable e) {
                    postRepositoryCallback.onError(e);
                }
            });
        }

    }
}
