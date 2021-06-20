package com.fakhrurr.moviecatalogue.ui;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.fakhrurr.moviecatalogue.R;
import com.fakhrurr.moviecatalogue.data.model.movie.nowplaying.ResultsItemNowPlaying;
import com.fakhrurr.moviecatalogue.data.model.tvshow.airingtoday.ResultsItemTVAiringToday;
import com.fakhrurr.moviecatalogue.utils.DummyData;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4ClassRunner.class)
public class MainActivityTest {

    private final List<ResultsItemNowPlaying> dummyNowPlay = DummyData.generateDummyNowPlaying();
    private final List<ResultsItemTVAiringToday> dummyAiringToday = DummyData.generateDummyTVAiringToday();

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
    public void loadNowPlaying() throws InterruptedException {
        ViewInteraction tabView = onView(
                allOf(withContentDescription("Movie"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabs),
                                        0),
                                1),
                        isDisplayed()));
        tabView.perform(click());
        Thread.sleep(2000);
        onView(allOf(withId(R.id.rv_movie), isDisplayed()));
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition(dummyNowPlay.size()));
    }

    @Test
    public void loadTVAiringToday() throws InterruptedException {
        Thread.sleep(2000);
        onView(allOf(withId(R.id.rv_tv_show), isDisplayed()));
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.scrollToPosition(dummyAiringToday.size()));
    }
}
