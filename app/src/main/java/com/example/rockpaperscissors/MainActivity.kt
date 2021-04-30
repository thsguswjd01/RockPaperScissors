package com.example.rockpaperscissors

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.rockpaperscissors.ui.main.MainFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }

    }

    fun replaceFragment(fragment: Fragment?) {
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment!!).commit()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}