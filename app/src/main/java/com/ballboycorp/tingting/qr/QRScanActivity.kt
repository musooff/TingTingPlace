package com.ballboycorp.tingting.qr

import android.os.Bundle
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.databinding.ActivityQrBinding
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
import kotlinx.android.synthetic.main.toolbar.*
import com.google.zxing.Result
import kotlinx.android.synthetic.main.activity_qr.*
import me.dm7.barcodescanner.zxing.ZXingScannerView
import me.dm7.barcodescanner.core.ViewFinderView
import me.dm7.barcodescanner.core.IViewFinder
import android.content.Context
import androidx.core.content.ContextCompat
import com.ballboycorp.tingting.pocha.PochaActivity
import com.ballboycorp.tingting.utils.extensions.startActivity


/**
 * Created by musooff on 10/04/2019.
 */

class QRScanActivity: BaseActivity(), ZXingScannerView.ResultHandler {

    private val viewModel by lazy { getViewModel<QRScanViewModel>() }
    private lateinit var mScannerView: ZXingScannerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = bind<ActivityQrBinding>(R.layout.activity_qr)
        binding.viewModel = viewModel
        binding.clickHandler = ClickHandler()
        customToolbar(toolbar, "QR코드 스캔", true)

        initialize()

    }

    private fun initialize() {
        mScannerView = object : ZXingScannerView(this) {
            override fun createViewFinderView(context: Context): IViewFinder {
                return ViewFinderView(context)
                        .apply {
                            setBorderColor(ContextCompat.getColor(this@QRScanActivity, R.color.colorPrimary))
                            setSquareViewFinder(true)
                        }
            }
        }

        container_qr.addView(mScannerView)
    }

    override fun handleResult(rawResult: Result) {
        mScannerView.stopCamera()
        startActivity<PochaActivity>()
        finish()
    }

    public override fun onResume() {
        super.onResume()
        mScannerView.setResultHandler(this)
        mScannerView.startCamera()
    }

    public override fun onPause() {
        super.onPause()
        mScannerView.stopCamera()
    }

    inner class ClickHandler {

        fun onClickFlash() {
            mScannerView.flash = !mScannerView.flash
        }
    }
}