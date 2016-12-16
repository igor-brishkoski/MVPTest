package dragon.com.mvptest.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

public class MainActivity extends AppCompatActivity implements PostView {

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
        postsAdapter = new PostsAdapter(posts);
        recyclerView.setAdapter(postsAdapter);
    }

    class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {
        private List<Post> posts;

        PostsAdapter(final List<Post> posts) {
            this.posts = posts;
        }

        @Override
        public PostsAdapter.PostViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
            return new PostViewHolder(getLayoutInflater().inflate(R.layout.post_list_item,
                    parent, false));
        }

        @Override
        public void onBindViewHolder(final PostsAdapter.PostViewHolder holder, final int position) {
            holder.setup(posts.get(position));
        }

        @Override
        public int getItemCount() {
            return posts.size();
        }

        class PostViewHolder extends RecyclerView.ViewHolder {
            TextView titleTextView;
            TextView bodyTextView;


            PostViewHolder(final View itemView) {
                super(itemView);
                titleTextView = (TextView) itemView.findViewById(R.id.post_list_item_text_title);
                bodyTextView = (TextView) itemView.findViewById(R.id.post_list_item_text_body);
            }

            void setup(Post post) {
                titleTextView.setText(post.getTitle());
                bodyTextView.setText(post.getBody());
            }
        }
    }
}
