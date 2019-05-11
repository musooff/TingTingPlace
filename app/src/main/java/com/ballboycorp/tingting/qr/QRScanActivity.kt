package com.ballboycorp.tingting.qr

import android.app.Activity
import android.os.Bundle
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.databinding.ActivityQrBinding
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
import com.google.zxing.Result
import kotlinx.android.synthetic.main.activity_qr.*
import me.dm7.barcodescanner.zxing.ZXingScannerView
import me.dm7.barcodescanner.core.ViewFinderView
import me.dm7.barcodescanner.core.IViewFinder
import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat
import com.ballboycorp.tingting.pocha.PochaActivity
import com.ballboycorp.tingting.my.create.CreateProfileActivity
import com.ballboycorp.tingting.utils.PermissionUtils
import com.ballboycorp.tingting.utils.extensions.startActivity
import com.ballboycorp.tingting.utils.extensions.startActivityForResult


/**
 * Created by musooff on 10/04/2019.
 */

class QRScanActivity: BaseActivity(), ZXingScannerView.ResultHandler {

    companion object {
        private const val REQUEST_CREATE = 1
    }

    private val viewModel by lazy { getViewModel<QRScanViewModel>() }
    private lateinit var mScannerView: ZXingScannerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = bind<ActivityQrBinding>(R.layout.activity_qr)
        binding.viewModel = viewModel
        binding.clickHandler = ClickHandler()
        initToolbar("QR코드 스캔", true)

        initialize()

    }

    private fun initialize() {
        PermissionUtils.requestCamera(this, object : PermissionUtils.OnPermissionResult {
            override fun onResult(requestCode: Int, granted: Boolean, permissions: Array<out String>) {
                if (!granted) {
                    finish()
                }
            }
        })

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
        if (viewModel.appPref.getUser() == null) {
            startActivityForResult<CreateProfileActivity>(REQUEST_CREATE)
        }
        else {
            startActivity<PochaActivity>()
            finish()
        }
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CREATE) {
            if (resultCode == Activity.RESULT_OK) {
                startActivity<PochaActivity>()
                finish()
            }
        }
    }
}