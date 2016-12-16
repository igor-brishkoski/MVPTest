package dragon.com.mvptest.ui.presenters;

import java.util.List;

import dragon.com.mvptest.ui.models.Post;
import dragon.com.mvptest.ui.repo.PostRepository;
import dragon.com.mvptest.ui.views.PostView;

/**
 * Created by ibrishkoski on 11/21/16.
 */

public class PostPresenterImpl implements PostPresenter {
    PostView view;
    PostRepository postRepository;

    public PostPresenterImpl(PostView view, PostRepository repository) {
        this.view = view;
        this.postRepository = repository;
    }

    @Override
    public void getPosts() {
        postRepository.loadPosts(new PostRepository.RepositoryCallback<List<Post>>() {
            @Override
            public void onResponse(List<Post> data) {
                view.showPost(data);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
}
