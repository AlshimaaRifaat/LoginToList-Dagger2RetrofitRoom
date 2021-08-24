package unilever.it.org.di.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
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