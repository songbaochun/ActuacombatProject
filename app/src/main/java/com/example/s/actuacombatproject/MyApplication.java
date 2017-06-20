package com.example.s.actuacombatproject;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;
import com.example.s.actuacombatproject.service.LocationService;

/**
 * Created by s on 17-6-19.
 */

public class MyApplication extends Application{
    private LocationService locationService;
    @Override
    public void onCreate() {
        super.onCreate();
        locationService=new LocationService(getApplicationContext());
        SDKInitializer.initialize(getApplicationContext());
    }

    public LocationService getLocationService() {
        return locationService;
    }
}
