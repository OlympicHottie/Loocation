package com.olympichottie.loocation.location;

import android.location.Location;

import com.google.android.gms.location.FusedLocationProviderClient;

public class LocationGetter {

    /**
     * Provides the entry point to the Fused SimpleLocation Provider API.
     */
    private FusedLocationProviderClient fusedLocationProviderClient;

    /**
     * Represents a geographical location.
     */
    protected Location mLastLocation;

    public LocationGetter(FusedLocationProviderClient fusedLocationProviderClient) {
        this.fusedLocationProviderClient = fusedLocationProviderClient;
    }

    /**
     * Provides a simple way of getting a device's location and is well suited for
     * applications that do not require a fine-grained location and that do not need location
     * updates. Gets the best and most recent location currently available, which may be null
     * in rare cases when a location is not available.
     * <p>
     * Note: this method should be called after location permission has been granted.
     */
    @SuppressWarnings("MissingPermission")
    public Location getCurrentLocation() {
        return fusedLocationProviderClient.getLastLocation().getResult();
    }
}
