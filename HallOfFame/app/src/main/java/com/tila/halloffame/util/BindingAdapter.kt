package com.tila.halloffame.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.tila.halloffame.R
class BindingAdapter {
    companion object{
        @JvmStatic
        @BindingAdapter("imageUrl")
        fun loadImage(view: ImageView, url: String?) {
            var replacedUrl = url?.replace("http", "https")
            Glide.with(view.context)
                    .load(replacedUrl)
                    .placeholder(R.drawable.loading_animation)
                    .into(view)
        }


        @JvmStatic
        @BindingAdapter("app:isVisible")
        fun setVisibility(view: View, visibility : Boolean) {
            view.visibility = if (visibility) View.VISIBLE else View.GONE
        }
    }
}