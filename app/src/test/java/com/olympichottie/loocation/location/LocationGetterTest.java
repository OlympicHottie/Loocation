package com.olympichottie.loocation.location;

import com.google.android.gms.location.FusedLocationProviderClient;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;


public class LocationGetterTest {
    @Mock
    FusedLocationProviderClient fusedLocationProviderClient;

    LocationGetter locationGetter;

    @Before
    public void setUp() throws Exception {
        fusedLocationProviderClient.setMockMode(true);
        locationGetter = new LocationGetter(fusedLocationProviderClient);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void locationGetter() throws Exception {
        locationGetter.getCurrentLocation();
    }

}