package dragon.com.mvptest;

import android.app.Application;

import dragon.com.mvptest.dagger.component.post.DaggerPostComponent;
import dragon.com.mvptest.dagger.component.post.PostComponent;
import dragon.com.mvptest.dagger.module.AppModule;
import dragon.com.mvptest.dagger.module.NetModule;
import dragon.com.mvptest.dagger.module.post.PostModule;

/**
 * Created by ibrishkoski on 11/21/16.
 */

public class App extends Application {

    PostComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerPostComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://jsonplaceholder.typicode.com/"))
                .postModule(new PostModule())
                .build();
    }

    public PostComponent getPostComponent(){
        return component;
    }
}
