package dragon.com.mvptest.dagger.component;

import javax.inject.Singleton;

import dagger.Component;
import dragon.com.mvptest.dagger.module.AppModule;
import dragon.com.mvptest.dagger.module.NetModule;
import dragon.com.mvptest.ui.MainActivity;

/**
 * Created by ibrishkoski on 11/21/16.
 */
@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(MainActivity mainActivity);
}
