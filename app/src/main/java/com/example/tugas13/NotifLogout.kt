package com.example.tugas13

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class NotifLogout : BroadcastReceiver() {
    private lateinit var prefManager: PrefManager
    override fun onReceive(context: Context?, intent: Intent?) {
        context?.let {
            // Hapus data sesi pengguna
            val prefManager = PrefManager(it)
            prefManager.clear()

            // Kembali ke halaman login
            val loginIntent = Intent(it, MainActivity::class.java)
            loginIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            it.startActivity(loginIntent)
        }
    }
}
