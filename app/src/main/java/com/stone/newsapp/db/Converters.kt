package com.stone.newsapp.db

import androidx.room.TypeConverter
import com.stone.newsapp.model.Source


class Converters {

    @TypeConverter
    fun fromSource(source: Source):String{
        return source.name
    }

    @TypeConverter
    fun toSource(name: String):Source{
        return Source(name,name)
    }

}