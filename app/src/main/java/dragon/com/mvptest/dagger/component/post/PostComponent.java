package dragon.com.mvptest.dagger.component.post;

import javax.inject.Singleton;

import dagger.Component;
import dragon.com.mvptest.dagger.module.AppModule;
import dragon.com.mvptest.dagger.module.NetModule;
import dragon.com.mvptest.dagger.module.post.PostModule;
import dragon.com.mvptest.ui.MainActivity;

/**
 * Created by ibrishkoski on 11/21/16.
 */
@Singleton
@Component(modules = {AppModule.class, NetModule.class, PostModule.class})
public interface PostComponent {
    void inject(MainActivity mainActivity);
}
