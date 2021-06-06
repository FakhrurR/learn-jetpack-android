package com.fakhrurr.moviecatalogue.ui;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.ViewInteraction;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.fakhrurr.moviecatalogue.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityTest {

    @Before
    public void setUp() {
        ActivityScenario.launch(MainActivity.class);
    }

    @Test
    public void testValidationViewTab() {
        onView(withId(R.id.tabs)).check(matches(isDisplayed()));
        onView(withId(R.id.view_pager)).check(matches(isDisplayed()));

        ViewInteraction tabView = onView(
                allOf(withContentDescription("Movie"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabs),
                                        0),
                                1),
                        isDisplayed()));
        tabView.perform(click());

        ViewInteraction tabViewTV = onView(
                allOf(withContentDescription("TV Show"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabs),
                                        0),
                                0),
                        isDisplayed()));
        tabViewTV.perform(click());
    }

    @Test
    public void testViewTVShowItem() {
        onView(allOf(withId(R.id.img_item),isDisplayed()));
        onView(allOf(withId(R.id.img_item), notNullValue()));

        onView(allOf(withId(R.id.title_name),isDisplayed()));
        onView(allOf(withId(R.id.title_name), notNullValue()));

        onView(allOf(withId(R.id.date_movie),isDisplayed()));
        onView(allOf(withId(R.id.date_movie),notNullValue()));

        onView(allOf(withId(R.id.genre),isDisplayed()));
        onView(allOf(withId(R.id.genre),notNullValue()));

        onView(allOf(withId(R.id.description_name),isDisplayed()));
        onView(allOf(withId(R.id.genre),notNullValue()));
    }

    @Test
    public void testViewMoviesItem(){
        ViewInteraction tabView = onView(
                allOf(withContentDescription("Movie"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabs),
                                        0),
                                1),
                        isDisplayed()));
        tabView.perform(click());

        onView(allOf(withId(R.id.img_item),isDisplayed()));
        onView(allOf(withId(R.id.img_item), notNullValue()));

        onView(allOf(withId(R.id.title_name),isDisplayed()));
        onView(allOf(withId(R.id.title_name), notNullValue()));

        onView(allOf(withId(R.id.date_movie),isDisplayed()));
        onView(allOf(withId(R.id.date_movie),notNullValue()));

        onView(allOf(withId(R.id.genre),isDisplayed()));
        onView(allOf(withId(R.id.genre),notNullValue()));

        onView(allOf(withId(R.id.description_name),isDisplayed()));
        onView(allOf(withId(R.id.genre),notNullValue()));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
