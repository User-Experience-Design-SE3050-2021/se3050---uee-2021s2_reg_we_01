package com.alpha.peoplesbank.retrofit;


import android.app.Activity;
import android.content.Context;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dhanushka.
 */

public class APIClient {

    private static Retrofit retrofit = null;
    static Context context;
    static Activity activity;


    public APIClient(Context ctx, Activity act) {
        context = ctx;
        activity = act;
        // private constructor to prevent access
        // only way to access: Retrofit client = RetrofitClient.getInstance();
    }

    public static Retrofit getClient() {

        //TokenAuthenticator tokenAuthenticator = new TokenAuthenticator(context, activity);


//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        //OkHttpClient okClient = new OkHttpClient.Builder().authenticator(tokenAuthenticator).build();

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .build();


        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.youtube.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();


        return retrofit;
    }


}
