package com.example.numbergame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var edtNumber: EditText
    private lateinit var txtFacts: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtNumber = findViewById(R.id.edtNumber)
        txtFacts = findViewById(R.id.txtFacts)

        edtNumber.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // No action needed
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!s.isNullOrEmpty()) {
                    val number = s.toString().toIntOrNull()
                    if (number != null) {
                        fetchMathFact(number)
                    } else {
                        txtFacts.text = "Invalid number format"
                    }
                } else {
                    txtFacts.text = "Enter a Number to get Math fact"
                }
            }

            override fun afterTextChanged(s: Editable?) {
                // No action needed
            }
        })
    }

    private fun fetchMathFact(number: Int) {
        val endpoint = "$number/math"
        APIUtils.get(endpoint, object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread {
                    txtFacts.text = "Error: ${e.message}"
                }
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val responseData = response.body?.string()
                    runOnUiThread {
                        txtFacts.text = responseData
                    }
                } else {
                    runOnUiThread {
                        txtFacts.text = "No Response"
                    }
                }
            }
        })
    }
}

//object APIUtilss {
//    private const val BASE_URL = "http://numbersapi.com/#42"
//    private val client = OkHttpClient()
//
//    fun get(endpoint: String, callback: Callback) {
//        val url = BASE_URL + endpoint
//        val request = Request.Builder()
//            .url(url)
//            .build()
//        client.newCall(request).enqueue(callback)
//    }
//}
