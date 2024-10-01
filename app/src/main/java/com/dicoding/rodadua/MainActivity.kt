package com.dicoding.rodadua

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvRodas: RecyclerView
    private val list = ArrayList<Roda>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup Toolbar (Optional if you use setSupportActionBar(toolbar) method)
        setSupportActionBar(findViewById(R.id.toolbar))

        // Set OnClickListener for profile icon
        val profileIcon = findViewById<ImageView>(R.id.about_page)
        profileIcon.setOnClickListener {
            Toast.makeText(this, "Selamat Datang di Profil ku!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, AboutMeActivity::class.java)
            startActivity(intent)
        }

        rvRodas = findViewById(R.id.rv_rodas)
        rvRodas.setHasFixedSize(true)

        list.addAll(getListRodas())
        showRecyclerList()

        // Menampilkan jumlah motor yang tersedia
        showMotorCount()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    private fun showRecyclerList() {
        rvRodas.layoutManager = LinearLayoutManager(this)
        val listRodaAdapter = ListRodaAdapter(list)
        rvRodas.adapter = listRodaAdapter

        listRodaAdapter.setOnItemClickCallback(object : ListRodaAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Roda) {
                showSelectedRoda(data)
            }
        })
    }

    private fun getListRodas(): ArrayList<Roda> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listRoda = ArrayList<Roda>()
        for (i in dataName.indices) {
            val roda = Roda(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listRoda.add(roda)
        }
        return listRoda
    }

    private fun showSelectedRoda(roda: Roda) {
        Toast.makeText(this, "Kamu memilih " + roda.name, Toast.LENGTH_SHORT).show()
    }

    // Fungsi untuk menampilkan jumlah motor yang tersedia
    private fun showMotorCount() {
        val count = list.size
        Toast.makeText(this, "Jumlah motor tersedia: $count", Toast.LENGTH_SHORT).show()
    }
}