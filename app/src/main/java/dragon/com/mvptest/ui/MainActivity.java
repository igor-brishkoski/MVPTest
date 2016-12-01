package dragon.com.mvptest.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dragon.com.mvptest.ui.api.ApiServiceImpl;
import dragon.com.mvptest.App;
import dragon.com.mvptest.ui.models.Post;
import dragon.com.mvptest.ui.presenters.PostPresenter;
import dragon.com.mvptest.ui.presenters.PostPresenterImpl;
import dragon.com.mvptest.ui.repo.PostRepository;
import dragon.com.mvptest.ui.repo.PostRepositoryImpl;
import dragon.com.mvptest.ui.views.PostView;
import dragon.com.mvptest.R;
import dragon.com.mvptest.dagger.ApiService;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements PostView {

    @Inject
    Retrofit retrofit;
    @BindView(R.id.textview_post)
    TextView textView;

    PostPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        ((App) getApplication()).getNetComponent().inject(this);

        ApiService apiService = new ApiServiceImpl(retrofit);
        PostRepository repository = new PostRepositoryImpl(apiService);
        presenter = new PostPresenterImpl(this, repository);

        textView = (TextView) findViewById(R.id.textview_post);
    }

    @Override
    protected void onResume() {
        super.onRestart();
        presenter.getPosts();
    }

    @Override
    public void showPost(Post post) {
        textView.setText(post.getBody());
    }
}
