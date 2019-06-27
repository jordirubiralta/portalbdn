package edu.jrubiralta.portalbdn.navigator

import android.app.Activity
import android.content.Intent
import edu.jrubiralta.portalbdn.navigator.android.NavParams
import edu.jrubiralta.portalbdn.ui.activity.home.HomeActivity

object Navigator {

    fun openHomePage(params: NavParams) {
        val intent = Intent(params.activity, HomeActivity::class.java)
        openHomeActivity(params.activity, intent, params.finishActivity)
    }

    private fun openHomeActivity(activity: Activity, intent: Intent, finishActivity: Boolean = true) {
        activity.startActivity(intent)
        if (finishActivity) activity.finishAffinity()
    }
}