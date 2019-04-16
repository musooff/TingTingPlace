package com.ballboycorp.tingting.profile.create.second

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseObservableViewModel
import com.bumptech.glide.Glide

/**
 * Created by musooff on 15/04/2019.
 */

class CreateProfileSecondViewModel : BaseObservableViewModel(){

    companion object {
        @JvmStatic
        @BindingAdapter("app:loadImageCamera")
        fun loadImageCamera(imageView: ImageView, uri: Uri?){
            Glide
                    .with(imageView.context)
                    .load(uri)
                    .placeholder(R.drawable.icon_profile_camera)
                    .into(imageView)
        }
    }

    var selectedImage: Int = -1
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.selectedImage)
        }

    var thumb: Uri? = null
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.thumb)
        }

    var gender:Int = -1
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.gender)
        }
}