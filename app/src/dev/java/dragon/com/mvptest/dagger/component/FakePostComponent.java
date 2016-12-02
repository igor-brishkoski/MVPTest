package dragon.com.mvptest.dagger.component;

import javax.inject.Singleton;

import dagger.Component;
import dragon.com.mvptest.dagger.module.AppModule;
import dragon.com.mvptest.dagger.module.NetModule;
import dragon.com.mvptest.dagger.module.post.FakePostModule;
import dragon.com.mvptest.ui.MainActivity;

/**
 * Created by ibrishkoski on 12/2/16.
 */
@Singleton
@Component(modules = {AppModule.class, NetModule.class, FakePostModule.class})
public interface FakePostComponent extends IPostComponent {

    @Override
    void inject(MainActivity mainActivity);
}