package com.jrubiralta.portalbdn.Navigator

import android.app.Activity
import android.content.Intent
import com.jrubiralta.portalbdn.Navigator.android.NavParams
import com.jrubiralta.portalbdn.ui.activity.home.HomeActivity
import com.jrubiralta.portalbdn.ui.activity.login.LoginActivity
import com.jrubiralta.portalbdn.ui.activity.newIncident.NewIncidentActivity
import com.jrubiralta.portalbdn.ui.activity.registre.RegisterActivity
import com.jrubiralta.portalbdn.ui.activity.settings.SettingsActivity

object Navigator {

    fun openLoginPage(params: NavParams) {
        val intent = Intent(params.activity, LoginActivity::class.java)
        openLoginActivity(params.activity, intent, params.finishActivity)
    }

    fun openRegisterPage(params: NavParams) {
        val intent = Intent(params.activity, RegisterActivity::class.java)
        openRegisterActivity(params.activity, intent, params.finishActivity)
    }

    fun openHomePage(params: NavParams) {
        val intent = Intent(params.activity, HomeActivity::class.java)
        openHomeActivity(params.activity, intent, params.finishActivity)
    }

    fun openNewIncidentPage(params: NavParams) {
        val intent = Intent(params.activity, NewIncidentActivity::class.java)
        openNewIncidentActivity(params.activity, intent, params.finishActivity)
    }

    fun openSettingsPage(params: NavParams) {
        val intent = Intent(params.activity, SettingsActivity::class.java)
        openSettingsActivity(params.activity, intent, params.finishActivity)
    }

    private fun openLoginActivity(activity: Activity, intent: Intent, finishActivity: Boolean = true) {
        activity.startActivity(intent)
        if (finishActivity) activity.finishAffinity()
    }

    private fun openRegisterActivity(activity: Activity, intent: Intent, finishActivity: Boolean = true) {
        activity.startActivity(intent)
        if (finishActivity) activity.finishAffinity()
    }

    private fun openHomeActivity(activity: Activity, intent: Intent, finishActivity: Boolean = true) {
        activity.startActivity(intent)
        if (finishActivity) activity.finishAffinity()
    }

    private fun openNewIncidentActivity(activity: Activity, intent: Intent, finishActivity: Boolean = true) {
        activity.startActivity(intent)
        if (finishActivity) activity.finishAffinity()
    }

    private fun openSettingsActivity(activity: Activity, intent: Intent, finishActivity: Boolean = true) {
        activity.startActivity(intent)
        if (finishActivity) activity.finishAffinity()
    }
}