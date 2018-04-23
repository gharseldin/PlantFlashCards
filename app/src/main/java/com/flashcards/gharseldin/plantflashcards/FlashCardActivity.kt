package com.flashcards.gharseldin.plantflashcards

import android.os.AsyncTask
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.flashcards.gharseldin.plantflashcards.dto.Plant
import kotlinx.android.synthetic.main.activity_flash_card.*

class FlashCardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flash_card)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_flash_card, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun onButton5Click(v: View) {
        var i = 1 + 1
        val ONE_MINUTE = 60000
        var foo: String? = null
        var length = foo?.length ?: 10
        var plant: Plant?
        plant = Plant(10, "Somthing", "weird species", "farmer", "uncommon")
        Toast.makeText(this, plant?.toString() , Toast.LENGTH_LONG).show()

     }

    inner class GetPlantActivity: AsyncTask<String, Int, List<Plant>>(){


        override fun onPostExecute(result: List<Plant>?) {
            super.onPostExecute(result)
        }
        
        /**
         * Open a connection to a data feed to retrieve network data
         * @param search the search text that will narrow down the resuls
         * @return a collection of Plant objects that are parsed from JSON
         */
        override fun doInBackground(vararg params: String?): List<Plant> {

            TODO("implement the network call")
            // Open connection to data feed

            // Parse to plant objects

            // Add plant objects to a collection

            // return the results

        }

    }
}
