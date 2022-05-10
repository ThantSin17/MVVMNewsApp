package com.stone.newsapp.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.Coil
import coil.load
import com.stone.newsapp.R

object DataBindingAdapters {

    @BindingAdapter("imgSrc")
    fun setImage(image:ImageView,url:String){

        image.load(url){
            placeholder(coil.base.R.drawable.ic_100tb)
        }
    }
}