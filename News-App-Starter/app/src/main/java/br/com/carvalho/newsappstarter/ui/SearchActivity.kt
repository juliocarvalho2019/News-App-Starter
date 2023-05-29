package br.com.carvalho.newsappstarter.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.carvalho.newsappstarter.R
import br.com.carvalho.newsappstarter.databinding.ActivityMainBinding
import br.com.carvalho.newsappstarter.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


}