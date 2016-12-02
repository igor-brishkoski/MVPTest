package dragon.com.mvptest.dagger.module;

import dagger.Module;
import dagger.Provides;
import dragon.com.mvptest.dagger.module.post.IPostModule;
import dragon.com.mvptest.ui.api.ApiServiceImpl;
import dragon.com.mvptest.ui.api.PostApiService;
import dragon.com.mvptest.ui.repo.PostRepository;
import dragon.com.mvptest.ui.repo.PostRepositoryImpl;
import retrofit2.Retrofit;

/**
 * Created by ibrishkoski on 11/21/16.
 */
@Module
public class PostModule implements IPostModule {

    @Provides
    public PostApiService provideService(Retrofit retrofit) {
        return new ApiServiceImpl(retrofit);
    }

    @Provides
    public PostRepository providePostRepo(PostApiService apiService) {
        return new PostRepositoryImpl(apiService);
    }

}
