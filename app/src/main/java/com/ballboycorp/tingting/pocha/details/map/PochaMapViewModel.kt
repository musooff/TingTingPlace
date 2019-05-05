package com.ballboycorp.tingting.pocha.details.map

import androidx.databinding.Bindable
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel
import com.ballboycorp.tingting.main.pocha.model.Pocha
import com.ballboycorp.tingting.main.pocha.model.PochaItemViewModel
import net.daum.mf.map.api.MapPoint

/**
 * Created by musooff on 18/04/2019.
 */

class PochaMapViewModel: BaseObservableViewModel() {

    var pocha = PochaItemViewModel(Pocha())
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.pocha)
        }

    var currentLocation: MapPoint? = null
}