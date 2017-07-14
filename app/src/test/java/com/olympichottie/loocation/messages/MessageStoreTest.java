package com.olympichottie.loocation.messages;

import android.content.res.AssetFileDescriptor;
import android.widget.ArrayAdapter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MessageStoreTest {
    @Mock
    ArrayAdapter<String> adapter;
    ArrayList<String> messages;
    MessageStore messageStore;

    private static String validMessageBody = "Olympic Hottie";

    @Before
    public void setUp() throws Exception {
        messages = new ArrayList<String>();
        messageStore = new MessageStore(adapter, messages);
    }

    @Test
    public void MessageStore_AddValidMessage_MessageAppearsInListView() throws Exception {
        Message message = new TextMessage(validMessageBody);
        messageStore.addMessage(message);
        Assert.assertTrue(messages.contains(message.getMessageBody()));
    }

    @Test
    public void MessageStore_AddMToFullListView_ListViewShouldTruncateValues() throws Exception {
        int maxNumberOfMessages = MessageStore.MAX_NUMBER_OF_MESSAGES;
        for (int i = 0; i <= maxNumberOfMessages ; i++) {
            Message message = new TextMessage(String.valueOf(i));
            messageStore.addMessage(message);
        }
        Assert.assertTrue(messages.contains(String.valueOf(maxNumberOfMessages)));
        Assert.assertTrue(messages.contains(String.valueOf(maxNumberOfMessages-1)));
        Assert.assertFalse(messages.contains(String.valueOf(0)));
    }

}