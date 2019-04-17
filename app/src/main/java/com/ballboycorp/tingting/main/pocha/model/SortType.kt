package com.ballboycorp.tingting.main.pocha.model

enum class SortType(val text: String) {
    RATING("평점순"),
    DISTANCE("거리순"),
    REVIEW("리뷰순");

    companion object {
        fun getSortType(text: String) = values().first { it.text == text }
    }
}