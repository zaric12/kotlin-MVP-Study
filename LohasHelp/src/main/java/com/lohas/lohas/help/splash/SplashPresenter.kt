package com.lohas.lohas.help.splash

import android.os.CountDownTimer
import com.lohas.lohas.help.data.Splash

/**
 * this SplashPresenter : 启动页的关键协同者
 * created by zaric on 2018-06-05 11:19
 */
class SplashPresenter (val splashRepository : SplashRepository<Splash>, val splashView : SplashContract.View) :SplashContract.Presenter{

    override fun start() {

    }

    override fun loadImg() {
        splashView.showImg()
    }

    override fun loadHint() {
        countDownTime()
    }

    private fun countDownTime(){
        object : CountDownTimer(4000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                splashView.showHint((millisUntilFinished/1000).toInt())
            }

            override fun onFinish() {
                splashView.next()
            }
        }.start()
    }

}