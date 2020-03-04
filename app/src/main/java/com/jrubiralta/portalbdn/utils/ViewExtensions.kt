package com.jrubiralta.portalbdn.utils

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.StringRes
import com.bumptech.glide.Glide

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.enabled() {
    this.isEnabled = true
}

fun View.disabled() {
    this.isEnabled = false
}

fun View.enable() {
    this.isClickable = true
}

fun View.disable() {
    this.isClickable = false
}

fun ImageView.loadUrl(url: String?, placeholder: Int /*= R.mipmap.ic_launcher*/) { // TODO add app's placeholder
    if (url != null) {
        Glide.with(context).load(url).into(this)
    } else {
        Glide.with(context).load(placeholder).into(this)
    }
}

fun ImageView.setImage(imageRes: Int?) {
    imageRes?.let { Glide.with(context).load(imageRes).into(this) }
}

fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun Context.showToast(@StringRes resId: Int, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, this.getString(resId), duration).show()
}