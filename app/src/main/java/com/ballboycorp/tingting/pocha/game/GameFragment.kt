package com.ballboycorp.tingting.pocha.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseFragment
import com.ballboycorp.tingting.databinding.FragmentGameBinding
import com.ballboycorp.tingting.utils.extensions.bind

/**
 * Created by musooff on 20/04/2019.
 */

class GameFragment: BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = bind<FragmentGameBinding>(inflater, R.layout.fragment_game, container)
        return binding.root
    }
}