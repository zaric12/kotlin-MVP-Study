package com.lohas.lohas.tool

import android.text.TextUtils
import android.util.Log

/**
 * 打印Log 默认打印Log , 默认tag为类名 在Application 中初始化 即initLog Created by zaric on 2016/3/31.
 */
object LogTool {
    private val mTag = "LogTool"
    private var name: String? = null

    private val functionName: String?
        get() {
            val sts = Thread.currentThread().stackTrace ?: return null
            for (st in sts) {
                if (st.isNativeMethod) {
                    continue
                }
                return ("[" + st.fileName + ":" + st.lineNumber + "]")
            }
            return null
        }

    /**
     * 错误信息
     *
     * @param info 信息内容
     */
    fun e(info: String) {

        if (TextUtils.isEmpty(name)) {
            name = functionName
        }
        Log.e(mTag, "$name====>\n\n$info\n")

    }

    /**
     * 提示性的消息
     *
     * @param info 信息内容
     */
    fun i(info: String) {
        if (TextUtils.isEmpty(name)) {
            name = functionName
        }
        Log.i(mTag, "$name====>\n\n$info\n")
    }

    /**
     * 调试的消息
     *
     * @param info 信息内容
     */
    fun d(info: String) {

        if (TextUtils.isEmpty(name)) {
            name = functionName
        }
        Log.d(mTag, "$name====>\n\n$info\n")

    }

    /**
     * 警告消息
     *
     * @param info 信息内容
     */
    fun w(info: String) {

        if (TextUtils.isEmpty(name)) {
            name = functionName
        }
        Log.w(mTag, "$name====>\n\n$info\n")

    }


}
