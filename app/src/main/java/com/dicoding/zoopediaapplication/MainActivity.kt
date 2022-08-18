package com.dicoding.zoopediaapplication

import android.content.ClipData
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvAnimals: RecyclerView
    private var list: ArrayList<Animal> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "Zoopedia"

        rvAnimals = findViewById(R.id.rv_animals)
        rvAnimals.setHasFixedSize(true)

        list.addAll(AnimalsData.listData)
        showRecyclerlist()
    }

    private fun showDetailAnimal(animal: Animal) {
        val moveIntent = Intent(this@MainActivity, DetailAnimal::class.java)
        moveIntent.putExtra(DetailAnimal.ANIMAL_NAME, animal.name)
        moveIntent.putExtra(DetailAnimal.ANIMAL_SCIENTIFIC_NAME, animal.scientificName)
        moveIntent.putExtra(DetailAnimal.ANIMAL_DESC, animal.describe)
        moveIntent.putExtra(DetailAnimal.ANIMAL_PIC, animal.picture)
        moveIntent.putExtra(DetailAnimal.ANIMAL_CHAR, animal.character)
        moveIntent.putExtra(DetailAnimal.ANIMAL_FOOD_1, animal.food_1)
        moveIntent.putExtra(DetailAnimal.ANIMAL_FOOD_2, animal.food_2)
        moveIntent.putExtra(DetailAnimal.ANIMAL_FOOD_3, animal.food_3)
        moveIntent.putExtra(DetailAnimal.ANIMAL_FOOD_4, animal.food_4)
        moveIntent.putExtra(DetailAnimal.INFO_SOURCE, animal.source)
        startActivity(moveIntent)
    }

    private fun showRecyclerlist() {
        rvAnimals.layoutManager = LinearLayoutManager(this)
        val listAnimalAdapter = ListAnimalAdapter(list)
        rvAnimals.adapter = listAnimalAdapter

        listAnimalAdapter.setOnItemClickCallback(object : ListAnimalAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Animal) {
                showDetailAnimal(data)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_custom,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.developer -> {
                val moveIntent = Intent(this@MainActivity, AboutMeActivity::class.java)
                startActivity(moveIntent)
                return true
            } else -> super.onOptionsItemSelected(item)
        }
    }
}