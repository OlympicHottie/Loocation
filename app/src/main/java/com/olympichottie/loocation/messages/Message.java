package com.olympichottie.loocation.messages;

import com.olympichottie.loocation.location.SimpleLocation;

public interface Message {
    String getMessageContent();
    SimpleLocation getLocation();
}

