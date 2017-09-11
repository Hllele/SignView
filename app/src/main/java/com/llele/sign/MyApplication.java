package com.llele.sign;

import android.app.Application;
import android.content.Context;

/**
 * Author： huanglele on 2017/9/11.
 */

public class MyApplication extends Application {


    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }


}
