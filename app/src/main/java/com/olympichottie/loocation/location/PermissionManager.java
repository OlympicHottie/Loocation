package com.olympichottie.loocation.location;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

abstract class PermissionManager {

    private String permissionType;
    private int requestID;

    public PermissionManager(String permissionType, int requestID) {
        this.permissionType = permissionType;
        this.requestID = requestID;
    }

    public void requestPermission(Activity activity) {
        if (checkPermissions(activity)) {
            return;
        }

        // Should we show an explanation?
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permissionType)) {

            // Show an explanation to the user *asynchronously* -- don't block
            // this thread waiting for the user's response! After the user
            // sees the explanation, try again to request the permission.

        } else {

            // No explanation needed, we can request the permission.

            ActivityCompat.requestPermissions(activity,
                    new String[]{permissionType},
                    requestID);

            // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
            // app-defined int constant. The callback method gets the
            // result of the request.
        }


    }

    public boolean checkPermissions(Activity activity) {
        int permissionState = ActivityCompat.checkSelfPermission(activity, permissionType);
        return permissionState == PackageManager.PERMISSION_GRANTED;
    }

}

