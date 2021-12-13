package kg;

import android.app.Application;

import kg.geektech.postfragment.data.rem.HerokuApi;
import kg.geektech.postfragment.data.rem.RetrofitClient;

public class App extends Application {
    public static HerokuApi api;

    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitClient client = new RetrofitClient();
        api=client.provideApi();
    }
}
