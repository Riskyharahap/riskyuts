package com.example.riskyuts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.riskyuts.Fragment.HomeFragment

class DetailFoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_food)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val Food = intent.getParcelableExtra<Food>(MainActivity.INTENT_PARCELABLE)

        val imageFood: ImageView = findViewById(R.id.img_photo)
        val nameFood: TextView = findViewById(R.id.tv_name)
        val descFood: TextView = findViewById(R.id.tv_desc)

        val bundle: Bundle? = intent.extras
        val image = bundle!!.getInt("image")
        val name = bundle!!.getString("name")
        val desc = bundle!!.getString("desc")

        imageFood.setImageResource(image)
        nameFood.text = name
        descFood.text = desc

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}