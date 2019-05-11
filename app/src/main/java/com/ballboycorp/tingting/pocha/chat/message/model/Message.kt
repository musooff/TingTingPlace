package com.ballboycorp.tingting.pocha.chat.message.model

import com.ballboycorp.tingting.my.model.User
import java.util.*

/**
 * Created by musooff on 2019-05-01.
 */

class Message {
    var id: Int = 0
    var text: String? = "안녕하세요~ 저희 1번 테이블입니다.같이 게임하고 싶어요. 어떠신가요?"
    var isSeen: Boolean? = true
    var sendTime: Date? = Date()
    var seenTime: Date? = Date()
    var sender: User? = User()
    var receiver: User? = User()
}