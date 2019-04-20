package com.ballboycorp.tingting.pocha.dialog

import androidx.databinding.Bindable
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel

/**
 * Created by musooff on 20/04/2019.
 */

class NumberOfPeopleViewModel: BaseObservableViewModel() {

    var numberOfMale: Int = 0
        @Bindable get() = field
        set(value) {
            field = value
            updateTotal()
            notifyPropertyChanged(BR.numberOfMale)
        }

    var numberOfFemale: Int = 0
        @Bindable get() = field
        set(value) {
            field = value
            updateTotal()
            notifyPropertyChanged(BR.numberOfFemale)
        }

    var total: Int = 0
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.total)
        }

    private fun updateTotal() {
        total = numberOfMale + numberOfFemale
    }

    fun onClickMaleCount(amount: Int) {
        if (amount > 0) {
            numberOfMale ++
        }
        else if (numberOfMale > 0) {
            numberOfMale --
        }
    }

    fun onClickFemaleCount(amount: Int) {
        if (amount > 0) {
            numberOfFemale ++
        }
        else if (numberOfFemale > 0) {
            numberOfFemale --
        }
    }

}