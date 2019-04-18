package com.ballboycorp.tingting.profile.create

import android.app.Activity
import android.net.Uri
import android.os.Bundle
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.databinding.ActivityCreateProfileBinding
import com.ballboycorp.tingting.profile.create.first.CreateProfileFirstFragment
import com.ballboycorp.tingting.profile.create.second.CreateProfileSecondFragment
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
import kotlinx.android.synthetic.main.activity_create_profile.*
import kotlinx.android.synthetic.main.toolbar.*





/**
 * Created by musooff on 14/04/2019.
 */

class CreateProfileActivity: BaseActivity() {

    private val viewModel by lazy { getViewModel<CreateProfileViewModel>() }

    private val adapter = CreateAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = bind<ActivityCreateProfileBinding>(R.layout.activity_create_profile)
        binding.viewModel = viewModel

        initToolbar("프로필 생성", true)

        vp_create.adapter = adapter
        vp_create.currentItem = 0
    }

    fun onMoveNext(nickname: String, gender: Int) {
        viewModel.user.nickname = nickname
        viewModel.user.gender = gender

        vp_create.currentItem = 1
        viewModel.process = 2

        vp_create.currentItem

        (adapter.secondFragment?.setGender(gender))

    }

    fun onSignUp(thumb: Uri?) {
        viewModel.user.thumbnail = thumb?.toString()
        viewModel.saveUser()
        setResult(Activity.RESULT_OK)
        finish()
    }

    inner class CreateAdapter: FragmentStatePagerAdapter(supportFragmentManager) {

        var firstFragment: CreateProfileFirstFragment? = null
        var secondFragment: CreateProfileSecondFragment? = null

        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> CreateProfileFirstFragment()
                1 -> CreateProfileSecondFragment()
                else -> Fragment()
            }
        }

        override fun getCount(): Int {
            return 2
        }

        override fun getItemPosition(`object`: Any): Int {
            return super.getItemPosition(`object`)
        }

        override fun setPrimaryItem(container: ViewGroup, position: Int, `object`: Any) {
            when (position) {
                0 -> firstFragment = `object` as CreateProfileFirstFragment
                1 -> secondFragment = `object` as CreateProfileSecondFragment
            }
            super.setPrimaryItem(container, position, `object`)
        }

    }

    override fun onBackPressed() {
        if (vp_create.currentItem == 1) {
            vp_create.currentItem = 0
            viewModel.process = 1
            return
        }
        super.onBackPressed()
    }
}