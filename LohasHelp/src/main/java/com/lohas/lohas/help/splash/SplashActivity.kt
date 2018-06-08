package com.lohas.lohas.help.splash

import android.annotation.SuppressLint
import android.graphics.drawable.AnimationDrawable
import android.support.v4.content.ContextCompat
import android.view.View
import com.lohas.lohas.help.Injection
import com.lohas.lohas.help.R
import com.lohas.lohas.mvp.model.BaseActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.splash_act.*


/**
 * 启动页
 * created by zaric on 2018-06-01 14:33
 */
class SplashActivity : BaseActivity(), SplashContract.View {
    override fun next() {

    }


    override lateinit var presenter: SplashContract.Presenter

    override fun getViewRoot(): Int {
        return R.layout.splash_act
    }


    override fun initPresenter() {
        presenter = SplashPresenter(Injection.provideSplashRepository(this), this)

        presenter.loadImg()
        presenter.loadHint()
    }


    override fun onResume() {
        super.onResume()
        presenter.start()
    }

    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun showImg() {

        Picasso.with(this).load("http://www.qrcb.com.cn/qrcbcms/u/cms/www/201806/04161056mswr.jpg").into(splashIv)
        val animationDrawable = ContextCompat.getDrawable(this, R.drawable.loading) as AnimationDrawable
        loadIv.setImageDrawable(animationDrawable)
        animationDrawable.start()
    }

    @SuppressLint("SetTextI18n")
    override fun showHint(progress: Int) {
        loadTv.text = "$progress S"
    }

    override fun showLoading() {
    }

    override fun dismissLoading() {

    }

}
