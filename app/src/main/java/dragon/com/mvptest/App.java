package dragon.com.mvptest;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import dragon.com.mvptest.dagger.component.IPostComponent;

/**
 * Created by ibrishkoski on 11/21/16.
 */

public class App extends Application {

    IPostComponent component;
    static SharedPreferences sharedPreferences;

    @Override
    public void onCreate() {
        super.onCreate();
        component = ComponentFactory.create(this);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
    }

    public static SharedPreferences getSharePreferences(){
        return sharedPreferences;
    }

    public IPostComponent getPostComponent(){
        return component;
    }
}