package com.jrubiralta.portalbdn.ui.dialog

import com.jrubiralta.portalbdn.R
import kotlinx.android.synthetic.main.dialog_logout.*

class NewsInfoDialog : BaseDialog() {

    override fun getLayoutId() = R.layout.dialog_news

    companion object {
        @JvmStatic
        fun newInstance(): LogOutDialog {
            return LogOutDialog()
        }
    }

    override fun initDialog() {
        dialog.setCanceledOnTouchOutside(true)
        btn_ok.setOnClickListener {
            this.dismiss()
        }
    }
}