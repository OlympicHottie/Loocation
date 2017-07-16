package com.olympichottie.loocation.location;

import android.Manifest;

public class LocationPermissionManager extends PermissionManager {
    public LocationPermissionManager() {
        super(Manifest.permission.ACCESS_FINE_LOCATION, 1);
    }
}
