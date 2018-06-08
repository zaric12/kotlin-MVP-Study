package com.lohas.lohas.`fun`.toolbar

import com.lohas.lohas.mvp.presenter.BasePresenter
import com.lohas.lohas.mvp.view.BaseView

/**
 * this ToolbarContract : 基于Toolbar的基础协议
 * created by zaric on 2018-05-31 09:59
 */
interface ToolbarContract {
    interface View : BaseView<Presenter> {

    }

    interface Presenter : BasePresenter {


        fun result(requestCode :Int, resultCode:Int)
    }
}