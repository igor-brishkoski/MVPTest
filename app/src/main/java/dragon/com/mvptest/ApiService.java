package dragon.com.mvptest;

/**
 * Created by ibrishkoski on 11/21/16.
 */

public interface ApiService {
    interface ApiServiceCallback<T>{
        void onResponse(T data);
        void onError(Throwable e);
    }
}
