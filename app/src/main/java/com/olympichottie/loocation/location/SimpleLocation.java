package com.olympichottie.loocation.location;

import android.location.Location;

public class SimpleLocation {
    private Location location;

    public SimpleLocation(Location location) {
        this.location = location;
    }

    public String toString() {
        return String.valueOf(location.getLongitude()) + ":" + String.valueOf(location.getLatitude());
    }
}
