package com.ballboycorp.tingting.profile

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseObservableViewModel
import com.ballboycorp.tingting.profile.model.User
import com.bumptech.glide.Glide

/**
 * Created by musooff on 16/04/2019.
 */

class ProfileViewModel: BaseObservableViewModel() {

    companion object {
        @JvmStatic
        @BindingAdapter("app:gender", "app:uri")
        fun loadImageCamera(imageView: ImageView, gender: Int, uri: Uri?){
            Glide
                    .with(imageView.context)
                    .load(uri)
                    .placeholder(when(gender){
                        0 -> R.drawable.icon_profile_thumb_male
                        1 -> R.drawable.icon_profile_thumb_female
                        else -> R.drawable.icon_profile_camera
                    })
                    .into(imageView)
        }
    }

    var user: User? = null

    var nickname: String? = "프로필이 등록되지 않았습니다"
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.nickname)
        }
    var thumb: Uri? = null
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.thumb)
        }

    var gender: Int = -1
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.gender)
        }

    var editProfileText: String? = null
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.editProfileText)
        }

    fun getUser() {
        user = appPref.getUser()
        nickname = user?.nickname ?: "프로필이 등록되지 않았습니다"
        editProfileText = if (user == null) "프로필 등록하기" else "프로필 수정"
        thumb = user?.thumbnail?.let { Uri.parse(it) }
        gender = user?.gender ?: -1

    }
}