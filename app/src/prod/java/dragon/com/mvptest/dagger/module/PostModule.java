package dragon.com.mvptest.dagger.module.post;

import dagger.Module;
import dagger.Provides;
import dragon.com.mvptest.ApiService;
import dragon.com.mvptest.ui.api.ApiServiceImpl;
import dragon.com.mvptest.ui.repo.PostRepository;
import dragon.com.mvptest.ui.repo.PostRepositoryImpl;
import retrofit2.Retrofit;

/**
 * Created by ibrishkoski on 11/21/16.
 */
@Module
public class PostModule implements IPostModule {

    public PostModule() {
    }

    @Override
    @Provides
    public ApiService provideService(Retrofit retrofit) {
        return new ApiServiceImpl(retrofit);
    }

    @Override
    @Provides
    public PostRepository providePostRepo(ApiService apiService) {
        return new PostRepositoryImpl(apiService);
    }

}
