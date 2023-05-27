package br.com.carvalho.newsappstarter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.carvalho.newsappstarter.R

class MainActivity : AbstractActivity() {
    //    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//    }
    override fun getLayout(): Int = R.layout.activity_main

    override fun onInject() {
    }
}