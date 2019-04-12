package com.ballboycorp.tingting.main.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseFragment
import com.ballboycorp.tingting.databinding.FragmentProfileBinding
import com.ballboycorp.tingting.recent.RecentActivity
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.startActivity

/**
 * Created by musooff on 08/04/2019.
 */

class ProfileFragment: BaseFragment() {

    companion object {

        private const val FRAGMENT_TAG = "profile_fragment"

        fun replace(fragmentActivity: FragmentActivity) {
            val manager = fragmentActivity.supportFragmentManager
            val transaction = manager.beginTransaction()
            val fragment = ProfileFragment()
            transaction.replace(R.id.container_main, fragment, FRAGMENT_TAG)
                    .commit()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = bind<FragmentProfileBinding>(inflater, R.layout.fragment_profile, container)
        binding.clickHandler = ClickHandler()
        return binding.root
    }

    inner class ClickHandler {

        fun onClickRecent() {
            startActivity<RecentActivity>()
        }
    }
}