package com.lohas.wifi

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.p2p.WifiP2pDevice
import android.net.wifi.p2p.WifiP2pManager

/**
 * this WifiDirectReceiver :
 * created by zaric on 2018-06-04 11:09
 */
class WifiDirectReceiver :BroadcastReceiver() {


    /**
     * 写一个便捷的注册方法，动态注册的时候就不用写intentFilter了
     */
    fun registerReceiver(context: Context) {
        val intentFilter = IntentFilter()
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION)
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION)
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION)
        intentFilter.addAction(WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION)
        context.registerReceiver(this, intentFilter)
    }
    override fun onReceive(context: Context?, intent: Intent?) {
        when (intent?.action) {
        /**
         *当Wifi功能打开或关闭的时候系统会发送 WIFI_P2P_STATE_CHANGED_ACTION 广播
         * Tip: 并不是指是否已经成功连上WI-FI
         */
            WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION -> {
            }
        /**
         * 当前设备的详细信息发生变化的时候，系统会发送 WIFI_P2P_THIS_DEVICE_CHANGED_ACTION 广播
         */
            WifiP2pManager.WIFI_P2P_THIS_DEVICE_CHANGED_ACTION -> {
                val device: WifiP2pDevice = intent.getParcelableExtra(WifiP2pManager.EXTRA_WIFI_P2P_DEVICE)
                println(device)
            }

        /**
         * 当可连接的对等节点列表发生改变的时候，系统会发送 WIFI_P2P_PEERS_CHANGED_ACTION 广播
         * invoke when the list of peers find, register, lost
         */
            WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION -> {
            }
        /**
         * 当一个连接建立或断开的时候，系统会发送该广播
         * This action received when the connection setup or dis-setup
         */
            WifiP2pManager.WIFI_P2P_CONNECTION_CHANGED_ACTION -> {
            }
        }
    }

}
