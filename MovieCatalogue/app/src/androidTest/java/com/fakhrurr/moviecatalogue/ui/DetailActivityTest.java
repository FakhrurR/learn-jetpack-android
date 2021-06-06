package com.fakhrurr.moviecatalogue.ui;

import android.view.View;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.contrib.RecyclerViewActions;

import com.fakhrurr.moviecatalogue.R;
import com.google.android.material.tabs.TabLayout;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withTagValue;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class DetailActivityTest {
    @Before
    public void setUp() {
        ActivityScenario.launch(MainActivity.class);
    }

    @Test
    public void testTextViewDetailMovie() throws InterruptedException {
        String dummyMovieTitle = "Alita: Battle Angel (2019)";
        String dummyDes = "Ketika Alita terbangun tanpa ingatan tentang siapa dia di dunia masa depan yang tidak dia kenal, dia ditangkap oleh Ido, seorang dokter yang penuh kasih yang menyadari bahwa di suatu tempat dalam cangkang cyborg yang ditinggalkan ini adalah hati dan jiwa seorang wanita muda dengan luar biasa. lalu.";
        String dummyDate = "14/02/2019 (US)";
        String dummyGenre = "Aksi, Cerita Fiksi, Petualangan";
        int dummyImg = R.drawable.poster_alita;

        onView(withId(R.id.tabs)).perform(new TabsMatcher(1));

        Thread.sleep(2000);

        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(withId(R.id.text_title)).check(matches(withText(dummyMovieTitle)));
        onView(withId(R.id.content_text_description)).check(matches(withText(dummyDes)));
        onView(withId(R.id.text_date)).check(matches(withText(dummyDate)));
        onView(withId(R.id.text_genre)).check(matches(withText(dummyGenre)));
        onView(withId(R.id.image_poster)).check(matches(withTagValue(CoreMatchers.equalTo(dummyImg))));
    }

    @Test
    public void testTextViewDetailTVShow() {
        String dummyTitle = "The Arrow";
        String dummyDes =  "Panah adalah menceritakan kembali petualangan dari legendaris DC pahlawan Green Arrow";
        String dummyDate = "Oktober 10, 2012";
        String dummyGenre = "Kejahatan, Drama, Misteri, Aksi & Petualangan";
        int dummyImg = R.drawable.poster_arrow;

        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(withId(R.id.text_title)).check(matches(withText(dummyTitle)));
        onView(withId(R.id.content_text_description)).check(matches(withText(dummyDes)));
        onView(withId(R.id.text_date)).check(matches(withText(dummyDate)));
        onView(withId(R.id.text_genre)).check(matches(withText(dummyGenre)));
        onView(withId(R.id.image_poster)).check(matches(withTagValue(CoreMatchers.equalTo(dummyImg))));
    }

    @Test
    public void testView() {
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(withId(R.id.image_poster)).check(matches(isDisplayed()));
        onView(withId(R.id.text_title)).check(matches(isDisplayed()));
        onView(withId(R.id.text_date)).check(matches(isDisplayed()));
        onView(withId(R.id.text_genre)).check(matches(isDisplayed()));
        onView(withId(R.id.label_description)).check(matches(isDisplayed()));
        onView(withId(R.id.content_text_description)).check(matches(isDisplayed()));
    }

    public static class TabsMatcher implements ViewAction {

        int position;

        TabsMatcher(int position) {
            this.position = position;
        }

        @Override
        public Matcher<View> getConstraints() {
            return isDisplayed();
        }

        @Override
        public String getDescription() {
            return "Click on tab";
        }

        @Override
        public void perform(UiController uiController, View view) {
            if (view instanceof TabLayout) {
                TabLayout tabLayout = (TabLayout) view;
                TabLayout.Tab tab = tabLayout.getTabAt(position);
                if (tab != null) {
                    tab.select();
                }
            }
        }
    }
}