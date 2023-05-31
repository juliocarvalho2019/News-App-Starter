package br.com.carvalho.newsappstarter.ui

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import br.com.carvalho.newsappstarter.R
import br.com.carvalho.newsappstarter.databinding.ActivityArticleBinding
import br.com.carvalho.newsappstarter.model.Article
import br.com.carvalho.newsappstarter.presenter.ViewHome
import com.google.android.material.snackbar.Snackbar

class ArticleActivity : AppCompatActivity(), ViewHome.View {
    private lateinit var binding: ActivityArticleBinding
    private lateinit var article: Article

    //private lateinit var  presenter: FavoritePresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getArticle()
//        val dataSource = NewsDataSource(this)
//        presenter = FavoritePresenter(this, dataSource)

        binding.webView.apply {
            webViewClient = WebViewClient()
            article.url?.let { url ->
                loadUrl(url)
            }
        }

//        binding.fab.setOnClickListener {
//            //presenter.saveArticle(article)
//            Snackbar.make(
//                it, R.string.article_saved_successful,
//                Snackbar.LENGTH_LONG
//            ).show()
//        }
    }

    private fun getArticle() {
        intent.extras?.let { articleSend ->
            article = articleSend.get("article") as Article
        }
    }


    override fun showProgressBar() {
        TODO("Not yet implemented")
    }

    override fun showFailure(message: String) {
        TODO("Not yet implemented")
    }

    override fun hideProgressBar() {
        TODO("Not yet implemented")
    }

    override fun showArticles(articles: List<Article>) {
        TODO("Not yet implemented")
    }


}