package com.stone.newsapp.delegate

import com.stone.newsapp.model.Article

interface RecyclerOnClick {
    fun onClick(article:Article)
}