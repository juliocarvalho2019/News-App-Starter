package br.com.carvalho.newsappstarter.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.carvalho.newsappstarter.R

class FavoriteActivity : AbstractActivity() {
    //    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_favorite)
//    }
    override fun getLayout(): Int = R.layout.activity_favorite

    override fun onInject() {
    }
}