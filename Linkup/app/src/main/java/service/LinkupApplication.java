package service;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

import bean.LanguageBean;
import cn.finalteam.okhttpfinal.OkHttpFinal;
import cn.finalteam.okhttpfinal.OkHttpFinalConfiguration;
import okhttp3.Headers;

/**
 * Created by gokulkarthik on 2016/10/2 0002.
 */

public class LinkupApplication extends Application{
    public static final String APPLICATION_NAME = "Linkup";
    public static List<LanguageBean> languageList = new ArrayList<>();
    public static SharedPreferences preferences;
    public static Context context;


    @Override
    public void onCreate() {
        super.onCreate();

        preferences = getSharedPreferences(
                APPLICATION_NAME, Context.MODE_PRIVATE);
        context = this;

        initLanguage();
        initHttpUtil();
    }

    public void initLanguage(){
        languageList.add(new LanguageBean("Chinese", "zh"));
        languageList.add(new LanguageBean("English", "en"));
        languageList.add(new LanguageBean("Hindi", "hi"));
    }

    public void initHttpUtil(){
        OkHttpFinalConfiguration.Builder builder =
                new OkHttpFinalConfiguration.Builder();

        //标准http请求头
        Headers commonHeaders = new Headers.Builder().build();
        builder.setCommenHeaders(commonHeaders);

        OkHttpFinal.getInstance().init(builder.build());
    }

    public static Context getContext(){
        return context;
    }

    public static SharedPreferences getPreferences(){
        return preferences;
    }

    public static String getStringPref(String key){
        return preferences.getString(key,"");
    }

    public static void setStringPref(String key, String value){
        SharedPreferences.Editor ed = preferences.edit();
        ed.putString(key, value);
        ed.commit();
    }
}
