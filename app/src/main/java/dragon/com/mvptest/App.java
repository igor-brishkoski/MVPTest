package dragon.com.mvptest;

import android.app.Application;

import dragon.com.mvptest.dagger.component.DaggerNetComponent;
import dragon.com.mvptest.dagger.component.NetComponent;
import dragon.com.mvptest.dagger.module.AppModule;
import dragon.com.mvptest.dagger.module.NetModule;

/**
 * Created by ibrishkoski on 11/21/16.
 */

public class App extends Application {

    NetComponent netComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://jsonplaceholder.typicode.com/"))
                .build();
    }

    public NetComponent getNetComponent(){
        return netComponent;
    }
}
