package com.example.riskyuts

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
    class Food (
        val imageFood: Int,
        val nameFood: String,
        val descFood: String,
    ) : Parcelable