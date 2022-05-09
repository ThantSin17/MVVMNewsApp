package com.stone.newsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.stone.newsapp.model.Article

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upset(article:Article):Long

    @Query("select * from article")
    fun getAllArticles():LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)
}