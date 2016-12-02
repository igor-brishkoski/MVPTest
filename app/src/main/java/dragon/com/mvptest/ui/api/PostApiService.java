package dragon.com.mvptest.ui.api;

import java.util.List;

import dragon.com.mvptest.ApiService;
import dragon.com.mvptest.ui.models.Post;

/**
 * Created by ibrishkoski on 12/2/16.
 */

public interface PostApiService extends ApiService {
    void loadPosts(ApiServiceCallback<List<Post>> postRepositoryCallback);
}
