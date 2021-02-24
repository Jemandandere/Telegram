package com.jemandandere.telegram.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.jemandandere.telegram.App
import com.jemandandere.telegram.R
import com.jemandandere.telegram.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        toolbar = binding.registerToolbar
        setSupportActionBar(toolbar)
        //title = getString(R.string.register_title_your_phone)
        App.instance.navController =
            Navigation.findNavController(this, R.id.register_navigation_controller)
        NavigationUI.setupActionBarWithNavController(this, App.instance.navController)
    }
}