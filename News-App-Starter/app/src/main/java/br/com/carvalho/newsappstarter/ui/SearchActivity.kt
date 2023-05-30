package br.com.carvalho.newsappstarter.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.util.query
import br.com.carvalho.newsappstarter.R
import br.com.carvalho.newsappstarter.adapter.MainAdapter
import br.com.carvalho.newsappstarter.databinding.ActivitySearchBinding
import br.com.carvalho.newsappstarter.model.Article
import br.com.carvalho.newsappstarter.model.data.NewsDataSource
import br.com.carvalho.newsappstarter.presenter.ViewHome
import br.com.carvalho.newsappstarter.presenter.search.SearchPresenter
import br.com.carvalho.newsappstarter.util.UtilQueryTextListener

class SearchActivity : AppCompatActivity(), ViewHome.View {

    private val mainAdapter by lazy {
        MainAdapter()
    }

    private lateinit var binding: ActivitySearchBinding
    private lateinit var presenter: SearchPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val datasource = NewsDataSource()
        presenter = SearchPresenter(this, datasource)
        configRecycle()
        search()
    }

    private fun search() {
        binding.searchNews.setOnQueryTextListener(
            UtilQueryTextListener(
                this.lifecycle
            ) { newText ->
                newText?.let { query ->
                    if (query.isNotEmpty()) {
                        presenter.search(query)
                        binding.rvProgressBarSearch.visibility = View.VISIBLE
                    }
                }
            }
        )
    }

    private fun configRecycle() {
        with(binding.rvsearch) {
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(this@SearchActivity)
            addItemDecoration(
                DividerItemDecoration(
                    this@SearchActivity, androidx.recyclerview.widget.DividerItemDecoration.VERTICAL
                )
            )
        }
    }

    override fun showProgressBar() {
        binding.rvProgressBarSearch.visibility = View.VISIBLE
    }

    override fun showFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun hideProgressBar() {
        binding.rvProgressBarSearch.visibility = View.INVISIBLE
    }

    override fun showArticles(articles: List<Article>) {
        mainAdapter.differ.submitList(articles.toList())
    }


}