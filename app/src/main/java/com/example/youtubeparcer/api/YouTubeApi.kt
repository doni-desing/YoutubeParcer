package com.example.youtubeparcer.api

import com.example.youtubeparcer.model.PlaylistModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface YouTubeApi {

    @GET("youtube/v3/playlists")
    fun getPlayList(
        @Query("part") part: String,
        @Query("key") apiKey: String,
        @Query("channelId") channelId: String,
        @Query("maxResult") maxResult: String
    ): Call<PlaylistModel>
}