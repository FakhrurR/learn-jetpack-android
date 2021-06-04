package com.fakhrurr.moviecatalogue.ui;

import androidx.test.core.app.ActivityScenario;

import com.fakhrurr.moviecatalogue.R;

import org.junit.Before;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class DetailActivityTest {
    @Before
    public void setUp() {
        ActivityScenario.launch(DetailActivity.class);
    }

    @Test
    public void testView() {
        onView(withId(R.id.image_poster)).check(matches(isDisplayed()));
        onView(withId(R.id.text_title)).check(matches(isDisplayed()));
        onView(withId(R.id.text_date)).check(matches(isDisplayed()));
        onView(withId(R.id.text_genre)).check(matches(isDisplayed()));
        onView(withId(R.id.label_description)).check(matches(isDisplayed()));
        onView(withId(R.id.content_text_description)).check(matches(isDisplayed()));
    }
}