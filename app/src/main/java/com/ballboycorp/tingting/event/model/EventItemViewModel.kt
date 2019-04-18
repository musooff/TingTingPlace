package com.ballboycorp.tingting.event.model

import com.ballboycorp.tingting.base.BaseObservableViewModel

/**
 * Created by musooff on 18/04/2019.
 */

class EventItemViewModel(event: Event): BaseObservableViewModel() {

    var id: Int = 0
    var title: String? = event.title
    var duration: String? = "기간 : ${event.duration}"
}