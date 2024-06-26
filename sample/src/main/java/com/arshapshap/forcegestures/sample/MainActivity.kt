package com.arshapshap.forcegestures.sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.preference.PreferenceManager
import com.arshapshap.forcegestures.calibration.PressureCalibrator


internal class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configureForceGesturesLib()

        val navController = getNavController()
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.setupWithNavController(navController, appBarConfiguration)
    }

    private fun configureForceGesturesLib() {
        PressureCalibrator.Editor(PreferenceManager.getDefaultSharedPreferences(this))
            .loadPressure()
    }

    private fun getNavController() =
        (supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment).navController
}