package com.ballboycorp.tingting.my

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseFragment
import com.ballboycorp.tingting.databinding.FragmentProfileBinding
import com.ballboycorp.tingting.liked.LikedActivity
import com.ballboycorp.tingting.my.create.CreateProfileActivity
import com.ballboycorp.tingting.my.edit.EditProfileActivity
import com.ballboycorp.tingting.my.orders.OrdersActivity
import com.ballboycorp.tingting.recent.RecentActivity
import com.ballboycorp.tingting.review.my.MyReviewsActivity
import com.ballboycorp.tingting.shop.ShopActivity
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
import com.ballboycorp.tingting.utils.extensions.startActivity
import com.ballboycorp.tingting.utils.extensions.startActivityForResult

/**
 * Created by musooff on 08/04/2019.
 */

class MyProfileFragment: BaseFragment() {

    companion object {

        private const val FRAGMENT_TAG = "profile_fragment"

        fun replace(fragmentActivity: FragmentActivity) {
            val manager = fragmentActivity.supportFragmentManager
            val transaction = manager.beginTransaction()
            val fragment = MyProfileFragment()
            transaction.replace(R.id.container_main, fragment, FRAGMENT_TAG)
                    .commit()
        }
    }

    private val viewModel by lazy { getViewModel<MyProfileViewModel>() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = bind<FragmentProfileBinding>(inflater, R.layout.fragment_profile, container)
        binding.viewModel = viewModel
        binding.clickHandler = ClickHandler()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getUser()
    }

    inner class ClickHandler {

        fun onClickRecent() {
            startActivity<RecentActivity>()
        }

        fun onClickLiked() {
            startActivity<LikedActivity>()
        }

        fun onClickMyReviews() {
            startActivity<MyReviewsActivity>()
        }

        fun onClickEditProfile() {
            if (viewModel.user == null) {
                startActivityForResult<CreateProfileActivity>(0)
            }
            else {
                startActivityForResult<EditProfileActivity>(1)
            }
        }

        fun onClickShop() {
            startActivity<ShopActivity>()
        }

        fun onClickOrders() {
            startActivity<OrdersActivity>()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        viewModel.getUser()
    }
}