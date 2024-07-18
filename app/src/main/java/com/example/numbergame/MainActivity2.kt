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
        10 to "Ten is the base of the decimal system.",
        11 to "Eleven is a prime number.",
        12 to "Twelve is a dozen.",
        13 to "Thirteen is considered an unlucky number in some cultures.",
        14 to "Fourteen is the number of days in a fortnight.",
        15 to "Fifteen is the product of three and five.",
        16 to "Sixteen is four squared.",
        17 to "Seventeen is a prime number.",
        18 to "Eighteen is the age of majority in many countries.",
        19 to "Nineteen is the last year of teenage.",
        20 to "Twenty is the number of fingers and toes combined.",
        21 to "Twenty-one is the age of legal adulthood in some countries.",
        22 to "Twenty-two is a palindromic number.",
        23 to "Twenty-three is a prime number.",
        24 to "Twenty-four is the number of hours in a day.",
        25 to "Twenty-five is a quarter of a hundred.",
        26 to "Twenty-six is the number of letters in the English alphabet.",
        27 to "Twenty-seven is three cubed.",
        28 to "Twenty-eight is a perfect number.",
        29 to "Twenty-nine is a prime number.",
        30 to "Thirty is the number of days in some months.",
        31 to "Thirty-one is a prime number.",
        32 to "Thirty-two is two to the fifth power.",
        33 to "Thirty-three is the atomic number of arsenic.",
        34 to "Thirty-four is the ninth Fibonacci number.",
        35 to "Thirty-five is the product of five and seven.",
        36 to "Thirty-six is six squared.",
        37 to "Thirty-seven is a prime number.",
        38 to "Thirty-eight is the atomic number of strontium.",
        39 to "Thirty-nine is three times thirteen.",
        40 to "Forty is the number of days in Lent.",
        41 to "Forty-one is a prime number.",
        42 to "Forty-two is the answer to life, the universe, and everything.",
        43 to "Forty-three is a prime number.",
        44 to "Forty-four is a palindromic number.",
        45 to "Forty-five is the sum of all single-digit numbers.",
        46 to "Forty-six is the atomic number of palladium.",
        47 to "Forty-seven is a prime number.",
        48 to "Forty-eight is the atomic number of cadmium.",
        49 to "Forty-nine is seven squared.",
        50 to "Fifty is half of a hundred.",
        51 to "Fifty-one is the atomic number of antimony.",
        52 to "Fifty-two is the number of weeks in a year.",
        53 to "Fifty-three is a prime number.",
        54 to "Fifty-four is three times eighteen.",
        55 to "Fifty-five is a Fibonacci number.",
        56 to "Fifty-six is the sum of the first six triangular numbers.",
        57 to "Fifty-seven is three times nineteen.",
        58 to "Fifty-eight is the number of counties in California.",
        59 to "Fifty-nine is a prime number.",
        60 to "Sixty is the number of seconds in a minute.",
        61 to "Sixty-one is a prime number.",
        62 to "Sixty-two is the atomic number of samarium.",
        63 to "Sixty-three is nine times seven.",
        64 to "Sixty-four is two to the sixth power.",
        65 to "Sixty-five is the retirement age in some countries.",
        66 to "Sixty-six is the number of books in the Protestant Bible.",
        67 to "Sixty-seven is a prime number.",
        68 to "Sixty-eight is the atomic number of erbium.",
        69 to "Sixty-nine is a palindromic number.",
        70 to "Seventy is three score and ten.",
        71 to "Seventy-one is a prime number.",
        72 to "Seventy-two is the number of degrees in the internal angles of a regular pentagon.",
        73 to "Seventy-three is a prime number.",
        74 to "Seventy-four is the atomic number of tungsten.",
        75 to "Seventy-five is the product of three and twenty-five.",
        76 to "Seventy-six is the atomic number of osmium.",
        77 to "Seventy-seven is a palindromic number.",
        78 to "Seventy-eight is the atomic number of platinum.",
        79 to "Seventy-nine is the atomic number of gold.",
        80 to "Eighty is the number of years in eight decades.",
        81 to "Eighty-one is nine squared.",
        82 to "Eighty-two is the atomic number of lead.",
        83 to "Eighty-three is a prime number.",
        84 to "Eighty-four is the product of seven and twelve.",
        85 to "Eighty-five is the atomic number of astatine.",
        86 to "Eighty-six is the atomic number of radon.",
        87 to "Eighty-seven is the atomic number of francium.",
        88 to "Eighty-eight is a palindromic number.",
        89 to "Eighty-nine is a Fibonacci number.",
        90 to "Ninety is the number of degrees in a right angle.",
        91 to "Ninety-one is the atomic number of protactinium.",
        92 to "Ninety-two is the atomic number of uranium.",
        93 to "Ninety-three is the atomic number of neptunium.",
        94 to "Ninety-four is the atomic number of plutonium.",
        95 to "Ninety-five is the atomic number of americium.",
        96 to "Ninety-six is the number of hours in four days.",
        97 to "Ninety-seven is a prime number.",
        98 to "Ninety-eight is the atomic number of californium.",
        99 to "Ninety-nine is a palindromic number.",
        100 to "One hundred is a perfect square."
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
        val randomNumber = Random.nextInt(1, 100) // Range from 1 to 100
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