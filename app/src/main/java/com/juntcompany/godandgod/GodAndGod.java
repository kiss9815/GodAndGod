package com.juntcompany.godandgod;

import android.app.Application;
import android.content.Context;

/**
 * Created by EOM on 2016-04-27.
 */
public class GodAndGod extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
//        FacebookSdk.sdkInitialize(this);
        context = this;
    }

    public static Context getContext(){
        return context;
    }
}
