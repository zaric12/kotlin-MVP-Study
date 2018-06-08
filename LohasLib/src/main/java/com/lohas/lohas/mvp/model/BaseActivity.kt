package com.lohas.lohas.mvp.model

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

/**
 * 基础Activity
 * created by zaric on 2018-05-31 11:17
 */
abstract class BaseActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getViewRoot())
        initPresenter()
    }

    /**
     * 初始化布局
     * created by zaric on 2018-05-10 13:41
     */
    protected abstract fun getViewRoot(): Int

    /**
     * 进行Presenter的初始化操作
     * created by zaric on 2018-05-10 13:41
     */
    protected abstract fun initPresenter()
}