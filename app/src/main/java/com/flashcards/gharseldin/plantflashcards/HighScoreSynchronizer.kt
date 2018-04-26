package com.flashcards.gharseldin.plantflashcards

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class HighScoreSynchronizer : BroadcastReceiver() {

    var power = false

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action.equals(Intent.ACTION_POWER_CONNECTED)) {
            // We are here because the device is connected to power
            power = true
            synchronize()
        } else if (intent?.action.equals(Intent.ACTION_POWER_DISCONNECTED)) {
            // We are here because the device is disconnected to power
            power = false
            synchronize()
        }
    }

    private fun synchronize() {
        if (power) {
            // synchronize scores
            var i = 1+1
        } else {
            // stop synchronizing
            var i = 1+1
        }
    }
}