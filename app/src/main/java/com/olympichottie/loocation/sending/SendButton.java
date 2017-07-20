package com.olympichottie.loocation.sending;

import android.location.Location;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.olympichottie.loocation.activities.MainActivity;
import com.olympichottie.loocation.location.LocationPermissionManager;
import com.olympichottie.loocation.location.SimpleLocation;
import com.olympichottie.loocation.messages.Message;
import com.olympichottie.loocation.messages.MessageStore;
import com.olympichottie.loocation.messages.TextMessage;

public class SendButton {
    private Button buttonView;
    private FusedLocationProviderClient mFusedLocationClient;
    private MainActivity activity;

    public SendButton(MainActivity activity, Button buttonView) {
        this.activity = activity;
        this.buttonView = buttonView;
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(activity);

    }

    public void setOnClickListener(TextView input, MessageStore messageStore) {
        LocationPermissionManager locationPermissionManager = new LocationPermissionManager();
        buttonView.setOnClickListener(view -> {
            //if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(activity, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (!locationPermissionManager.checkPermissions(activity)) {
                return;
            }
            mFusedLocationClient.getLastLocation()
                    .addOnSuccessListener(activity, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            // Got last known location. In some rare situations this can be null.
                            if (location != null) {
                                SimpleLocation simpleLocation = new SimpleLocation(location);
                                Message message = new TextMessage(input.getText().toString(), simpleLocation);
                                messageStore.addMessage(message);
                            }
                        }
                    });
        });
    }
}
