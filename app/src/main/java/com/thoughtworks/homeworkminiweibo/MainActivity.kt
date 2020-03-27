package com.thoughtworks.homeworkminiweibo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupActionBarWithNavController(findNavController(this, R.id.fragment))
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(this, R.id.fragment).navigateUp() || super.onSupportNavigateUp()
    }
}
