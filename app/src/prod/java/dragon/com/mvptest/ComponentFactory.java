package dragon.com.mvptest;

import android.app.Application;

import dragon.com.mvptest.dagger.component.post.DaggerPostComponent;
import dragon.com.mvptest.dagger.component.post.PostComponent;
import dragon.com.mvptest.dagger.module.AppModule;
import dragon.com.mvptest.dagger.module.NetModule;
import dragon.com.mvptest.dagger.module.PostModule;

/**
 * Created by ibrishkoski on 12/2/16.
 */

class ComponentFactory {

    public static PostComponent create(Application application) {
        return DaggerPostComponent.builder()
                .appModule(new AppModule(application))
                .netModule(new NetModule("https://jsonplaceholder.typicode.com/"))
                .postModule(new PostModule())
                .build();
    }
}