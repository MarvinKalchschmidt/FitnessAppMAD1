package de.hdmstuttgart.fitnessappmad1.activity

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import de.hdmstuttgart.fitnessappmad1.R
import de.hdmstuttgart.fitnessappmad1.fragments.HomeFragment
import de.hdmstuttgart.fitnessappmad1.fragments.CountdownFragment

class MainActivity : AppCompatActivity() {

    val CHANNEL_ID = "channelID"
    val CHANNEL_NAME = "channelName"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createNotificationChannel()

        supportFragmentManager.beginTransaction().apply {
            val homeFragment = HomeFragment()
            val timerFragment = CountdownFragment()
            replace(R.id.flFragment, timerFragment)
            commit()
        }
    }

    fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID, CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }
}