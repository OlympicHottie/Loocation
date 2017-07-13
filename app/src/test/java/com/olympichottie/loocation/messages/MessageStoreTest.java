package com.olympichottie.loocation.messages;

import android.app.Activity;
import android.content.Context;
import android.widget.ListView;

import static org.mockito.Mockito.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MessageStoreTest {

    @Mock
    Context mMockContext;

    @Mock
    Activity activity;

    @Mock
    ListView listView;

    MessageStore messageStore;

    @Before
    public void setUp() throws Exception {
        messageStore = new MessageStore(activity, listView);

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void MessageStore_AddValidMessage_MessageAppearsInListView() throws Exception {
        String validMessageBody = "Olympic Hottie";
        Message message = new TextMessage(validMessageBody);
        messageStore.addMessage(message);
    }

}