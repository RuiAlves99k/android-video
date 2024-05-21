package com.appsrui.video

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.OptIn
import androidx.media3.common.AudioAttributes
import androidx.media3.common.C
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.session.MediaSession
import com.appsrui.video.ui.PlayerScreen
import com.appsrui.video.ui.theme.VideoTheme

class MainActivity : ComponentActivity() {
    private lateinit var mediaSession: MediaSession
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupMediaSession()
        setContent {
            VideoTheme {
                PlayerScreen(player = mediaSession.player, token = mediaSession.token)
            }
        }
    }

    @OptIn(UnstableApi::class)
    private fun setupMediaSession() {
        val audioAttributes = AudioAttributes.Builder()
            .setUsage(C.USAGE_MEDIA)
            .setContentType(C.AUDIO_CONTENT_TYPE_MOVIE)
            .build()

        val player = ExoPlayer.Builder(this)
            .setAudioAttributes(audioAttributes, true)
            .setHandleAudioBecomingNoisy(true)
            .setVideoScalingMode(C.VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING)
            .build()

        player.addListener(object: Player.Listener{
            override fun onIsPlayingChanged(isPlaying: Boolean) {
               // TODO: Add/Remove window FLAG_KEEP_SCREEN_ON
            }
        })

        mediaSession = MediaSession.Builder(this, player).build()
    }

    override fun onDestroy() {
        mediaSession.player.release()
        mediaSession.release()
        super.onDestroy()
    }
}