package com.example.fcmapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.fcmapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData()

        binding.btnButton.setOnClickListener {

            saveData()
        }

    }

    private fun loadData() {

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedString = sharedPreferences.getString("STRING_KEY", null)
        val savedBoolean = sharedPreferences.getBoolean("BOOLEAN_KEY",false)

        binding.tvText.text = savedString
        binding.swSwitch.isChecked = savedBoolean
    }

    private fun saveData() {

        val insertedText = binding.etText.text.toString()
        binding.tvText.text = insertedText

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.apply{
            putString("STRING_KEY" , insertedText)
            putBoolean("BOOLEAN_KEY", binding.swSwitch.isChecked)
        }.apply()

        Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show()
    }



}