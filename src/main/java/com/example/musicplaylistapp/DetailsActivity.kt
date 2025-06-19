package com.example.musicplaylistapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val displayBtn = findViewById<Button>(R.id.showDetailsBtn)
        val avgBtn = findViewById<Button>(R.id.AverageBtn)
        val backBtn = findViewById<Button>(R.id.backBtn)
        val textView = findViewById<TextView>(R.id.detailsTextView)

        displayBtn.setOnClickListener {
            val result = StringBuilder()
            for (i in songs.indices) {
                result.append(" ${songs[i]} by ${artists[i]}\n")
                result.append(" Rating: ${ratings[i]}\n")
                result.append(" Comment: ${comments[i]}\n\n")
            }
            textView.text = result.toString()
        }

        avgBtn.setOnClickListener {
            if (ratings.isNotEmpty()) {
                val avg = ratings.sum().toDouble() / ratings.size
                textView.text = "Average Rating: %.2f".format(avg)
            } else {
                textView.text = "No ratings yet!"
            }
        }

        backBtn.setOnClickListener {
            finish()
        }
    }
}
