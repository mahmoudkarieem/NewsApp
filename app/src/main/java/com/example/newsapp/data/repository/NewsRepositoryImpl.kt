package com.example.newsapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.newsapp.data.remote.NewsPagingSource
import com.example.newsapp.data.remote.api.ApiNews
import com.example.newsapp.domain.model.Article
import com.example.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(
    private val newsApi: ApiNews

) :
    NewsRepository {
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory =
            {
                NewsPagingSource(
                    source = sources.joinToString(separator = ","),
                    newsApi = newsApi
                )
            }
        ).flow

    }
}