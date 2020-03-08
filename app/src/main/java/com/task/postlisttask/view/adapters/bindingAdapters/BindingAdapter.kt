package com.task.postlisttask.view.adapters.bindingAdapters

import android.view.View
import android.view.View.*
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

object BindingAdapter {

    @BindingAdapter("image")
    @JvmStatic
    fun setImageViewImage(imageView: ImageView, imageId: Int){
        imageView.setImageResource(imageId)
    }


    @BindingAdapter("visible")
    @JvmStatic
    fun setViewVisible(view: View, state: Int){
        when(state){
            VISIBLE, INVISIBLE, GONE -> view.visibility = state
        }
    }


}