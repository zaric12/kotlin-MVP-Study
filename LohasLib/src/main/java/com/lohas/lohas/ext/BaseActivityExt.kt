package com.lohas.lohas.ext

import android.support.annotation.IdRes
import android.support.v7.app.ActionBar
import com.lohas.lohas.mvp.model.BaseActivity

/**
 * this BaseActivityExt : 针对BaseActivity的扩展
 * created by zaric on 2018-05-30 15:13
 */

fun BaseActivity.setupActionBar(@IdRes toolbarId: Int, action: ActionBar.() -> Unit) {
    setSupportActionBar(findViewById(toolbarId))

    supportActionBar?.run {
        action()
    }
}