package br.com.carvalho.newsappstarter.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.carvalho.newsappstarter.R
import br.com.carvalho.newsappstarter.adapter.MainAdapter
import br.com.carvalho.newsappstarter.databinding.ActivityFavoriteBinding
import br.com.carvalho.newsappstarter.databinding.ActivitySearchBinding
import br.com.carvalho.newsappstarter.model.Article
import br.com.carvalho.newsappstarter.model.data.NewsDataSource
import br.com.carvalho.newsappstarter.presenter.ViewHome
import br.com.carvalho.newsappstarter.presenter.favorite.FavoritePresenter
import br.com.carvalho.newsappstarter.presenter.search.SearchPresenter

class FavoriteActivity : AppCompatActivity(), ViewHome.View  {

    private val mainAdapter by lazy {
        MainAdapter()
    }
    private lateinit var binding: ActivityFavoriteBinding
    private lateinit var presenter: FavoritePresenter
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val datasource = NewsDataSource(this)
       // presenter = FavoritePresenter(this, datasource)
       // presenter.getAll
        configRecycle()
        clickAdapter()
    }

    private fun configRecycle() {
        with(binding.rvFavorite) {
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(this@FavoriteActivity)
            addItemDecoration(
                DividerItemDecoration(
                    this@FavoriteActivity, androidx.recyclerview.widget.DividerItemDecoration.VERTICAL
                )
            )
        }
    }

    private fun clickAdapter() {
        mainAdapter.setOnclickListener { article ->
            val intent = Intent(this, ArticleActivity::class.java)
            intent.putExtra("article", article)
            startActivity(intent)
        }
    }

    override fun showProgressBar() {
        //binding.rvProgressBarSearch.visibility = View.VISIBLE
    }

    override fun showFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun hideProgressBar() {
        //binding.rvProgressBarSearch.visibility = View.INVISIBLE
    }


    override fun showArticles(articles: List<Article>) {
        mainAdapter.differ.submitList(articles.toList())
    }

}