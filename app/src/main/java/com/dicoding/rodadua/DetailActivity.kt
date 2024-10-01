package com.dicoding.rodadua

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Mengatur Toolbar sebagai ActionBar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // Menampilkan tombol Back

        val motorName = intent.getStringExtra(EXTRA_MOTOR_NAME)
        val motorDescription = intent.getStringExtra(EXTRA_MOTOR_DESCRIPTION)
        val motorImageResId = intent.getIntExtra(EXTRA_MOTOR_IMAGE, -1)

        val ivMotorDetail = findViewById<ImageView>(R.id.iv_motor_detail)
        val tvMotorName = findViewById<TextView>(R.id.tv_motor_name)
        val tvMotorDescription = findViewById<TextView>(R.id.tv_motor_description)

        ivMotorDetail.setImageResource(motorImageResId)
        tvMotorName.text = motorName
        tvMotorDescription.text = motorDescription
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish() // Kembali ke halaman sebelumnya
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    companion object {
        const val EXTRA_MOTOR_NAME = "extra_motor_name"
        const val EXTRA_MOTOR_DESCRIPTION = "extra_motor_description"
        const val EXTRA_MOTOR_IMAGE = "extra_motor_image"
    }
}