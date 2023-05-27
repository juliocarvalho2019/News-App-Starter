package br.com.carvalho.newsappstarter.presenter.search

import br.com.carvalho.newsappstarter.model.NewsResponse
import br.com.carvalho.newsappstarter.model.data.NewsDataSource
import br.com.carvalho.newsappstarter.presenter.ViewHome

class SearchPresenter (val view: ViewHome.View,
private val dataSource: NewsDataSource): SearchHome.Presenter{
    override fun search(term: String) {
        TODO("Not yet implemented")
    }

    override fun onSuccess(newsResponse: NewsResponse) {
        TODO("Not yet implemented")
    }

    override fun onError(message: String) {
        TODO("Not yet implemented")
    }

    override fun onComplete() {
        TODO("Not yet implemented")
    }
}