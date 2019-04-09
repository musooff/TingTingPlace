package com.ballboycorp.tingting.qr

import android.os.Bundle
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.databinding.ActivityQrBinding
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
import kotlinx.android.synthetic.main.toolbar.*

/**
 * Created by musooff on 10/04/2019.
 */

class QRScanActivity: BaseActivity() {

    private val viewModel by lazy { getViewModel<QRScanViewModel>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = bind<ActivityQrBinding>(R.layout.activity_qr)
        binding.viewModel = viewModel

        customToolbar(toolbar, true)
    }
}