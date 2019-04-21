package com.ballboycorp.tingting.pocha.dialog

import androidx.databinding.Bindable
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel

/**
 * Created by musooff on 20/04/2019.
 */

class NumberOfPeopleViewModel : BaseObservableViewModel() {


    var maleMinCount: Int = if (appPref.getUser()?.gender == 0) 1 else 0
    var femaleMinCount: Int = if (appPref.getUser()?.gender == 1) 1 else 0

    var numberOfMale: Int = maleMinCount
        @Bindable get() = field
        set(value) {
            field = value
            updateTotal()
            notifyPropertyChanged(BR.numberOfMale)
        }

    var numberOfFemale: Int = femaleMinCount
        @Bindable get() = field
        set(value) {
            field = value
            updateTotal()
            notifyPropertyChanged(BR.numberOfFemale)
        }

    var total: Int = numberOfMale + numberOfFemale
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
            numberOfMale++
        } else if (numberOfMale > maleMinCount) {
            numberOfMale--
        }
    }

    fun onClickFemaleCount(amount: Int) {
        if (amount > 0) {
            numberOfFemale++
        } else if (numberOfFemale > femaleMinCount) {
            numberOfFemale--
        }
    }

}