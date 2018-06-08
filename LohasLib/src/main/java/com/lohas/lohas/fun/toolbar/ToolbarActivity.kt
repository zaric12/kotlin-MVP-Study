package com.lohas.lohas.`fun`.toolbar

import com.lohas.lohas.R
import com.lohas.lohas.mvp.model.BaseActivity
import com.lohas.lohas.ext.setupActionBar

/**
 * this ToolbarActivity : 带标题栏的页面
 * created by zaric on 2018-05-10 13:42
 */
abstract class ToolbarActivity : BaseActivity(){
    override fun getViewRoot(): Int {
        return R.layout.activity_parent_toolbar
    }



    /**
     * 初始化标题栏
     * created by zaric on 2018-05-10 15:58
     */
    private fun initToolbar() {
        setupActionBar(R.id.toolbar){
            if (isBack()) {
                setHomeAsUpIndicator(R.drawable.ic_back_arrow)
                setDisplayHomeAsUpEnabled(true)

            }
        }
    }

    /**
     *  判断是否显示返回按钮
     * created by zaric on 2018-05-10 13:41
     */
    protected open fun isBack() = false


}