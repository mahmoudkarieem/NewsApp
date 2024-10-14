package com.example.newsapp.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.newsapp.data.remote.api.ApiNews
import com.example.newsapp.domain.model.Article

class NewsPagingSource(
    private val newsApi: ApiNews,

    private val source: String
) : PagingSource<Int, Article>() {
    private var totalCount=0
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
     return state.anchorPosition.let {anchorPosition->
         val anchorPage= anchorPosition?.let { state.closestPageToPosition(it) }
         anchorPage?.prevKey?.plus(1)?:anchorPage?.nextKey?.minus(1)
         
     }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
       val page =params.key ?:1
        return  try {
            val newsResponse=newsApi.getNews(sources = source, page = page)
            totalCount+=newsResponse.articles.size
            val articles=newsResponse.articles.distinctBy { it.title }
            LoadResult.Page(
                data = articles,
                nextKey = if(totalCount ==newsResponse.totalResults)null else page+1
                , prevKey = null
            )

        }catch (e:Exception){
            e.printStackTrace()
            LoadResult.Error(
                throwable = e
            )
        }
    }
}