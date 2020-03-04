package com.jrubiralta.portalbdn.ui.dialog

import com.jrubiralta.portalbdn.R
import kotlinx.android.synthetic.main.dialog_logout.*

class LogOutDialog : BaseDialog() {

    override fun getLayoutId() = R.layout.dialog_logout

    var listener: LogoutDialogListener? = null

    companion object {
        @JvmStatic
        fun newInstance(listener: LogoutDialogListener? = null): LogOutDialog {
            val fragment = LogOutDialog()
            fragment.setData(listener)
            return fragment
        }
    }

    override fun initDialog() {
        dialog.setCanceledOnTouchOutside(true)
        btn_cancel.setOnClickListener {
            this.dismiss()
        }
        btn_ok.setOnClickListener {
            listener?.onOkClicked()
            this.dismiss()
        }
    }

    private fun setData(listener: LogoutDialogListener?) {
        this.listener = listener
    }

    interface LogoutDialogListener {
        fun onOkClicked()
    }

}