package com.ballboycorp.tingting.main.pocha.region.model

/**
 * Created by musooff on 2019-05-13.
 */

class Area {

    companion object {

        fun getAreas(areaResult: AreaResult): List<Area> {
            val areas: MutableList<Area> = mutableListOf()


            areas.add(Area()
                    .apply {
                        name = "서울"
                        id = 1
                    })


            areaResult.returnArray.forEach {
                if (it.parentId == "")
                    areas.add(Area()
                            .apply {
                                name = it.locationName
                                id = it.locationId?.toLong() ?: 0
                            })
            }

            areaResult.returnArray.forEach {
                if (it.parentId != "") {
                    val parentIdLong = it.parentId?.toLong() ?: 0
                    areas.first { it.id == parentIdLong }
                            .subAreas.add(SubArea()
                            .apply {
                                name = it.locationName
                                id = it.locationId?.toLong() ?: 0
                                parentId = parentIdLong
                            })

                }
            }
            return areas
        }
    }
    var id: Long = 0
    var name: String? = null
    var subAreas: MutableList<SubArea> = mutableListOf()

    inner class AreaResult {
        var returnArray: List<WeirdAreaResult> = arrayListOf()
        var returnCode: String? = null
    }

    inner class WeirdAreaResult {
        var parentId: String? = null
        var parentLocationName: String? = null
        var locationId: String? = null
        var locationName: String? = null
    }
}