package com.lohas.lohas.mvp.view

/**
 * this BaseView : MVP 模式下的视图逻辑层
 * created by zaric on 2018-05-30 15:37
 */
interface BaseView<T> {
    /**
     * 定义业务逻辑层的对象
     * created by zaric on 2018-05-30 15:39
     */
    var presenter :T

    /**
     * 显示等待框
     */
    fun showLoading()

    /**
     * 关闭等待框
     */
    fun dismissLoading()
}