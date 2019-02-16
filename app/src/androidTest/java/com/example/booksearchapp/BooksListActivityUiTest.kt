package com.example.booksearchapp

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.IdlingRegistry
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import com.example.booksearchapp.bookslist.BooksListActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class BooksListActivityUiTest {

    @get:Rule
    val activityTestRule = ActivityTestRule(BooksListActivity::class.java)

    @Test
    fun testRecyclerViewItemDisplayed() {
        val mainActivityIdlingResource = activityTestRule.activity.getEspressoIdlingResourceForMainActivity()
        // registering BooksListActivity idling resource for enabling Espresso sync with BooksListActivity background threads
        IdlingRegistry.getInstance().register(mainActivityIdlingResource);
        onView(ViewMatchers.withId(R.id.rvBooksList))
                .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(5, click()));
    }
}