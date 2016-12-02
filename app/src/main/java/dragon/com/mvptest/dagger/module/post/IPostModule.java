package dragon.com.mvptest.dagger.module.post;

import dragon.com.mvptest.ui.api.PostApiService;
import dragon.com.mvptest.ui.repo.PostRepository;
import retrofit2.Retrofit;

/**
 * Created by ibrishkoski on 12/2/16.
 */

public interface IPostModule {

    PostApiService provideService(Retrofit retrofit);

    PostRepository providePostRepo(PostApiService apiService);
}
