package dragon.com.mvptest.dagger.module.post;

import dagger.Module;
import dagger.Provides;
import dragon.com.mvptest.ui.api.FakeApiService;
import dragon.com.mvptest.ui.api.PostApiService;
import dragon.com.mvptest.ui.repo.PostRepository;
import dragon.com.mvptest.ui.repo.PostRepositoryImpl;
import retrofit2.Retrofit;

/**
 * Created by ibrishkoski on 12/2/16.
 */
@Module
public class FakePostModule implements IPostModule{

    @Provides
    public PostApiService provideService(Retrofit retrofit) {
        return new FakeApiService();
    }

    @Provides
    public PostRepository providePostRepo(PostApiService apiService){
        return new PostRepositoryImpl(apiService);
    }
}
