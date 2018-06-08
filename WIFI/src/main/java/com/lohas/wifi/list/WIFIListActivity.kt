package com.lohas.wifi.list

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.lohas.wifi.R
import com.lohas.wifi.WifiDirectReceiver

class WIFIListActivity : AppCompatActivity() {
    private val wifiDirectReceiver=WifiDirectReceiver()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wifi_list)

    }

    override fun onStart() {
        super.onStart()
        wifiDirectReceiver.registerReceiver(this)
    }
    override fun onStop() {
        super.onStop()
        unregisterReceiver(wifiDirectReceiver)
    }
}
