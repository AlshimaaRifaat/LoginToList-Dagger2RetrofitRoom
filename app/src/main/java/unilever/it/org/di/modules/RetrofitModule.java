package unilever.it.org.di.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.android.gms.common.util.SharedPreferencesUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

import okio.BufferedSink;
import okio.Okio;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import unilever.it.org.actualsample.BuildConfig;
import unilever.it.org.actualsample.api.ServiceWrapper;
import unilever.it.org.actualsample.utils.SecurityUtil;
import unilever.it.org.actualsample.utils.StoreKeeperApplication;

@Module//(includes = NetworkModule.class)
public class RetrofitModule {

    @Provides
    OkHttpClient getOkHttpClient() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();
        return okHttpClient;
    }

    @Provides
    Gson getGson() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        return gson;
    }


    @Provides
    Retrofit getRetrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(StoreKeeperApplication.BASE_URL)
                .client(okHttpClient)
                .build();
    }

/*    @Provides
    SecretKey getSigningKey(String teamLeadToken) {

            try {
                teamLeadToken = android.util.Base64.encodeToString(
                        teamLeadToken.getBytes("UTF-8"),
                        android.util.Base64.NO_WRAP
                );
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

//            teamLeadToken = context.getResources().getString(R.string.login_key);

        return new SecretKeySpec("teamLeadToken".getBytes(), SignatureAlgorithm.HS256.getJcaName());
    }*/

  /*  @Provides
    SecretKey getSigningKey(String teamLeadToken) {
        if (teamLeadToken.isEmpty()) {
            teamLeadToken = UUID.randomUUID().toString();
        } else {
            try {
                teamLeadToken = android.util.Base64.encodeToString(
                        teamLeadToken.getBytes("UTF-8"),
                        android.util.Base64.NO_WRAP
                );
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        return new SecretKeySpec(teamLeadToken.getBytes(), SignatureAlgorithm.HS256.getJcaName());
    }

    @Provides
    String getTeamLeadToken(SharedPreferences prefs) {
        SecurityUtil secure = new SecurityUtil();
        return SharedPreferencesUtils.getString(prefs, Constants.Usertoken, "");
        *//*secure.decrypt(prefs.getString(Constants.Usertoken, ""))*//*

    }

    private String getTokenOnFire(Application context) {
        SecurityUtil secure = new SecurityUtil();
        return SharedPreferencesUtils.getString(context.getSharedPreferences(PREF_FILE_NAME,
                Context.MODE_PRIVATE), Constants.Usertoken, "");
        *//*secure.decrypt(context.getSharedPreferences(PREF_FILE_NAME,Context.MODE_PRIVATE).getString(Constants.Usertoken,""));*//*
    }
*/

}