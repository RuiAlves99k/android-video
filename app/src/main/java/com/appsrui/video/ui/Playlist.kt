package com.appsrui.video.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.appsrui.video.model.Video
import com.appsrui.video.model.VideoList
import com.appsrui.video.ui.theme.VideoTheme

@Composable
fun Playlist(
    videos: List<Video>,
    modifier: Modifier = Modifier,
    onVideoClick: (Video) -> Unit = {},
) {
    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(1.dp)
    ) {
        items(videos, { it.id }) {video ->
            VideoListItem(
                modifier = Modifier.clickable { onVideoClick(video) },
                video = video,
            )
        }
    }
}

@Preview
@Composable
fun PlaylistPreview(){
    VideoTheme {
        Playlist(videos = VideoList)
    }
}