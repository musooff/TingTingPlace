package com.ballboycorp.tingting.main.more

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.ballboycorp.tingting.R
import com.ballboycorp.tingting.base.BaseActivity
import com.ballboycorp.tingting.base.BaseFragment
import com.ballboycorp.tingting.contact.ContactActivity
import com.ballboycorp.tingting.databinding.FragmentMoreBinding
import com.ballboycorp.tingting.event.EventActivity
import com.ballboycorp.tingting.notice.NoticeActivity
import com.ballboycorp.tingting.utils.extensions.bind
import com.ballboycorp.tingting.utils.extensions.startActivity
import kotlinx.android.synthetic.main.toolbar.*
import kotlinx.android.synthetic.main.toolbar.view.*

/**
 * Created by musooff on 08/04/2019.
 */

class MoreFragment: BaseFragment() {

    companion object {

        private const val FRAGMENT_TAG = "more_fragment"

        fun replace(fragmentActivity: FragmentActivity) {
            val manager = fragmentActivity.supportFragmentManager
            val transaction = manager.beginTransaction()
            val fragment = MoreFragment()
            transaction.replace(R.id.container_main, fragment, FRAGMENT_TAG)
                    .commit()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = bind<FragmentMoreBinding>(inflater, R.layout.fragment_more, container)
        binding.clickHandler = ClickHandler()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tb_title.text = "더보기"
    }

    inner class ClickHandler {
        fun onClickNotice() {
            startActivity<NoticeActivity>()
        }

        fun onClickEvent() {
            startActivity<EventActivity>()
        }

        fun onClickContact() {
            startActivity<ContactActivity>()

        }

        fun onClickPreference() {

        }
    }
}