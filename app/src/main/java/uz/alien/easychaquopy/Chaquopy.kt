package uz.alien.easychaquopy


import android.app.Application
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform


class Chaquopy : Application() {

    private val context = this

    override fun onCreate() {
        super.onCreate()

        if (! Python.isStarted()) {
            Python.start(AndroidPlatform(context))
        }
    }
}