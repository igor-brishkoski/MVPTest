package dragon.com.mvptest.ui.repo;


import java.util.List;

import dragon.com.mvptest.ui.models.Post;

/**
 * Created by ibrishkoski on 11/21/16.
 */

public interface PostRepository {

    interface RepositoryCallback<T>{
        void onResponse(T data);
        void onError(Throwable e);
    }

    void loadPosts(RepositoryCallback<List<Post>> postRepositoryCallback);
}
