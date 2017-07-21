package com.olympichottie.loocation;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.olympichottie.loocation.activities.MainActivity;

import java.util.ArrayList;

import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    private String mStringToBetyped;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void initValidString() {
        // Specify a valid string.
        mStringToBetyped = "Espresso";
    }

    @Test
    public void sendMessage_userTypesMessage_MessageAppearsInList() {
        // Type text and then press the button.
        onView(withId(R.id.editText))
                .perform(typeText(mStringToBetyped), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.sendButton)).perform(click());
        //onData(ObjectMatchers.is(instanceOf(String.class)), containsString("ricano")));

        onData(allOf(is(instanceOf(ArrayList.class)))).check(matches(withText(mStringToBetyped)));
    }
}
