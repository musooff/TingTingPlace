package com.ballboycorp.tingting.pocha.home.dialog.hashtag

import androidx.databinding.Bindable
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel

/**
 * Created by musooff on 2019-04-22.
 */

class HashtagEditViewModel: BaseObservableViewModel() {

    var hashtag: String? = appPref.getHashtag()
        @Bindable get() = field
        set(value) {
            field = value
            charCount = value?.length ?: 0
            notifyPropertyChanged(BR.hashtag)
        }

    var charCount: Int = hashtag?.length ?: 0
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.charCount)
        }

    fun saveHashTag() {
        appPref.setHashtag(hashtag)
    }
}