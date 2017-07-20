package com.olympichottie.loocation.messages;

import android.location.Location;
import android.widget.ArrayAdapter;

import com.olympichottie.loocation.location.SimpleLocation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class MessageStoreTest {
    @Mock
    ArrayAdapter<String> adapter;
    @Mock
    Location androidLocation;
    ArrayList<Message> messages;
    MessageStore messageStore;

    private static String validMessageBody = "Olympic Hottie";

    @Before
    public void setUp() throws Exception {
        messages = new ArrayList<Message>() {};
        messageStore = new MessageStore(adapter, messages);
    }

    @Test
    public void MessageStore_AddValidMessage_MessageAppearsInListView() throws Exception {
        SimpleLocation location = new SimpleLocation(androidLocation);
        Message message = new TextMessage(validMessageBody, location);
        messageStore.addMessage(message);
        Assert.assertTrue(messages.contains(message));
    }

    @Test
    public void MessageStore_AddMToFullListView_ListViewShouldTruncateValues() throws Exception {
        SimpleLocation location = new SimpleLocation(androidLocation);
        int maxNumberOfMessages = MessageStore.MAX_NUMBER_OF_MESSAGES;
        for (int i = 0; i <= maxNumberOfMessages ; i++) {
            Message message = new TextMessage(String.valueOf(i), location);
            messageStore.addMessage(message);
        }
        Assert.assertNotNull(findMessageThatContains(messages, String.valueOf(maxNumberOfMessages)));
        Assert.assertNotNull(findMessageThatContains(messages, String.valueOf(maxNumberOfMessages-1)));
        Assert.assertNull(findMessageThatContains(messages, String.valueOf(0)));
    }

    private Message findMessageThatContains(ArrayList<Message> messages, String text) {
        for (Message message : messages) {
            if (message.getMessageBody().contains(text)) {
                return message;
            }
        }
        return null;
    }
}