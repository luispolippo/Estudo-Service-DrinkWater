package com.polippo.exercicioservice_drinkwater.sync

import android.app.IntentService
import android.content.Intent

//04 - Estenda a classe IntentService e no construtor passe o parâmetro com o mesmo nome dessa classe
class DrinkWaterReminderIntentService: IntentService("DrinkWaterReminderIntentService") {

    override fun onHandleIntent(intent: Intent?) {
        val action = intent?.action
        DrinkWaterReminderTask.executeTask(this, action)
    }

    /*05 - Sobreescreva o método onHandleIntent
    *  - Pegue a ação do intent que startou este service
    *  - Chame o método DrinkWaterReminderTask.executeTask e passe a action no parâmetro */

}