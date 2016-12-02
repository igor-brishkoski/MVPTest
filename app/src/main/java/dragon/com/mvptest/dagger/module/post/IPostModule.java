package dragon.com.mvptest.dagger.module.post;

import dragon.com.mvptest.ApiService;
import dragon.com.mvptest.ui.repo.PostRepository;
import retrofit2.Retrofit;

/**
 * Created by ibrishkoski on 12/2/16.
 */

public interface IPostModule {

    ApiService provideService(Retrofit retrofit);

    PostRepository providePostRepo(ApiService apiService);
}
