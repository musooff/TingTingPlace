package com.ballboycorp.tingting.profile.model

import android.net.Uri
import com.ballboycorp.tingting.base.BaseObservableViewModel

/**
 * Created by musooff on 2019-04-21.
 */

class UserViewModel(var user: User): BaseObservableViewModel() {

    var nickname: String? = user.nickname
    var gender: Int = user.gender
    var thumbnail: Uri? = user.thumbnail?.let { Uri.parse(it) }
    var coin: String? = user.coin
}