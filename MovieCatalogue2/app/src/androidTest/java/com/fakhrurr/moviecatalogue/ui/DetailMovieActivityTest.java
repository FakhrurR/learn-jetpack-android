package com.fakhrurr.moviecatalogue.ui;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.contrib.RecyclerViewActions;

import com.fakhrurr.moviecatalogue.R;
import com.fakhrurr.moviecatalogue.data.local.entity.MovieEntity;
import com.fakhrurr.moviecatalogue.data.model.movie.nowplaying.ResultsItemMovie;
import com.fakhrurr.moviecatalogue.data.model.tvshow.airingtoday.ResultsItemTVAiringToday;
import com.fakhrurr.moviecatalogue.utils.DummyData;
import com.fakhrurr.moviecatalogue.utils.EspressoIdlingResource;
import com.google.android.material.tabs.TabLayout;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeLeft;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withTagValue;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

public class DetailMovieActivityTest {
    private final List<MovieEntity> dummyNowPlay = DummyData.getMovies();
    private final List<MovieEntity> dummyAiringToday = DummyData.getTvShows();

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
        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.tab_tv_show), withContentDescription("TV Show"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabs),
                                        0),
                                1),
                        isDisplayed()));
        bottomNavigationItemView.perform(click());

        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(allOf(withId(R.id.text_title), isDisplayed()));
        onView(allOf(withId(R.id.text_title), not(withText(dummyAiringToday.get(0).getTitle()))));

        onView(allOf(withId(R.id.text_date), isDisplayed()));
        onView(allOf(withId(R.id.text_date), not(withText(dummyAiringToday.get(0).getReleaseDate()))));

        onView(allOf(withId(R.id.image_poster), isDisplayed()));
        onView(allOf(withId(R.id.image_poster), not(withTagValue(CoreMatchers.equalTo(dummyAiringToday.get(0).getPosterPath())))));

        onView(allOf(withId(R.id.label_description), isDisplayed()));

        onView(allOf(withId(R.id.content_text_description), isDisplayed()));
        onView(allOf(withId(R.id.text_date), not(withText(dummyAiringToday.get(0).getOverview()))));

        onView(allOf(withId(R.id.rv_genre), isDisplayed()));
    }

    @Test
    public void loadDetailMovies() {
        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.tab_movie), withContentDescription("Movie"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabs),
                                        0),
                                0),
                        isDisplayed()));
        bottomNavigationItemView.perform(click());

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

    @Test
    public void saveFavoriteMovies() {
        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.tab_movie), withContentDescription("Movie"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabs),
                                        0),
                                0),
                        isDisplayed()));
        bottomNavigationItemView.perform(click());

        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        ViewInteraction actionMenuItemView = onView(
                allOf(withId(R.id.favorite_button), withContentDescription("tambah favorit"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.action_bar),
                                        2),
                                0),
                        isDisplayed()));
        actionMenuItemView.perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction bottomNavigationItemView2 = onView(
                allOf(withId(R.id.tab_fav), withContentDescription("Favorite"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabs),
                                        0),
                                2),
                        isDisplayed()));
        bottomNavigationItemView2.perform(click());

        onView(allOf(withId(R.id.rv_favorite_movie), isDisplayed()));
    }

    @Test
    public void emptyFavoriteMovies() {
        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.tab_movie), withContentDescription("Movie"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabs),
                                        0),
                                0),
                        isDisplayed()));
        bottomNavigationItemView.perform(click());

        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        ViewInteraction actionMenuItemView = onView(
                allOf(withId(R.id.favorite_button), withContentDescription("tambah favorit"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.action_bar),
                                        2),
                                0),
                        isDisplayed()));
        actionMenuItemView.perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction bottomNavigationItemView2 = onView(
                allOf(withId(R.id.tab_fav), withContentDescription("Favorite"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabs),
                                        0),
                                2),
                        isDisplayed()));
        bottomNavigationItemView2.perform(click());

        onView(allOf(withId(R.id.rv_favorite_movie), isDisplayed()));
        onView(withId(R.id.rv_favorite_movie)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        ViewInteraction actionMenuItemView2 = onView(
                allOf(withId(R.id.favorite_button), withContentDescription("hapus favorit"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.action_bar),
                                        2),
                                0),
                        isDisplayed()));
        actionMenuItemView2.perform(click());

        ViewInteraction appCompatImageButton2 = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton2.perform(click());

        onView(allOf(withId(R.id.text_empty_fav_movie), withText(R.string.label_empty)));
    }

    @Test
    public void saveFavoriteTVShows() {
        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.tab_tv_show), withContentDescription("TV Show"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabs),
                                        0),
                                1),
                        isDisplayed()));
        bottomNavigationItemView.perform(click());

        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        ViewInteraction actionMenuItemView = onView(
                allOf(withId(R.id.favorite_button), withContentDescription("tambah favorit"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.action_bar),
                                        2),
                                0),
                        isDisplayed()));
        actionMenuItemView.perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withContentDescription("Navigate up"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction bottomNavigationItemView2 = onView(
                allOf(withId(R.id.tab_fav), withContentDescription("Favorite"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.tabs),
                                        0),
                                2),
                        isDisplayed()));
        bottomNavigationItemView2.perform(click());

        onView(withId(R.id.tabs_fav)).perform(new TabsMatcher(1));
        onView(allOf(withId(R.id.rv_favorite_tv_show), isDisplayed()));
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