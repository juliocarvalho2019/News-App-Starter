package br.com.carvalho.newsappstarter.ui

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.carvalho.newsappstarter.R
import br.com.carvalho.newsappstarter.adapter.MainAdapter
import br.com.carvalho.newsappstarter.databinding.ActivityMainBinding
import br.com.carvalho.newsappstarter.databinding.ItemNewsBinding
import br.com.carvalho.newsappstarter.model.Article
import br.com.carvalho.newsappstarter.model.data.NewsDataSource
import br.com.carvalho.newsappstarter.presenter.ViewHome
import br.com.carvalho.newsappstarter.presenter.news.NewsPresenter

class MainActivity : AbstractActivity(), ViewHome.View {
    //    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//    }
    private val mainAdapter by lazy {
        MainAdapter()
    }

    private lateinit var presenter: NewsPresenter

    private lateinit var binding: ActivityMainBinding

    override fun getLayout(): Int = R.layout.activity_main

    override fun onInject() {
        val datasource = NewsDataSource()
        presenter = NewsPresenter(this, datasource)
        presenter.requestAll()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configRecycle()
    }

    private fun configRecycle() {
        with(binding.rvNews) {
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(
                DividerItemDecoration(
                    this@MainActivity, DividerItemDecoration.VERTICAL
                )
            )
        }
    }

    override fun showProgressBar() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvProgressBar.visibility = View.VISIBLE
    }

    override fun showFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun hideProgressBar() {
        binding.rvProgressBar.visibility = View.INVISIBLE
    }

    override fun showArticles(articles: List<Article>) {
        mainAdapter.differ.submitList(articles.toList())
    }
}