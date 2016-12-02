package dragon.com.mvptest.ui.api;

import java.util.ArrayList;
import java.util.List;

import dragon.com.mvptest.ApiService;
import dragon.com.mvptest.ui.models.Post;

/**
 * Created by ibrishkoski on 12/2/16.
 */

public class FakeApiService implements ApiService {

    @Override
    public void loadPosts(ApiServiceCallback<List<Post>> postRepositoryCallback) {
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(new Post.Builder().body("Hett").title("Yo").build());
        posts.add(new Post.Builder().body("df").title("fdfd").build());

        postRepositoryCallback.onResponse(posts);
    }
}