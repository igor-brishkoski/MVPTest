package dragon.com.mvptest;

import android.app.Application;

import dragon.com.mvptest.dagger.component.DaggerFakePostComponent;
import dragon.com.mvptest.dagger.component.FakePostComponent;
import dragon.com.mvptest.dagger.module.AppModule;
import dragon.com.mvptest.dagger.module.NetModule;
import dragon.com.mvptest.dagger.module.post.FakePostModule;


/**
 * Created by ibrishkoski on 12/2/16.
 */

public class ComponentFactory {

    public static FakePostComponent create(Application application) {
        return DaggerFakePostComponent.builder()
                .appModule(new AppModule(application))
                .netModule(new NetModule("https://www.wework.com"))
                .fakePostModule(new FakePostModule())
                .build();
    }
}
