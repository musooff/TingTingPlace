package com.ballboycorp.tingting.pocha.details.dialog

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.ballboycorp.tingting.databinding.DialogShareBinding
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.getViewModel
import android.content.pm.PackageManager
import com.ballboycorp.tingting.utils.extensions.showToast
import android.content.ClipData
import android.content.Context.CLIPBOARD_SERVICE
import android.content.ClipboardManager
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.utils.extensions.copyToClipBoard


/**
 * Created by musooff on 18/04/2019.
 */

class ShareDialog: DialogFragment() {

    private val viewModel by lazy { getViewModel<ShareViewHolder>() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = bind<DialogShareBinding>(inflater, R.layout.dialog_share, container)
        binding.viewModel = viewModel
        binding.clickHandler = ClickHandler()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    inner class ClickHandler {
        fun onClickShare(type: Int) {
            when (type) {
                0 -> sendKAKAO()
                1 -> sendSMS()
                2 -> copyUrl()
            }
            dismiss()
        }

        fun onClickExit() {
            dismiss()
        }
    }

    fun sendSMS() {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.type = "vnd.android-dir/mms-sms"
        intent.putExtra("sms_body", "TinTingPlace")
        startActivity(intent)
    }

    fun sendKAKAO() {
        val pm = context?.packageManager ?: return
        try {
            val kakaoPackageId = "com.kakao.talk"
            pm.getPackageInfo(kakaoPackageId, PackageManager.GET_ACTIVITIES)
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.setPackage(kakaoPackageId)
            intent.putExtra(Intent.EXTRA_TEXT, "TinTingPlace")
            startActivity(Intent.createChooser(intent, "Share with"))
        }catch (ex: PackageManager.NameNotFoundException) {
            context?.showToast("Kakao not installed")
        }
    }

    fun copyUrl() {
        context?.copyToClipBoard("Some text")
        context?.showToast("It has been copied to the clipboard")

    }
}