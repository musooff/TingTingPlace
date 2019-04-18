package com.ballboycorp.tingting.contact.model

import androidx.databinding.Bindable
import com.ballboycorp.tingting.BR
import com.ballboycorp.tingting.base.BaseObservableViewModel

/**
 * Created by musooff on 18/04/2019.
 */

class QuestionItemViewModel(question: Question): BaseObservableViewModel() {
    var id = question.id
    var header: String? = if (question.isAnswered) "답변완료" else "대기"
    var isAnswered = question.isAnswered
    var title: String? = question.title
    var time: String? = question.time
    var answer: Answer? = question.answer

    var isOpen: Boolean = false
        @Bindable get() = field
        set(value) {
            field = value
            notifyPropertyChanged(BR.open)
        }
}