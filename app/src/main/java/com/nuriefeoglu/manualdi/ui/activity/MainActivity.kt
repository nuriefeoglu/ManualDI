package com.nuriefeoglu.manualdi.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nuriefeoglu.manualdi.R
import com.nuriefeoglu.manualdi.ui.navigation.Navigator
import com.nuriefeoglu.manualdi.viewmodel.IntroViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this)[IntroViewModel::class.java]

        edt_city?.addTextChangedListener {
            viewModel.controlCity(it?.toString())
        }
        viewModel.buttonState.observe(this, Observer {
            btn_searchCity?.isEnabled = it
        })
        btn_searchCity?.setOnClickListener {
            val city = edt_city?.text?.toString()
            if (!city.isNullOrBlank()) {
                Navigator.navigateToWeatherResultActivity(this, city)
            }
        }

    }

}