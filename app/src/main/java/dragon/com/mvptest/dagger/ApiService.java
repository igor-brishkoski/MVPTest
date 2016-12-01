package dragon.com.mvptest.dagger;

import java.util.List;

import dragon.com.mvptest.ui.models.Post;

/**
 * Created by ibrishkoski on 11/21/16.
 */

public interface ApiService {
    interface ApiServiceCallback<T>{
        void onResponse(T data);
        void onError(Throwable e);
    }

    void loadPosts(ApiServiceCallback<List<Post>> postRepositoryCallback);
}
