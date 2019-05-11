package com.ballboycorp.tingting.my.create

import android.view.View
import android.widget.LinearLayout
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel
import com.ballboycorp.tingting.my.model.User

/**
 * Created by musooff on 14/04/2019.
 */

class CreateProfileViewModel : BaseObservableViewModel() {

    companion object {
        @JvmStatic
        @BindingAdapter("android:layout_weight")
        fun setLayoutWeight(view: View, int: Int) {
            val layoutParams = view.layoutParams as LinearLayout.LayoutParams
            layoutParams.weight = int.toFloat()
            view.layoutParams = layoutParams
        }
    }

    var user = User()

    var process: Int = 1
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.process)
        }

    fun saveUser() {
        appPref.setUser(user)
    }
}