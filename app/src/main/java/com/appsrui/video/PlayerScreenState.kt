package com.appsrui.video

import com.appsrui.video.model.Video
import com.appsrui.video.ui.ControlsListener

data class PlayerScreenState(
    val isPlaying: Boolean = false,
    val isBuffering: Boolean = false,
    val currentPosition: Long = 0L,
    val bufferedPosition: Long = 0L,
    val currentVideo: Video? = null,
    val currentSpeed: Float = 1f,
    val playlist: List<Video> = emptyList(),
    val controlsListener: ControlsListener = object : ControlsListener {},
    val videoAspectRatio: Float = 16 / 9f,
    val error: Exception? = null,
)