package cn.tofly.mis.waterusermanager.data.remote;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by baoxing on 2016/9/26.
 */
public class NetServiceFactory {

    private NetServiceFactory() {
    }

    private static Retrofit mRetrofit;
    private static IExampleNetService mIExampleNetService;
    private static final String S_URL_EXAMPLE_SERVICE = "http://192.168.2.113:9002/";


    public static IExampleNetService getExampleNetService() {
        if (mIExampleNetService == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
            //setting OkHttpClient......
            mRetrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .baseUrl(S_URL_EXAMPLE_SERVICE)
                    .build();

            mIExampleNetService = mRetrofit.create(IExampleNetService.class);
        }

        return mIExampleNetService;
    }






}

















