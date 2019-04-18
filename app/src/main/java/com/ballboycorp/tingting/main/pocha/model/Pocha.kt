package com.ballboycorp.tingting.main.pocha.model

import com.ballboycorp.tingting.review.model.Review

/**
 * Created by musooff on 12/04/2019.
 */

class Pocha {

    var title: String? = "그린라이트 정왕점"
    var reviewCount: Int = 121
    var commentCount: Int = 232
    var distance: Int = 332
    var rating: Float = 4.2f
    var location: String? = "부평구 부평대로 31길"
    var isLiked: Boolean = true
    var description: String? = "인천에서 가장 맛있는 술집, 1시간 마다 룰렛을 돌려서 당첨된 테이블은 그때까지 나온 금액 모두 공짜!"
    var descriptionMore: String? = "ㆍ8시 이전 여성 입장시 소주 1병 무료\nㆍSNS 공유시 음료수 1병 무료"
    var phone: String? = "032-444-1234"
    var workTime: String? = "평일 11:00 ~ 24:00, 연중무휴"
    var myReview: Review? = null
}