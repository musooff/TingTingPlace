package com.ballboycorp.tingting.utils

import com.ballboycorp.tingting.R
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView

/**
 * Created by musooff on 2019-05-05.
 */

object MapUtils {

    fun createCustomMarker(mapView: MapView, mapPoint: MapPoint, title: String?) {
        val customMarker = MapPOIItem()
                .apply {
                    itemName = title
                    tag = 1
                    this.mapPoint = mapPoint
                    markerType = MapPOIItem.MarkerType.CustomImage
                    customImageResourceId = R.drawable.ic_map_marker
                    isCustomImageAutoscale = false
                    setCustomImageAnchor(0.5f, 1.0f)
                }

        mapView.addPOIItem(customMarker)
        mapView.setMapCenterPoint(mapPoint, false)

    }
}