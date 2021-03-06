package com.rdev.trypfordriver.data.source;

import android.annotation.SuppressLint;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;
import com.rdev.trypfordriver.utill.Utill;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class LocationRepository {
    Location cachedLocation;
    LocationManager locationManager;


    public Location getCachedLocation() {
        return cachedLocation;
    }

    public LatLng getCachedLatLng() {
        return Utill.locationToLatLng(cachedLocation);
    }

    @SuppressLint("MissingPermission")
    @Inject
    public LocationRepository(LocationManager locationManager) {
        this.locationManager = locationManager;
        boolean gps_enabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        boolean network_enabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        Log.d("tag", "Gps enabled " + gps_enabled + "network enabled " + network_enabled);
        if (network_enabled) {
            cachedLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        } else if (gps_enabled) {
            cachedLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        } else {
            cachedLocation = new Location("");
            cachedLocation.setLongitude(0);
            cachedLocation.setLatitude(0);
        }
    }


    public interface ProvideLocationCallback {
        void onLocationChanged(Location location);
    }

    @SuppressLint("MissingPermission")
    public void registerLocationListener(final ProvideLocationCallback callback) {
        callback.onLocationChanged(cachedLocation);
        locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER, 2000, 5, new LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {
                        Log.d("tag", "onLocationChanged");
                        cachedLocation = location;
                        callback.onLocationChanged(location);
                    }
                    //TODO wrap error

                    @Override
                    public void onStatusChanged(String s, int i, Bundle bundle) {
                        Log.d("tag", "onStatusChanged");

                    }

                    @Override
                    public void onProviderEnabled(String s) {
                        Log.d("tag", "onProviderEnabled");

                    }

                    @Override
                    public void onProviderDisabled(String s) {
                        Log.d("tag", "onProviderDisabled");

                    }
                });
    }
}
