package com.ballboycorp.tingting.profile.create.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseFragment
import com.ballboycorp.tingting.databinding.FragmentCreateProfileFirstBinding
import com.ballboycorp.tingting.profile.create.CreateProfileActivity
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel

/**
 * Created by musooff on 14/04/2019.
 */

class CreateProfileFirstFragment: BaseFragment() {

    private val viewModel by lazy { getViewModel<CreateProfileFirstViewModel>() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = bind<FragmentCreateProfileFirstBinding>(inflater, R.layout.fragment_create_profile_first, container)
        binding.clickHandler = ClickHandler()
        binding.viewModel = viewModel
        return binding.root
    }

    inner class ClickHandler {
        fun onClickGender(gender: Int) {
            viewModel.gender = gender
            viewModel.verifyCanMoveNext()
        }

        fun onClickNext() {
            (activity as CreateProfileActivity).onMoveNext(viewModel.nickname!!, viewModel.gender)
        }
    }
}