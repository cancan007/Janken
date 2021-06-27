package com.example.janken

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.edit
import androidx.preference.PreferenceManager
import com.example.janken.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.gu.setOnClickListener{onJankenButtonTapped(it)}

        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        pref.edit{
            clear()
        }
        binding.choki.setOnClickListener{onJankenButtonTapped(it)}
        binding.pa.setOnClickListener{onJankenButtonTapped(it)}
    }
    fun onJankenButtonTapped(view: View?){
        val intent = Intent(this, ResultActivity::class.java)   //開きたいアクティビティを設定
        intent.putExtra("MY_HAND", view?.id)     //様々なidを追加
        startActivity(intent)   //アクティビティを起動
    }
}