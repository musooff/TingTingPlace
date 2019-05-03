package com.ballboycorp.tingting.pocha.chat.message.model

import com.ballboycorp.tingting.base.BaseObservableViewModel
import com.ballboycorp.tingting.profile.model.UserViewModel
import java.util.*

/**
 * Created by musooff on 2019-05-01.
 */

class MessageItemViewModel(val message: Message): BaseObservableViewModel() {

    var id: Int = message.id
    var text: String? = message.text
    var isSeen: Boolean? = message.isSeen
    var sendTime: Date? = message.sendTime
    var seenTime: Date? = message.seenTime
    var sender: UserViewModel? = message.sender?.let { UserViewModel(it) }
    var receiver: UserViewModel? = message.receiver?.let { UserViewModel(it) }
}