package com.ballboycorp.tingting.pocha.chat.model

import com.ballboycorp.tingting.profile.model.User
import kotlin.random.Random

/**
 * Created by musooff on 2019-05-01.
 */

class Chat {
    var id: Int = 0
    var sender: User? = User()
    var lastMessage: String? = "공지드립니다. 게임을 하시기에 앞서 주의해야"
    var notReadCount: Int =  Random.nextInt(20)

}