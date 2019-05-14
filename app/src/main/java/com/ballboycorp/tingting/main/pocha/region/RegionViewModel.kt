package com.ballboycorp.tingting.main.pocha.region

import com.ballboycorp.tingting.base.BaseObservableViewModel
import com.ballboycorp.tingting.main.pocha.region.model.Area
import com.ballboycorp.tingting.main.pocha.region.model.AreaItemViewModel
import com.ballboycorp.tingting.utils.extensions.observeOnMainThread
import io.reactivex.Single

/**
 * Created by musooff on 18/04/2019.
 */

class RegionViewModel : BaseObservableViewModel() {

    fun getAreas(): Single<List<AreaItemViewModel>> {
        return tingTingService.locations()
                .map { Area.getAreas(it) }
                .map { it.map { AreaItemViewModel(it) } }
                .observeOnMainThread()
    }
}