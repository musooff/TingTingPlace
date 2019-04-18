package com.ballboycorp.tingting.main.pocha

import androidx.databinding.Bindable
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel

/**
 * Created by musooff on 12/04/2019.
 */

class PochaViewModel: BaseObservableViewModel() {

    var viewPagerPosition: Int = 0
        @Bindable  get() = field
        set(value) {
            field = value
            setToolbarTitle(value)
            notifyPropertyChanged(BR.viewPagerPosition)
        }

    var toolbarTitle: String? = null
        @Bindable  get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.toolbarTitle)
        }

    private fun setToolbarTitle(position: Int) {
        toolbarTitle = when (position) {
            0 -> getLocationName()
            1 -> getRegion()
            2 -> "지역 선택"
            else -> "지역 선택"
        }
    }

    private fun getRegion(): String {
        // TODO return name of the region when selected
        return "지역 선택"
    }

    private fun getLocationName(): String {
        // TODO return name of the location if available
        return "지역 선택"
    }
}