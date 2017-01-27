package dragon.com.mvptest.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dragon.com.mvptest.App;
import dragon.com.mvptest.R;
import dragon.com.mvptest.ui.models.Post;
import dragon.com.mvptest.ui.presenters.PostPresenter;
import dragon.com.mvptest.ui.presenters.PostPresenterImpl;
import dragon.com.mvptest.ui.repo.PostRepository;
import dragon.com.mvptest.ui.views.PostView;

public class MainActivity extends AppCompatActivity implements PostView, PostViewHolder.PostInteractions {

    @Inject
    PostRepository repository;

    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    PostsAdapter postsAdapter;

    PostPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App) getApplication()).getPostComponent().inject(this);
        ButterKnife.bind(this);

        presenter = new PostPresenterImpl(this, repository);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onResume() {
        super.onRestart();
        presenter.getPosts();
    }

    @Override
    public void showPost(List<Post> posts) {
        postsAdapter = new PostsAdapter(posts, this);
        recyclerView.setAdapter(postsAdapter);
    }


    @Override
    public void goToPost(final Post post) {
        Toast.makeText(this, post.getTitle(), Toast.LENGTH_SHORT).show();
    }
}
