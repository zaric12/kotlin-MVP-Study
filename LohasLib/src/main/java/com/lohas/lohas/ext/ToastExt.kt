package com.lohas.lohas.ext

import android.annotation.SuppressLint
import android.support.annotation.IdRes
import android.widget.Toast
import com.lohas.lohas.mvp.model.BaseActivity

/**
 * this ToastExt : 弹出提示框扩展
 * created by zaric on 2018-05-31 09:42
 */
fun BaseActivity.showLongToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun BaseActivity.showShortToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

@SuppressLint("ResourceType")
fun BaseActivity.showLongToast(@IdRes resMsg: Int) {
    Toast.makeText(this, getString(resMsg), Toast.LENGTH_LONG).show()
}

@SuppressLint("ResourceType")
fun BaseActivity.showShortToast(@IdRes resMsg: Int) {
    Toast.makeText(this, getString(resMsg), Toast.LENGTH_SHORT).show()
}