package com.ballboycorp.tingting.profile.create

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.databinding.ActivityCreateProfileBinding
import com.ballboycorp.tingting.profile.create.first.CreateProfileFirstFragment
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
import kotlinx.android.synthetic.main.activity_create_profile.*
import kotlinx.android.synthetic.main.toolbar.*

/**
 * Created by musooff on 14/04/2019.
 */

class CreateProfileActivity: BaseActivity() {

    private val viewModel by lazy { getViewModel<CreateProfileViewModel>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = bind<ActivityCreateProfileBinding>(R.layout.activity_create_profile)
        binding.viewModel = viewModel
        binding.clickHandler = ClickHandler()
        customToolbar(toolbar, "프로필 생성", true)

        vp_create.adapter = CreateAdapter()
    }

    inner class ClickHandler {
        fun onClickNext() {

        }
    }

    inner class CreateAdapter: FragmentStatePagerAdapter(supportFragmentManager) {
        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> CreateProfileFirstFragment()
                1 -> Fragment()
                else -> Fragment()
            }
        }

        override fun getCount(): Int {
            return 2
        }

    }
}