package com.stone.newsapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.stone.newsapp.model.Article
import retrofit2.Retrofit

@Database(entities = [Article::class],version=1)
@TypeConverters(Converters::class)
abstract class ArticleDatabase :RoomDatabase(){

    abstract fun getArticleDao():ArticleDao

    companion object{
        @Volatile
        private var instance:ArticleDatabase?=null

        operator fun invoke(context:Context):ArticleDatabase{
            return instance ?: synchronized(this){
                val ins= createDB(context)

                instance=ins

                ins
            }
        }
        private fun createDB(context: Context)=
            Room.databaseBuilder(context,ArticleDatabase::class.java,"ArticlesDB")
                .build()
    }
}