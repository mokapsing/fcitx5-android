package me.rocka.fcitx5test

import android.app.Activity
import android.os.Bundle
import android.util.Log
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class MainActivity : Activity() {
    private fun copyFileOrDir(path: String) {
        val assetManager = this.assets
        try {
            val assets = assetManager.list(path)
            if (assets!!.isEmpty()) {
                copyFile(path)
            } else {
                val dir = File("${applicationInfo.dataDir}/${path}")
                if (!dir.exists()) dir.mkdir()
                for (i in assets.indices) {
                    copyFileOrDir("${path}/${assets[i]}")
                }
            }
        } catch (ex: IOException) {
            Log.e("CopyFile", "I/O Exception", ex)
        }
    }

    private fun copyFile(filename: String) {
        val assetManager = this.assets
        try {
            val source = assetManager.open(filename)
            val target = FileOutputStream("${applicationInfo.dataDir}/${filename}")
            val buffer = ByteArray(1024)
            var read: Int
            while (source.read(buffer).also { read = it } != -1) {
                target.write(buffer, 0, read)
            }
            source.close()
            target.flush()
            target.close()
        } catch (e: Exception) {
            Log.e("CopyFile", e.message ?: "Unknown error")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        copyFileOrDir("fcitx5")
        startupFcitx(
            applicationInfo.dataDir,
            applicationInfo.nativeLibraryDir,
            getExternalFilesDir(null)!!.absolutePath + "/config",
            "${applicationInfo.dataDir}/fcitx5/libime"
        )
    }

    private external fun startupFcitx(
        appData: String,
        appLib: String,
        extData: String,
        appDataLibime: String
    )

    private external fun sendKeyToFcitx(key: String)

    companion object {
        init {
            System.loadLibrary("native-lib")
        }
    }
}