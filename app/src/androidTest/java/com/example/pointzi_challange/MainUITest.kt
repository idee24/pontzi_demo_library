package com.example.pointzi_challange


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Matchers.allOf
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainUITest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainUITest() {
        val floatingActionButton = onView(
            allOf(withId(R.id.fab), withContentDescription("fab"), isDisplayed())
        )
        floatingActionButton.perform(click())

        val dialogLayout = onView(
            allOf(
                withParent(
                    allOf(
                        withId(android.R.id.content),
                        withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java))
                    )
                ),
                isDisplayed()
            )
        )
        dialogLayout.check(matches(isDisplayed()))

        val imageView = onView(
            allOf(
                withId(R.id.imageView),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        imageView.check(matches(isDisplayed()))

        val installTimeView = onView(
            allOf(
                withId(R.id.installDateTextView), withId(R.id.installDateTextView),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        installTimeView.check(matches(isDisplayed()))

        val currentTimeView = onView(
            allOf(
                withId(R.id.dateTextView), withId(R.id.dateTextView),
                withParent(withParent(withId(android.R.id.content))),
                isDisplayed()
            )
        )
        currentTimeView.check(matches(isDisplayed()))

    }
}
