package com.example.paybackcodingtask

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.paybackcodingtask.ui.activities.ImageActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ImageListFragmentTest {

    @Rule
    @JvmField
    var activityScenarioRule = ActivityScenarioRule(ImageActivity::class.java)

    @Test
    fun return_true_recyclerview_is_showing() {
        onView(withId(R.id.recyclerView))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun return_true_searchView_is_showing() {
        onView(withId(R.id.searchView))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun return_true_empty_section_is_showing() {
        runBlocking {
            onView(withId(R.id.searchTextView)).perform(replaceText("Anotherewhibjnkhugytfdr"))
            onView(withId(R.id.confirmSearch)).perform(click());
            delay(5000)
            onView(withId(R.id.noResultView)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        }

    }
}