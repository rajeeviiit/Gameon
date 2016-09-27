package com.example.rajeevpc.game;

import com.firebase.client.Firebase;

/**
 * Created by RajeevPC on 9/27/2016.
 */
public class CrowdWeather extends android.app.Application {
    @Override
    public void onCreate(){
        super.onCreate();
        Firebase.setAndroidContext(this);

    }
}
