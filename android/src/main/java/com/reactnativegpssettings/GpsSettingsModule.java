package com.reactnativegpssettings;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.provider.Settings;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = GpsSettingsModule.NAME)
public class GpsSettingsModule extends ReactContextBaseJavaModule {
    public static final String NAME = "GpsSettings";
    private ReactContext context;

    public GpsSettingsModule(ReactApplicationContext reactContext) {
      super(reactContext);
      context=reactContext;
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }


    // Example method
    // See https://reactnative.dev/docs/native-modules-android
    @ReactMethod
    public void isGPSEnabled(Promise promise) {
      LocationManager locationManager =
        (LocationManager) getReactApplicationContext().getSystemService(Context.LOCATION_SERVICE);
      promise.resolve(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER));
    }
  @ReactMethod
    public void openGPSSettings() {
    Intent gpsSettingsIntent= new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
    context.getCurrentActivity().startActivityForResult(gpsSettingsIntent,0);
  }

}
