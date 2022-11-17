package com.example.ijkplayer

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import tv.danmaku.ijk.media.player.IMediaPlayer
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private var videoPlayer: VideoPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        videoPlayer = findViewById(R.id.video)
//        videoPlayer.setVideoListener(new )
        videoPlayer?.setPath("http://ipfs.ztgame.com.cn/QmRRGU4aUZEqJsHxKzBb1ns97GHw45eCRRZFe6Eu8GCmZ4.m3u8")
        try {
            videoPlayer?.load()
        } catch (e: IOException) {
            Toast.makeText(this, "播放失败", Toast.LENGTH_SHORT)
            e.printStackTrace()
        }
    }

    fun onBufferingUpdate(iMediaPlayer: IMediaPlayer?, i: Int) {}

    fun onCompletion(iMediaPlayer: IMediaPlayer?) {}

    fun onError(iMediaPlayer: IMediaPlayer?, i: Int, i1: Int): Boolean {
        return false
    }

    fun onInfo(iMediaPlayer: IMediaPlayer?, i: Int, i1: Int): Boolean {
        return false
    }

    fun onPrepared(iMediaPlayer: IMediaPlayer?) {
        videoPlayer?.start()
    }

    fun onSeekComplete(iMediaPlayer: IMediaPlayer?) {}

    fun onVideoSizeChanged(iMediaPlayer: IMediaPlayer?, i: Int, i1: Int, i2: Int, i3: Int) {}
}