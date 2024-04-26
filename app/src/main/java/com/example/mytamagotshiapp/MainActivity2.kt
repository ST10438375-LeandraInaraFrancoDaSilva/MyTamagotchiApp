package com.example.mytamagotshiapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    private val imgList = listOf(R.drawable.eating, R.drawable.dog_bath, R.drawable.play_dog)
    private var imgIdx = 0
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Declaring variables
        val imgV: ImageView = findViewById(R.id.MainImageView)
        val FeedButton = findViewById<Button>(R.id.FeedButton)
        val CleanButton = findViewById<Button>(R.id.CleanButton)
        val PlayButton = findViewById<Button>(R.id.PlayButton)
        val HungerTextView = findViewById<TextView>(R.id.HungerTextView)
        val CleanTextView = findViewById<TextView>(R.id.CleanTextView)
        val HappyTextView = findViewById<TextView>(R.id.HappyTextView)
        val message = findViewById<TextView>(R.id.messageTextView)
        var currentHintValue1 = 2
        var currentHintValue2 = 2
        var currentHintValue3 = 2

        // Activating feed button to change the picture according to the action
        FeedButton.setOnClickListener {
            // Selecting picture from the list
            imgV.setImageResource(imgList[0])
            imgIdx++
            Handler().postDelayed({ imgV.setImageResource(R.drawable.mydog2_0) }, 3500)
            // Updating hunger status
            if(currentHintValue1 < 10) {
                currentHintValue1++
                HungerTextView.text = currentHintValue1.toString() }
            message.text = " Keep on clicking till he's completely fed"
            if (currentHintValue1==10) {
                message.text = "What a delicious meal! Fluffly is fed :)"
            }
        }
        CleanButton.setOnClickListener {
            imgV.setImageResource(imgList[1])
            imgIdx++
            Handler().postDelayed({ imgV.setImageResource(R.drawable.mydog2_0) }, 3500)
            if (currentHintValue2 < 10) {
                currentHintValue2++
                CleanTextView.text = currentHintValue2.toString() }
            message.text = " Keep on clicking till he's completely clean"
            if (currentHintValue2==10) {
                message.text = "That's so refreshing, Fluffly is clean :)"
            }
        }
        PlayButton.setOnClickListener {
            imgV.setImageResource(imgList[2])
            imgIdx++
            Handler().postDelayed({ imgV.setImageResource(R.drawable.mydog2_0) }, 3500)
            // Setting a limit to where incrementation should stop
            if (currentHintValue3 < 10) {
                currentHintValue3++
                HappyTextView.text = currentHintValue3.toString() }
            message.text = " Keep on clicking till he's completely happy"
            // Displaying a message to the user when the maximum status is achieved
            if (currentHintValue3 ==10) {
                message.text = "Good job, Fluffly is happy :)"
            }
        }

        val refreshButton = findViewById<Button>(R.id.refreshButton)
        refreshButton.setOnClickListener {
            // Linking second page to the first
            val intent = Intent(this, MainActivity2::class.java)
            // start activity
            startActivity(intent)
        }

        val restartButton = findViewById<Button>(R.id.restartButton)
        restartButton.setOnClickListener {
            // Linking second page to the first
            val intent = Intent(this, MainActivity::class.java)
            // start activity
            startActivity(intent)
        }
    }

}
