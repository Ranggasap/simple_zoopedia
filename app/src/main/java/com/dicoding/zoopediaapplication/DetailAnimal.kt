package com.dicoding.zoopediaapplication

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.dicoding.zoopediaapplication.R
import org.w3c.dom.Text

class DetailAnimal : AppCompatActivity() {

    companion object {
        const val ANIMAL_NAME = "animal name"
        const val ANIMAL_SCIENTIFIC_NAME = "animal scientific name"
        const val ANIMAL_DESC = "animal describtion"
        const val ANIMAL_PIC = "animal Picture"
        const val ANIMAL_CHAR = "animal character"
        const val ANIMAL_FOOD_1 = "animal food 1"
        const val ANIMAL_FOOD_2 = "animal food 2"
        const val ANIMAL_FOOD_3 = "animal food 3"
        const val ANIMAL_FOOD_4 = "animal food 4"
        const val INFO_SOURCE = "information source"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_animal)

        title = "Detail Animal"

        val rl : RelativeLayout = findViewById(R.id.relativeLayout_1)

        val tvAnimalName : TextView = findViewById(R.id.tv_animal_name)
        val tvAnimalScientificName : TextView = findViewById(R.id.tv_animal_scientific_name)
        val tvAnimalPicture : ImageView = findViewById(R.id.tv_animal_picture)
        val tvAnimalDesc : TextView = findViewById(R.id.tv_animal_desc)
        val tvAnimalChar : TextView = findViewById(R.id.tv_character_1)
        val tvAnimalFood1 : TextView = findViewById(R.id.tv_favorit_food_1)
        val tvAnimalFood2 : TextView = findViewById(R.id.tv_favorit_food_2)
        val tvAnimalFood3 : TextView = findViewById(R.id.tv_favorit_food_3)
        val tvAnimalFood4 : TextView = findViewById(R.id.tv_favorit_food_4)
        val tvInfoSource : TextView = findViewById(R.id.tv_source_info_1)

        val animalName = intent.getStringExtra(ANIMAL_NAME)
        val animalScientificName = intent.getStringExtra(ANIMAL_SCIENTIFIC_NAME)
        val animalDesc = intent.getStringExtra(ANIMAL_DESC)
        val animalPic = intent.getIntExtra(ANIMAL_PIC,0)
        val animalChar = intent.getStringExtra(ANIMAL_CHAR)
        val animalFood1 = intent.getStringExtra(ANIMAL_FOOD_1)
        val animalFood2 = intent.getStringExtra(ANIMAL_FOOD_2)
        val animalFood3 = intent.getStringExtra(ANIMAL_FOOD_3)
        val animalFood4 = intent.getStringExtra(ANIMAL_FOOD_4)
        val infoSource = intent.getStringExtra(INFO_SOURCE)

        tvAnimalName.text = animalName
        tvAnimalScientificName.text = animalScientificName
        tvAnimalPicture.setImageResource(animalPic)
        tvAnimalDesc.text = animalDesc
        tvAnimalChar.text = animalChar
        tvAnimalFood1.text = animalFood1
        tvAnimalFood2.text = animalFood2
        tvAnimalFood3.text = animalFood3
        tvAnimalFood4.text = animalFood4
        tvInfoSource.text = infoSource

        if(animalFood2 == "") {
            tvAnimalFood2.setVisibility(View.GONE)
        }

        if (animalFood3 == ""){
            tvAnimalFood3.setVisibility(View.GONE)
        }

        if (animalFood4 == "") {
            tvAnimalFood4.setVisibility(View.GONE)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_exit, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.exit -> {
                super.finish()
                return true
            } else -> super.onOptionsItemSelected(item)
        }
    }
}