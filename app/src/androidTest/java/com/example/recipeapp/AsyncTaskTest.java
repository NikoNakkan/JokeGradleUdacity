
package com.example.recipeapp;

import android.app.Activity;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.app.FragmentTransaction;

import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.MainActivityFragment;
import com.udacity.gradle.builditbigger.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest
{
    @Rule public ActivityTestRule<MainActivity> mainActivityActivityTestRule=new ActivityTestRule<>(MainActivity.class);
    private IdlingResource mIdlingResource;



    @Before
    public void registerIdlingResource() {
        mIdlingResource = mainActivityActivityTestRule.getActivity().getIdlingResource();
        Espresso.registerIdlingResources(mIdlingResource);
    }

    //In this I used some baking app code.Here i'm checking if the textview is displayed.If not then async returns null string
    @Test
    public void fragment_can_be_instantiated() {
        mainActivityActivityTestRule.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                MainActivityFragment voiceFragment = startMainActivityFragment();
            }
        });
        onView(withId(R.id.jokebutton)).perform(click());
        onView(withId(R.id.joke_text)).check(matches(isDisplayed()));
    }
//I found this code on a st overflow post
    private MainActivityFragment startMainActivityFragment() {
        MainActivity activity = (MainActivity) mainActivityActivityTestRule.getActivity();
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        MainActivityFragment mainActivityFragment = new MainActivityFragment();
        transaction.add(mainActivityFragment, "mainFragment");
        transaction.commit();
        return mainActivityFragment;
    }

    @After
    public void unregisterIdlingResource ()
    {
        if (mIdlingResource != null) {
            IdlingRegistry.getInstance().unregister(mIdlingResource);
        }
    }
}




