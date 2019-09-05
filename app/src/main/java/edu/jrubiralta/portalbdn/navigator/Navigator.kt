package edu.jrubiralta.portalbdn.navigator

import android.app.Activity
import android.content.Intent
import edu.jrubiralta.portalbdn.navigator.android.NavParams
import edu.jrubiralta.portalbdn.ui.activity.home.HomeActivity
import edu.jrubiralta.portalbdn.ui.activity.incident.NewIncidentActivity

object Navigator {

    fun openHomePage(params: NavParams) {
        val intent = Intent(params.activity, HomeActivity::class.java)
        openHomeActivity(params.activity, intent, params.finishActivity)
    }

    fun openNewIncident(params: NavParams) {
        val intent = Intent(params.activity, NewIncidentActivity::class.java)
        openActivity(params.activity, intent, params.finishActivity)
    }

    private fun openHomeActivity(activity: Activity, intent: Intent, finishActivity: Boolean = true) {
        activity.startActivity(intent)
        if (finishActivity) activity.finishAffinity()
    }

    private fun openActivity(activity: Activity, intent: Intent, finishActivity: Boolean = true) {
        activity.startActivity(intent)
        if (finishActivity) activity.finish()
    }

}