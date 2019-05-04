package com.ballboycorp.tingting.pocha.home.utils

import android.content.Context
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.profile.model.User
import com.ballboycorp.tingting.table.model.Table
import com.mikhaellopez.circularimageview.CircularImageView



/**
 * Created by musooff on 2019-05-04.
 */

object ThumbnailsView {

    private fun newThumbnail(context: Context, user: User): CircularImageView {
        val circularImageView = CircularImageView(context)
        val params = ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, 0)
        params.dimensionRatio = "1:1"
        circularImageView.layoutParams = params
        if (user.gender == 0) {
            circularImageView.setBorderColor(ContextCompat.getColor(context, R.color.colorBlue))
            circularImageView.setImageResource(R.drawable.icon_profile_thumb_male)
        }
        else {
            circularImageView.setBorderColor(ContextCompat.getColor(context, R.color.colorRed))
            circularImageView.setImageResource(R.drawable.icon_profile_thumb_female)
        }
        circularImageView.setBorderWidth(5f)
        circularImageView.scaleType = ImageView.ScaleType.CENTER_CROP
        return circularImageView
    }

    private fun newThumbnailContainer(context: Context, peopleCount: Int, index: Int): ConstraintLayout {
        val constraintLayout = ConstraintLayout(context)
        val params = ConstraintLayout.LayoutParams(0, 0)

        when(peopleCount) {
            2 -> {
                params.height = ConstraintLayout.LayoutParams.MATCH_PARENT
                params.dimensionRatio = "2:3"
                when (index) {
                    0 -> params.leftToLeft = ConstraintSet.PARENT_ID
                    1 -> params.rightToRight = ConstraintSet.PARENT_ID
                }
            }

            3 -> {
                when (index) {
                    0 -> {
                        params.width = ConstraintLayout.LayoutParams.MATCH_PARENT
                        params.topToTop = ConstraintSet.PARENT_ID
                        params.dimensionRatio = "100:54"
                    }
                    1 -> {
                        params.height = ConstraintLayout.LayoutParams.MATCH_PARENT
                        params.leftToLeft = ConstraintSet.PARENT_ID
                        params.dimensionRatio = "54:100"
                    }
                    2 -> {
                        params.height = ConstraintLayout.LayoutParams.MATCH_PARENT
                        params.rightToRight = ConstraintSet.PARENT_ID
                        params.dimensionRatio = "54:100"
                    }
                }
            }
            4 -> {
                params.height = ConstraintLayout.LayoutParams.MATCH_PARENT
                params.dimensionRatio = "46:100"
                when (index) {
                    0 -> params.leftToLeft = ConstraintSet.PARENT_ID
                    1 -> params.rightToRight = ConstraintSet.PARENT_ID
                    2 -> params.leftToLeft = ConstraintSet.PARENT_ID
                    3 -> params.rightToRight = ConstraintSet.PARENT_ID
                }
            }
        }

        constraintLayout.layoutParams = params
        return constraintLayout

    }

    fun createThumbnails(context: Context, table: Table): ConstraintLayout? {
        val constraintLayout = ConstraintLayout(context)
        val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
        params.setMargins(0, 12, 12, 12)
        constraintLayout.layoutParams = params

        when(table.people.size) {
            0 -> {}
            1 -> constraintLayout.addView(newThumbnail(context, table.people[0]))
            2 -> {
                val thumbFirst = newThumbnail(context, table.people[0])
                val thumbSecond = newThumbnail(context, table.people[1])

                val thumbFirstContainer = newThumbnailContainer(context, 2, 0)
                val thumbSecondContainer = newThumbnailContainer(context, 2, 1)

                val thumbFirstParams = thumbFirst.layoutParams as ConstraintLayout.LayoutParams
                val thumbSecondParams = thumbSecond.layoutParams as ConstraintLayout.LayoutParams

                thumbFirstParams.topToTop = ConstraintSet.PARENT_ID
                thumbSecondParams.bottomToBottom = ConstraintSet.PARENT_ID

                thumbFirst.layoutParams = thumbFirstParams
                thumbSecond.layoutParams = thumbSecondParams

                thumbFirstContainer.addView(thumbFirst)
                thumbSecondContainer.addView(thumbSecond)

                constraintLayout.addView(thumbFirstContainer)
                constraintLayout.addView(thumbSecondContainer)

            }
            3 -> {
                val thumbFirst = newThumbnail(context, table.people[0])
                val thumbSecond = newThumbnail(context, table.people[1])
                val thumbThird = newThumbnail(context, table.people[2])

                val thumbFirstContainer = newThumbnailContainer(context, 3, 0)
                val thumbSecondContainer = newThumbnailContainer(context, 3, 1)
                val thumbThirdContainer = newThumbnailContainer(context, 3, 2)

                val thumbFirstParams = thumbFirst.layoutParams as ConstraintLayout.LayoutParams
                val thumbSecondParams = thumbSecond.layoutParams as ConstraintLayout.LayoutParams
                val thumbThirdParams = thumbThird.layoutParams as ConstraintLayout.LayoutParams

                thumbFirstParams.width = 0
                thumbFirstParams.height = ConstraintLayout.LayoutParams.MATCH_PARENT
                thumbFirstParams.rightToRight = ConstraintSet.PARENT_ID
                thumbFirstParams.leftToLeft = ConstraintSet.PARENT_ID


                thumbSecondParams.bottomToBottom = ConstraintSet.PARENT_ID
                thumbThirdParams.bottomToBottom = ConstraintSet.PARENT_ID


                thumbFirst.layoutParams = thumbFirstParams
                thumbSecond.layoutParams = thumbSecondParams
                thumbThird.layoutParams = thumbThirdParams

                thumbFirstContainer.addView(thumbFirst)
                thumbSecondContainer.addView(thumbSecond)
                thumbThirdContainer.addView(thumbThird)

                constraintLayout.addView(thumbFirstContainer)
                constraintLayout.addView(thumbSecondContainer)
                constraintLayout.addView(thumbThirdContainer)
            }

            else -> {

                val thumbFirst = newThumbnail(context, table.people[0])
                val thumbSecond = newThumbnail(context, table.people[1])
                val thumbThird = newThumbnail(context, table.people[2])
                val thumbFourth = newThumbnail(context, table.people[3])

                val thumbFirstContainer = newThumbnailContainer(context, 4, 0)
                val thumbSecondContainer = newThumbnailContainer(context, 4, 1)
                val thumbThirdContainer = newThumbnailContainer(context, 4, 2)
                val thumbFourthContainer = newThumbnailContainer(context, 4, 3)

                val thumbFirstParams = thumbFirst.layoutParams as ConstraintLayout.LayoutParams
                val thumbSecondParams = thumbSecond.layoutParams as ConstraintLayout.LayoutParams
                val thumbThirdParams = thumbThird.layoutParams as ConstraintLayout.LayoutParams
                val thumbFourthParams = thumbFourth.layoutParams as ConstraintLayout.LayoutParams


                thumbFirstParams.topToTop = ConstraintSet.PARENT_ID
                thumbSecondParams.topToTop = ConstraintSet.PARENT_ID
                thumbThirdParams.bottomToBottom = ConstraintSet.PARENT_ID
                thumbFourthParams.bottomToBottom = ConstraintSet.PARENT_ID


                thumbFirst.layoutParams = thumbFirstParams
                thumbSecond.layoutParams = thumbSecondParams
                thumbThird.layoutParams = thumbThirdParams
                thumbFourth.layoutParams = thumbFourthParams

                thumbFirstContainer.addView(thumbFirst)
                thumbSecondContainer.addView(thumbSecond)
                thumbThirdContainer.addView(thumbThird)
                thumbFourthContainer.addView(thumbFourth)

                constraintLayout.addView(thumbFirstContainer)
                constraintLayout.addView(thumbSecondContainer)
                constraintLayout.addView(thumbThirdContainer)
                constraintLayout.addView(thumbFourthContainer)

            }
        }
        return constraintLayout
    }
}