package edu.jrubiralta.portalbdn.ui.view

import android.content.Context

interface View {
    fun goToSplash(invalidateToken: Boolean = false)
    fun getCtx(): Context
    fun showErrorServer()
    fun showError(message: String)
    fun showErrorApp()
}
