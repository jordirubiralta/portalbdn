package edu.jrubiralta.portalbdn.navigator

import android.app.Activity
import android.content.Intent
import edu.jrubiralta.portalbdn.navigator.android.NavParams
import edu.jrubiralta.portalbdn.ui.activity.home.HomeActivity
import edu.jrubiralta.portalbdn.ui.activity.incident.NewIncidentActivity
import edu.jrubiralta.portalbdn.ui.activity.login.LoginActivity
import edu.jrubiralta.portalbdn.ui.activity.register.RegisterActivity

object Navigator {

    fun openHomePage(params: NavParams) {
        val intent = Intent(params.activity, HomeActivity::class.java)
        openHomeActivity(params.activity, intent, params.finishActivity)
    }

    fun openLoginPage(params: NavParams) {
        val intent = Intent(params.activity, LoginActivity::class.java)
        openLoginActivity(params.activity, intent, params.finishActivity)
    }

    fun openRegisterPage(params: NavParams) {
        val intent = Intent(params.activity, RegisterActivity::class.java)
        openRegisterActivity(params.activity, intent)
    }

    fun openNewIncident(params: NavParams) {
        val intent = Intent(params.activity, NewIncidentActivity::class.java)
        openActivity(params.activity, intent, params.finishActivity)
    }

    private fun openHomeActivity(activity: Activity, intent: Intent, finishActivity: Boolean = true) {
        activity.startActivity(intent)
        if (finishActivity) activity.finishAffinity()
    }

    private fun openLoginActivity(activity: Activity, intent: Intent, finishActivity: Boolean = true) {
        activity.startActivity(intent)
        if (finishActivity) activity.finishAffinity()
    }

    private fun openRegisterActivity(activity: Activity, intent: Intent, finishActivity: Boolean = true) {
        activity.startActivity(intent)
        if (finishActivity) activity.finishAffinity()
    }

    private fun openActivity(activity: Activity, intent: Intent, finishActivity: Boolean = true) {
        activity.startActivity(intent)
        if (finishActivity) activity.finish()
    }

}