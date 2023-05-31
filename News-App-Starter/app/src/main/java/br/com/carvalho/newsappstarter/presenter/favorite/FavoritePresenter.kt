package br.com.carvalho.newsappstarter.presenter.favorite

import br.com.carvalho.newsappstarter.model.Article
import br.com.carvalho.newsappstarter.model.data.NewsDataSource

class FavoritePresenter(private val dataSource: NewsDataSource) {
    fun saveArticle(article: Article) {
        this.dataSource.saveArticle(article)
    }
}