package dev.steklo.schet

import android.app.Application
import android.content.pm.ApplicationInfo
import android.os.StrictMode
import dagger.hilt.android.HiltAndroidApp
import android.os.StrictMode.ThreadPolicy.Builder as ThreadBuilder
import android.os.StrictMode.VmPolicy.Builder as VmBuilder

/**
 * [Application] class for Schet
 */
@HiltAndroidApp
public class SchetApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        setStrictModePolicy()
    }

    /**
     * Return true if the application is debuggable.
     */
    private fun isDebuggable(): Boolean = 0 != applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE

    /**
     * Set a thread policy that detects all potential problems on the main thread, such as network
     * and disk access.
     *
     * If a problem is found, the offending call will be logged and the application will be killed.
     */
    private fun setStrictModePolicy() {
        if (isDebuggable()) {
            StrictMode.setThreadPolicy(
                ThreadBuilder().detectAll().penaltyLog().build(),
            )
            StrictMode.setVmPolicy(
                VmBuilder().detectAll().penaltyLog().build(),
            )
        }
    }
}
