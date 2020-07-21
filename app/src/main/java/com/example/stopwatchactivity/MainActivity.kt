package com.example.stopwatchactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity(), Runnable {

    var seconds = 0
    var running = false
    val handler = Handler()
    var wasRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds")
            running = savedInstanceState.getBoolean("running")
            wasRunning = savedInstanceState.getBoolean("wasrunning")
        }
        run()
    }


    fun onClickStart(view: View) {
        running = true
    }

    fun onClickStop(view: View) {
        running = false
    }

    fun onClickReset(view:View) {
        running = false
        seconds = 0
    }


    override fun run() {
        var time_view = findViewById<TextView>(R.id.time_view)
        handler.post(Runnable(){
            var hours = seconds / 3600
            var minutes = (seconds % 3600) / 60
            var secs = seconds % 60
            var time = String.format("%d:%02d:%02d", hours, minutes, secs)
            time_view.setText(time)
            if (running) {
                seconds++
            }
            handler.postDelayed(this, 1000)
        })
    }


}




