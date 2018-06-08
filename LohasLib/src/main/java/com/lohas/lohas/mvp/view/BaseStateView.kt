package com.lohas.lohas.mvp.view

/**
 * this BaseStateView :
 * created by zaric on 2018-06-07 14:07
 */
interface BaseStateView<T> :BaseView<T> {

    /**
     * 显示错误页面
     */
    fun showErrorLayout()

    /**
     * 显示重试页面
     */
    fun showRetryLayout()

    /**
     * 显示空页面
     */
    fun showEmptyLayout()
}