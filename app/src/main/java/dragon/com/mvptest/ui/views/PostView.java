package dragon.com.mvptest.ui.views;

import java.util.List;

import dragon.com.mvptest.ui.models.Post;

/**
 * Created by ibrishkoski on 11/21/16.
 */

public interface PostView {
    void showPost(List<Post> posts);
}
