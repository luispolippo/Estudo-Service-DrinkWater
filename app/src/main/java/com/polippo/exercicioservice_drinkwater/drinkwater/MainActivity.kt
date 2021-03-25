package com.polippo.exercicioservice_drinkwater.drinkwater

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import com.polippo.exercicioservice_drinkwater.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SharedPreferences.OnSharedPreferenceChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //TODO: 08 - Realize a chamada da função updateWaterCount

        imageview_cup_icon.setOnClickListener {
            //TODO: 09 - chame a função incrementWaterHandler
        }

        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        prefs.registerOnSharedPreferenceChangeListener(this)
    }

    /*TODO: 07 - Crie uma função updateWaterCount
    *   - Atualize o textview_quantity com o valor da PreferenceUtils.getWaterCount */

    /*TODO: 08 - crie uma função chamada incrementWaterHandler
    *   - Crie uma intent explicita para acionar o DrinkWaterIntentService
    *   - Defina a action da Intent com a constant ACTION_INCREMENT_WATER_COUNT
    *   - Chame startService e passe a intent como parametro
    * */

    override fun onDestroy(){
        super.onDestroy()
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        prefs.unregisterOnSharedPreferenceChangeListener(this)
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        //TODO: 10 - Chame o método updateWaterCount se o parametro key for igual a constante PreferenceUtils.KEY_WATER_COUNT
    }
}