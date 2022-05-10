package com.stone.newsapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.stone.newsapp.databinding.ItemArticleLayoutBinding
import com.stone.newsapp.delegate.RecyclerOnClick
import com.stone.newsapp.model.Article

class NewsAdapter(private val listener: RecyclerOnClick) :
    ListAdapter<Article, NewsAdapter.ArticleViewHolder>(
        object : DiffUtil.ItemCallback<Article>() {
            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem.url == newItem.url
            }

            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem == newItem
            }
        }
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(currentList[position], listener)
    }


    class ArticleViewHolder(val binding: ItemArticleLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(article: Article, listener: RecyclerOnClick) {

            itemView.setOnClickListener { listener.onClick(article) }
        }

        companion object {
            fun create(parent: ViewGroup): ArticleViewHolder {
                val layout = ItemArticleLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent, false
                )
                return ArticleViewHolder(layout)
            }
        }

    }


}