package com.dicoding.rodadua

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Roda(
    val name: String,
    val description: String,
    val photo: Int
) : Parcelable
