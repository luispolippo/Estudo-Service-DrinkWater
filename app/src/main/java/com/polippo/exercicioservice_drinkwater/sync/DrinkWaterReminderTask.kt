package com.polippo.exercicioservice_drinkwater.sync

import android.content.Context
import com.polippo.exercicioservice_drinkwater.utils.PreferencesUtils

class DrinkWaterReminderTask {
    //01 - Criar uma String constante estatica chamada ACTION_INCREMENT_WATER_COUNT para representar a ação de incrementar o contador
    companion object{
        const val ACTION_INCREMENT_WATER_COUNT = "action_increment_water_count"

        private fun incrementWaterCount(context: Context){
            PreferencesUtils.incrementWaterCount(context)
        }

        fun executeTask(context: Context, action: String?){
            if(action == ACTION_INCREMENT_WATER_COUNT){
                incrementWaterCount(context)
            }
        }
    }

    /*02 -
    *   - Criar uma função privada chamada incrementWaterCount para incrementar o contador de copos d'água
    *   - Inclua um context como parâmetro da função
    *   - Chame o método incrementWaterCount da classe PreferenceUtils */

    /*03 -
    *   - Crie um método públic e estático para executar a tarefa
    *   - Coloque um context como parâmetro e um String chamada action
    *   - Quando a action for igual a constante ACTION_INCREMENT_WATER_COUNT chame o metodo incrementWaterCount desta classe*/
}