package com.lohas.lohas.help.splash

import com.lohas.lohas.mvp.presenter.BasePresenter
import com.lohas.lohas.mvp.view.BaseView

/**
 * this SplashContract : 启动页-协议约定接口
 * created by zaric on 2018-06-05 10:16
 */
interface SplashContract {


    interface View : BaseView<Presenter> {
        fun showImg()

        fun showHint(progress: Int)

        fun next()
    }
    
    /**
     * 业务逻辑处理接口
     * created by zaric on 2018-06-05 10:23
     */
    interface Presenter : BasePresenter {
        fun loadImg()

        fun loadHint()
    }
}