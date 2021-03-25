package com.polippo.exercicioservice_drinkwater.drinkwater

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import com.polippo.exercicioservice_drinkwater.R
import com.polippo.exercicioservice_drinkwater.sync.DrinkWaterReminderIntentService
import com.polippo.exercicioservice_drinkwater.sync.DrinkWaterReminderTask
import com.polippo.exercicioservice_drinkwater.utils.PreferencesUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), SharedPreferences.OnSharedPreferenceChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //08 - Realize a chamada da função updateWaterCount
        updateWaterCount()

        imageview_cup_icon.setOnClickListener {
            //09 - chame a função incrementWaterHandler
            incrementWaterHandler()
        }

        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        prefs.registerOnSharedPreferenceChangeListener(this)
    }

    /*07 - Crie uma função updateWaterCount
    *   - Atualize o textview_quantity com o valor da PreferenceUtils.getWaterCount */

    fun updateWaterCount(){
        val count = PreferencesUtils.getWaterCount(this)
        textview_quantity.text = "$count"
    }

    /* 08 - crie uma função chamada incrementWaterHandler
    *   - Crie uma intent explicita para acionar o DrinkWaterIntentService
    *   - Defina a action da Intent com a constant ACTION_INCREMENT_WATER_COUNT
    *   - Chame startService e passe a intent como parametro
    * */
    fun incrementWaterHandler(){
        val intent = Intent(this, DrinkWaterReminderIntentService::class.java)
        intent.action = DrinkWaterReminderTask.ACTION_INCREMENT_WATER_COUNT
        startService(intent)
    }

    override fun onDestroy(){
        super.onDestroy()
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        prefs.unregisterOnSharedPreferenceChangeListener(this)
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {

        //10 - Chame o método updateWaterCount se o parametro key for igual a constante PreferenceUtils.KEY_WATER_COUNT
        if(PreferencesUtils.KEY_WATER_COUNT == key){
            updateWaterCount()
        }
    }
}