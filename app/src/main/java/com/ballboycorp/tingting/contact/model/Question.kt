package com.ballboycorp.tingting.contact.model

/**
 * Created by musooff on 18/04/2019.
 */

class Question {
    var id: Int = 0
    var title: String? = "제가 너무 배가고픈데 어쩌죠?\n" +
            "너무 배고파서 밥을 먹고 싶습니다."
    var time: String? = "2018.05.24  오전 12:11"
    var isAnswered = false

    var answer: Answer? = null
}