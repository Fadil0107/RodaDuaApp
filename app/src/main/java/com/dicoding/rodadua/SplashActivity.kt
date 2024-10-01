package com.dicoding.rodadua

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash) // Pastikan layout ini benar

        // Timer untuk splash screen
        Handler(Looper.getMainLooper()).postDelayed({
            // Pindah ke MainActivity setelah 3 detik
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Tutup SplashActivity
        }, 3000) // 3000 ms = 3 detik
    }
}