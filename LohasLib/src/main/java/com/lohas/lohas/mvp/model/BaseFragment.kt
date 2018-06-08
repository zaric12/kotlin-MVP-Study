package com.lohas.lohas.mvp.model

import android.content.Context
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * this BaseFragment :
 * created by zaric on 2018-05-24 08:35
 */
abstract class BaseFragment : Fragment() {
    lateinit var act:BaseActivity


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        act= context as BaseActivity

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getRootView(),container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
        initData()
    }


    /**
     * 加载根布局
     * created by zaric on 2018-05-24 08:45
     */
    abstract fun getRootView():Int
    /**
     * 控件初始化
     * created by zaric on 2018-05-24 08:51
     */
    abstract fun initView()

    /**
     * 数据初始化
     * created by zaric on 2018-05-24 08:52
     */
    abstract fun initData()
    
    /**
     * 绑定控件
     * created by zaric on 2018-05-24 08:46
     */
     fun <T : View> findViewById(@IdRes id: Int): T? {
        return view!!.findViewById(id)
    }
}