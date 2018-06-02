package com.flashcards.gharseldin.plantflashcards

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.os.AsyncTask
import android.os.Bundle
import android.provider.MediaStore
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.flashcards.gharseldin.plantflashcards.dto.Plant
import com.flashcards.gharseldin.plantflashcards.service.PlantService

class FlashCardActivity : AppCompatActivity() {

    val CAMERA_ACTIVITY_REQUEST = 10
    var imageView: ImageView? = null
    var button2: Button? = null
    var button3: Button? = null
    var button4: Button? = null
    var button5: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flash_card)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        imageView = findViewById(R.id.imageSwitcher) as ImageView
        button2 = findViewById(R.id.button2) as Button
        button3 = findViewById(R.id.button3) as Button
        button4 = findViewById(R.id.button4) as Button
        button5 = findViewById(R.id.button5) as Button

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

    fun onButton2Click(v: View) {
        var randomNumber: Int = (Math.random() * 4).toInt() + 1
        if(randomNumber == 1) {
            button2?.setBackgroundColor(Color.GREEN)
        }else if(randomNumber == 2){
            button3?.setBackgroundColor(Color.GREEN)
        }else if(randomNumber == 3){
            button4?.setBackgroundColor(Color.GREEN)
        } else {
            button5?.setBackgroundColor(Color.GREEN)
        }
    }

    fun onButton3Click(v: View) {
        var allPlants = ArrayList<Plant>()
        // vall the plant constructor to get a new Plant Object
        var redbud = Plant(83, "Cercis", "Canadensis", "", "Eastern Rudbud")
        var pawpaw = Plant(100, "Asimina", "triloba", "Alleghany", "Alleghany Pawpaw", 10)
        var i = 1 + 1

        allPlants.add(redbud)
        allPlants.add(pawpaw)

    }

    fun onButton4Click(v: View) {
        var getPlantActivity = GetPlantActivity()
        // Execute will create a new thread and invoke doInBackground in the new thread
        getPlantActivity.execute("1")
    }

    fun onButton5Click(v: View) {
        // Create an implicit intent to invoke the camera
        var camerActivityIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(camerActivityIntent, CAMERA_ACTIVITY_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == CAMERA_ACTIVITY_REQUEST) {
                // I'm hearing back from the camera

                var image = data?.extras?.get("data") as Bitmap
                imageView?.setImageBitmap(image);
            }
        }
    }

    inner class GetPlantActivity : AsyncTask<String, Int, List<Plant>>() {


        override fun onPostExecute(result: List<Plant>?) {
            super.onPostExecute(result)
        }

        /**
         * Open a connection to a data feed to retrieve network data
         * @param search the search text that will narrow down the resuls
         * @return a collection of Plant objects that are parsed from JSON
         */
        override fun doInBackground(vararg search: String?): List<Plant>? {

            var difficulty = search[0]
            var plantService = PlantService()
            var allPlants = plantService.parsePlantsFromJsonData(difficulty)
            return allPlants
        }
    }
}
