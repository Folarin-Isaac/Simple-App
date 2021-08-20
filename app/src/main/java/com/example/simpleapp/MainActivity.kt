package com.example.simpleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.simpleapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Grabs the input text and displays it
        binding.submitButton.setOnClickListener {
            val msg = binding.inputText?.text.toString()
            binding.displayText.text = msg

        }

        // Disables the button if editText is empty
        binding?.submitButton?.isEnabled = false
        binding.inputText.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            // To make the button active when a text is typed
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding?.submitButton?.isEnabled = p0.toString().trim{ it <= ' '}.isNotEmpty()
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
    }


}
