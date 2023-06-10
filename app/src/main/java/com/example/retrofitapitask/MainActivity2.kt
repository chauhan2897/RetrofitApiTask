package com.example.retrofitapitask

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var tv1 = findViewById<View>(R.id.user_id) as TextView
        var tv2 = findViewById<View>(R.id.id) as TextView
        var tv3 = findViewById<View>(R.id.title) as TextView
        var tv4 = findViewById<View>(R.id.body) as TextView

        tv1.setText("User Id: " + intent.getIntExtra("userid",0))
        tv2.setText("Id: " + intent.getIntExtra("id",0))
        tv3.setText("Title: " + intent.getStringExtra("title"))
        tv4.setText("Body: " + intent.getStringExtra("body"))
    }
}