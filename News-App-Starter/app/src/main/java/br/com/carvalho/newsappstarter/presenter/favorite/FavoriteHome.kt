package br.com.carvalho.newsappstarter.presenter.favorite

import br.com.carvalho.newsappstarter.model.Article

interface FavoriteHome {

    fun showArticles(articles: List<Article>)
}