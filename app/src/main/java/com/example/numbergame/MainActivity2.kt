package com.example.numbergame


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity2 : AppCompatActivity() {

    private lateinit var numberTextView: TextView
    private lateinit var factTextView: TextView
    private lateinit var generateButton: Button
    private lateinit var shareButton: Button

    private val numberFacts = mapOf(
        1 to "One is the first positive integer.",
        2 to "Two is the only even prime number.",
        3 to "Three is the first odd prime number.",
        4 to "Four is the first composite number.",
        5 to "Five is the number of senses humans have.",
        6 to "Six is the smallest perfect number.",
        7 to "Seven is often considered a lucky number.",
        8 to "Eight is the number of legs on a spider.",
        9 to "Nine is the highest single-digit number.",
        10 to "Ten is the base of the decimal system."
        // Add more facts as needed
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        numberTextView = findViewById(R.id.numberTV)
        factTextView = findViewById(R.id.factTV)
        generateButton = findViewById(R.id.generateFactbtn)
        shareButton = findViewById(R.id.sharebtn)

        generateButton.setOnClickListener {
            generateRandomNumber()
        }

        shareButton.setOnClickListener {
            shareFact()
        }
    }

    private fun generateRandomNumber() {
        val randomNumber = Random.nextInt(1, 11) // Range from 1 to 10
        numberTextView.text = randomNumber.toString()
        factTextView.text = numberFacts[randomNumber] ?: "No fact available for this number."
        shareButton.visibility = View.VISIBLE
    }

    private fun shareFact() {
        val fact = factTextView.text.toString()
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "Did you know? $fact")
            type = "text/plain"
        }
        startActivity(Intent.createChooser(shareIntent, "Share via"))
    }
}