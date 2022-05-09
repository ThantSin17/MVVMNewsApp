package com.stone.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.stone.newsapp.R
import com.stone.newsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        // setContentView(R.layout.activity_main)

/**       val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.fragmentHost) as NavHostFragment
//        val controller=navHostFragment.navController
//        val navigation=findViewById<BottomNavigationView>(R.id.bottomNavigation)
//        navigation.setupWithNavController(controller)
**/
        val navHostFragment = binding.fragmentHost.getFragment() as NavHostFragment
        val controller = navHostFragment.navController
        binding.bottomNavigation.setupWithNavController(controller)
    }
}