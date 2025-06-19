package com.example.musicplaylistapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

val songs = mutableListOf<String>()
val artists = mutableListOf<String>()
val ratings = mutableListOf<Int>()
val comments = mutableListOf<String>()

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val songTitleInput = findViewById<EditText>(R.id.songTitleInput)
        val artistInput = findViewById<EditText>(R.id.artistInput)
        val ratingInput = findViewById<EditText>(R.id.ratingInput)
        val commentInput = findViewById<EditText>(R.id.commentInput)

        val addBtn = findViewById<Button>(R.id.addToPlaylistBtn)
        val viewBtn = findViewById<Button>(R.id.viewDetailsBtn)
        val exitBtn = findViewById<Button>(R.id.exitBtn)

        addBtn.setOnClickListener {
            val title = songTitleInput.text.toString()
            val artist = artistInput.text.toString()
            val rating = ratingInput.text.toString().toIntOrNull()
            val comment = commentInput.text.toString()

            if (title.isNotBlank() && artist.isNotBlank() && rating in 1..5) {
                songs.add(title)
                artists.add(artist)
                ratings.add(rating!!)
                comments.add(comment)
                Toast.makeText(this, "Song added!", Toast.LENGTH_SHORT).show()
                songTitleInput.text.clear()
                artistInput.text.clear()
                ratingInput.text.clear()
                commentInput.text.clear()
            } else {
                Toast.makeText(this, "Please fill all fields correctly!", Toast.LENGTH_SHORT).show()
            }
        }

        viewBtn.setOnClickListener {
            val intent = Intent(this, DetailsActivity::class.java)
            startActivity(intent)
        }

        exitBtn.setOnClickListener {
            finishAffinity()
        }
    }
}