package com.example.mytamagotshiapp

import android.content.Intent
import android.widget.Button
import junit.framework.TestCase.assertEquals
import org.junit.Test
import android . widget . ImageView
import android . widget . TextView
import androidx.test.ext.junit.runners.AndroidJUnit4
import org . junit . Assert . assertEquals
import org . junit . Before
import org . junit . runner . RunWith

private val ImageView.drawableId: Int
    get() {
        TODO("Not yet implemented")
    }

class Robolectric {
    companion object {
        fun buildActivity(java: Class<MainActivity>): Any {
            TODO("Not yet implemented")
        }
    }

}

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    private lateinit var activity: MainActivity

    @Before
    fun setup() {
        activity = Robolectric.buildActivity(MainActivity::class.java).create().get()
    }

    @Test
    fun testFeedButtonClick() {
        val feedButton = activity.findViewById<Button>(R.id.FeedButton)
        val hungerTextView = activity.findViewById<TextView>(R.id.HungerTextView)
        val messageTextView = activity.findViewById<TextView>(R.id.messageTextView)

        // Simulate a click on the FeedButton
        feedButton.performClick()

        // Check if the image resource has been set correctly
        val imgV = activity.findViewById<ImageView>(R.id.MainImageView)
        assertEquals(R.drawable.eating, imgV.drawableId)

        // Check if the HungerTextView has been updated correctly
        assertEquals("3", hungerTextView.text.toString())

        // Check if the message has been updated correctly
        assertEquals(
            " Keep on clicking till he's completely fed",
            messageTextView.text.toString()
        )
    }

    // Similarly, you can write tests for CleanButtonClick and PlayButtonClick

    @Test
    fun testRestartButtonClick() {
        val restartButton = activity.findViewById<Button>(R.id.restartButton)

        // Simulate a click on the RestartButton
        restartButton.performClick()

        // Check if the correct activity is started
        val expectedIntent = Intent(activity, MainActivity::class.java)
        val actualIntent = shadowOf(activity).nextStartedActivity
        assertEquals(expectedIntent.component, actualIntent.component)
    }

    private fun shadowOf(activity: MainActivity): Any {
        TODO("Not yet implemented")
    }
}
