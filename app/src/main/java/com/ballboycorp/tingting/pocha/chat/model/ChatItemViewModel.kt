package com.ballboycorp.tingting.pocha.chat.model

import com.ballboycorp.tingting.my.model.UserViewModel

/**
 * Created by musooff on 2019-05-01.
 */

class ChatItemViewModel(val chat: Chat) {

    var id: Int = chat.id
    var sender: UserViewModel? = chat.sender?.let { UserViewModel(it) }
    var lastMessage: String? = chat.lastMessage
    var notReadCount: Int =  chat.notReadCount
}