package dragon.com.mvptest;

import android.app.Application;

import dragon.com.mvptest.dagger.component.IPostComponent;

/**
 * Created by ibrishkoski on 11/21/16.
 */

public class App extends Application {

    IPostComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = ComponentFactory.create(this);
    }

    public IPostComponent getPostComponent(){
        return component;
    }
}