package com.fakhrurr.moviecatalogue.ui;

import android.view.View;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.contrib.RecyclerViewActions;

import com.fakhrurr.moviecatalogue.R;
import com.fakhrurr.moviecatalogue.data.model.movie.nowplaying.ResultsItemNowPlaying;
import com.fakhrurr.moviecatalogue.data.model.tvshow.airingtoday.ResultsItemTVAiringToday;
import com.fakhrurr.moviecatalogue.utils.DummyData;
import com.fakhrurr.moviecatalogue.utils.EspressoIdlingResource;
import com.google.android.material.tabs.TabLayout;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withTagValue;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

public class DetailMovieActivityTest {

    private final List<ResultsItemNowPlaying> dummyNowPlay = DummyData.generateDummyNowPlaying();
    private final List<ResultsItemTVAiringToday> dummyAiringToday = DummyData.generateDummyTVAiringToday();

    @Before
    public void setUp() {
        ActivityScenario.launch(MainActivity.class);
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void loadDetailTVShows() {
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(allOf(withId(R.id.text_title), isDisplayed()));
        onView(allOf(withId(R.id.text_title), not(withText(dummyAiringToday.get(0).getName()))));

        onView(allOf(withId(R.id.text_date), isDisplayed()));
        onView(allOf(withId(R.id.text_date), not(withText(dummyAiringToday.get(0).getFirstAirDate()))));

        onView(allOf(withId(R.id.image_poster), isDisplayed()));
        onView(allOf(withId(R.id.image_poster), not(withTagValue(CoreMatchers.equalTo(dummyAiringToday.get(0).getPosterPath())))));

        onView(allOf(withId(R.id.label_description), isDisplayed()));

        onView(allOf(withId(R.id.content_text_description), isDisplayed()));
        onView(allOf(withId(R.id.text_date), not(withText(dummyAiringToday.get(0).getOverview()))));

        onView(allOf(withId(R.id.rv_genre), isDisplayed()));
    }

    @Test
    public void loadDetailMovies() {

        onView(withId(R.id.tabs)).perform(new TabsMatcher(1));

        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(allOf(withId(R.id.text_title), isDisplayed()));
        onView(allOf(withId(R.id.text_title), not(withText(dummyNowPlay.get(0).getTitle()))));

        onView(allOf(withId(R.id.text_date), isDisplayed()));
        onView(allOf(withId(R.id.text_date), not(withText(dummyNowPlay.get(0).getReleaseDate()))));

        onView(allOf(withId(R.id.image_poster), isDisplayed()));
        onView(allOf(withId(R.id.image_poster), not(withTagValue(CoreMatchers.equalTo(dummyNowPlay.get(0).getPosterPath())))));

        onView(allOf(withId(R.id.label_description), isDisplayed()));

        onView(allOf(withId(R.id.content_text_description), isDisplayed()));
        onView(allOf(withId(R.id.content_text_description), not(withText(dummyNowPlay.get(0).getOverview()))));

        onView(allOf(withId(R.id.rv_genre), isDisplayed()));
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